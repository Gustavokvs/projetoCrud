package controller;

import model.Livro;
import controller.GerenciadorConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Genero;

public class LivroController {

    public boolean inserir(Livro livro) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sqlLivro = "INSERT INTO livro (titulo, isbn, preco, ano_publicacao, id_autor) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement comandoLivro = conexao.prepararComando(sqlLivro);
        ResultSet rs = null;

        try {
            comandoLivro.setString(1, livro.getTitulo());
            comandoLivro.setString(2, livro.getIsbn());
            comandoLivro.setDouble(3, livro.getPreco());
            comandoLivro.setInt(4, livro.getAnoPublicacao());
            comandoLivro.setInt(5, livro.getIdAutor());

            comandoLivro.executeUpdate();

            rs = comandoLivro.getGeneratedKeys();
            if (rs.next()) {
                int idLivro = rs.getInt(1);
                livro.setId(idLivro);

                // Inserir gêneros na tabela livro_genero
                if (livro.getIdsCategorias() != null) {
                    for (int idGenero : livro.getIdsCategorias()) {
                        String sqlGenero = "INSERT INTO livro_genero (id_livro, id_genero) VALUES (?, ?)";
                        PreparedStatement comandoGenero = conexao.prepararComando(sqlGenero);
                        comandoGenero.setInt(1, idLivro);
                        comandoGenero.setInt(2, idGenero);
                        comandoGenero.executeUpdate();
                        comandoGenero.close();
                    }
                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comandoLivro, rs);
        }
    }

    public boolean atualizar(Livro livro) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "UPDATE livro SET titulo = ?, isbn = ?, preco = ?, ano_publicacao = ?, id_autor = ? WHERE id = ?";
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, livro.getTitulo());
            comando.setString(2, livro.getIsbn());
            comando.setDouble(3, livro.getPreco());
            comando.setInt(4, livro.getAnoPublicacao());
            comando.setInt(5, livro.getIdAutor());
            comando.setInt(6, livro.getId());
            comando.executeUpdate();

            // Atualiza os gêneros (remove os antigos e insere os novos)
            String sqlDelete = "DELETE FROM livro_genero WHERE id_livro = ?";
            PreparedStatement comandoDelete = conexao.prepararComando(sqlDelete);
            comandoDelete.setInt(1, livro.getId());
            comandoDelete.executeUpdate();
            comandoDelete.close();

            if (livro.getIdsCategorias() != null) {
                for (int idGenero : livro.getIdsCategorias()) {
                    String sqlInsert = "INSERT INTO livro_genero (id_livro, id_genero) VALUES (?, ?)";
                    PreparedStatement comandoInsert = conexao.prepararComando(sqlInsert);
                    comandoInsert.setInt(1, livro.getId());
                    comandoInsert.setInt(2, idGenero);
                    comandoInsert.executeUpdate();
                    comandoInsert.close();
                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public boolean excluir(int id) {
        GerenciadorConexao conexao = new GerenciadorConexao();

        try {
            // Exclui os registros da tabela livro_genero primeiro
            String sqlGenero = "DELETE FROM livro_genero WHERE id_livro = ?";
            PreparedStatement comandoGenero = conexao.prepararComando(sqlGenero);
            comandoGenero.setInt(1, id);
            comandoGenero.executeUpdate();
            comandoGenero.close();

            // Depois exclui o livro
            String sqlLivro = "DELETE FROM livro WHERE id = ?";
            PreparedStatement comandoLivro = conexao.prepararComando(sqlLivro);
            comandoLivro.setInt(1, id);
            comandoLivro.executeUpdate();
            comandoLivro.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Livro buscarPorId(int id) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT * FROM livro WHERE id = ?";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;
        Livro livro = null;

        try {
            comando.setInt(1, id);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                livro = new Livro();
                livro.setId(resultado.getInt("id"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setIsbn(resultado.getString("isbn"));
                livro.setPreco(resultado.getDouble("preco"));
                livro.setAnoPublicacao(resultado.getInt("ano_publicacao"));
                livro.setIdAutor(resultado.getInt("id_autor"));
                livro.setIdsCategorias(buscarIdsGenerosPorLivro(id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return livro;
    }

    public ArrayList<Livro> listarTodos() {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT * FROM livro";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;
        ArrayList<Livro> lista = new ArrayList<>();

        try {
            resultado = comando.executeQuery();
            while (resultado.next()) {
                Livro livro = new Livro();
                livro.setId(resultado.getInt("id"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setIsbn(resultado.getString("isbn"));
                livro.setPreco(resultado.getDouble("preco"));
                livro.setAnoPublicacao(resultado.getInt("ano_publicacao"));
                livro.setIdAutor(resultado.getInt("id_autor"));
                livro.setIdsCategorias(buscarIdsGenerosPorLivro(livro.getId()));

                lista.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return lista;
    }

    public boolean verificarCategoria(List<Integer> idsCategorias) {
        if (idsCategorias == null || idsCategorias.isEmpty()) {
            return false;
        }

        GeneroController generoController = new GeneroController();
        // Criar a query de forma dinâmica com a quantidade de categorias
        String sql = "SELECT COUNT(*) FROM genero WHERE id IN (" + String.join(",", idsCategorias.stream().map(String::valueOf).toArray(String[]::new)) + ")";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;

        try {
            resultado = comando.executeQuery();
            if (resultado.next()) {
                int count = resultado.getInt(1);
                return count == idsCategorias.size();  // Verifica se todas as categorias são válidas
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return false;
    }
    
    public boolean adicionarCategoriaAoLivro(int idLivro, int idGenero) {
    GerenciadorConexao conexao = new GerenciadorConexao();
    String sql = "INSERT INTO livro_genero (id_livro, id_genero) VALUES (?, ?)";
    PreparedStatement comando = conexao.prepararComando(sql);
    try {
        comando.setInt(1, idLivro);
        comando.setInt(2, idGenero);
        comando.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        conexao.fecharConexao(comando);
    }
}


    private ArrayList<Integer> buscarIdsGenerosPorLivro(int idLivro) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT id_genero FROM livro_genero WHERE id_livro = ?";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;
        ArrayList<Integer> ids = new ArrayList<>();

        try {
            comando.setInt(1, idLivro);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                ids.add(resultado.getInt("id_genero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return ids;
    }
}
