package controller;

import model.Livro;
import controller.GerenciadorConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Genero;

public class LivroController {

    public String getNomeCategoria(List<Integer> idsCategorias) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        StringBuilder nomesCategorias = new StringBuilder();

        for (int i = 0; i < idsCategorias.size(); i++) {
            int idCategoria = idsCategorias.get(i);
            String sql = "SELECT nome FROM genero WHERE id = ?";

            try (PreparedStatement pst = conexao.prepararComando(sql)) {
                pst.setInt(1, idCategoria);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        if (i > 0) {
                            nomesCategorias.append(", ");
                        }
                        nomesCategorias.append(rs.getString("nome"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return nomesCategorias.toString();
    }

    public boolean inserir(Livro livro, String categorias) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "INSERT INTO livro (titulo, isbn, preco, ano_publicacao, id_autor) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conexao.prepararComando(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = null;

        try {
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getIsbn());
            pst.setDouble(3, livro.getPreco());
            pst.setInt(4, livro.getAnoPublicacao());
            pst.setInt(5, livro.getIdAutor());

            int affectedRows = pst.executeUpdate();

            if (affectedRows > 0) {
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    livro.setId(idGerado);

                    if (categorias != null && !categorias.isEmpty()) {
                        String[] idsCategorias = categorias.split(",");
                        for (String idCategoria : idsCategorias) {
                            String sqlCategoria = "INSERT INTO livro_genero (id_livro, id_genero) VALUES (?, ?)";
                            try (PreparedStatement pstCategoria = conexao.prepararComando(sqlCategoria)) {
                                pstCategoria.setInt(1, idGerado);
                                pstCategoria.setInt(2, Integer.parseInt(idCategoria));
                                pstCategoria.executeUpdate();
                            }
                        }
                    }

                    return true;
                }
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            String sqlGenero = "DELETE FROM livro_genero WHERE id_livro = ?";
            PreparedStatement comandoGenero = conexao.prepararComando(sqlGenero);
            comandoGenero.setInt(1, id);
            comandoGenero.executeUpdate();
            comandoGenero.close();

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
        String sql = "SELECT COUNT(*) FROM genero WHERE id IN (" + String.join(",", idsCategorias.stream().map(String::valueOf).toArray(String[]::new)) + ")";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;

        try {
            resultado = comando.executeQuery();
            if (resultado.next()) {
                int count = resultado.getInt(1);
                return count == idsCategorias.size();
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

    public boolean salvar(Livro livro) {
        String categoriasString = livro.getCategorias();
        List<Integer> categorias = new ArrayList<>();

        for (String categoria : categoriasString.split(",")) {
            categorias.add(Integer.parseInt(categoria.trim()));
        }

        if (!verificarCategoria(categorias)) {
            System.out.println("Uma ou mais categorias são inválidas.");
            return false;
        }

        if (livro.getId() == 0) {
            return inserir(livro, categoriasString);
        } else {
            return atualizar(livro);
        }
    }

    public void atualizarCategorias(int livroId, List<Integer> novaListaDeCategorias) throws SQLException {
        GerenciadorConexao conexao = new GerenciadorConexao();

// Passo 1: Remover as categorias antigas
        String deleteQuery = "DELETE FROM livro_genero WHERE livro_id = ?";
        try (PreparedStatement deleteStmt = conexao.prepararComando(deleteQuery)) {
            deleteStmt.setInt(1, livroId);
            deleteStmt.executeUpdate();
        }

        // Passo 2: Inserir as novas categorias
        String insertQuery = "INSERT INTO livro_genero (livro_id, genero_id) VALUES (?, ?)";
        try (PreparedStatement insertStmt = conexao.prepararComando(insertQuery)) {
            for (Integer categoriaId : novaListaDeCategorias) {
                insertStmt.setInt(1, livroId);
                insertStmt.setInt(2, categoriaId);
                insertStmt.executeUpdate();
            }
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
