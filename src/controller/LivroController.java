package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livro;

public class LivroController {

    public boolean inserir(Livro livro) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "INSERT INTO livro (titulo, preco, id_autor, categoria, isbn, ano_publicacao) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setString(1, livro.getTitulo());
            comando.setDouble(2, livro.getPreco());
            comando.setInt(3, livro.getIdAutor());
            comando.setString(4, livro.getCategoria());
            comando.setString(5, livro.getIsbn());
            comando.setInt(6, livro.getAnoPublicacao());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public boolean atualizar(Livro livro) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "UPDATE livro SET titulo = ?, preco = ?, id_autor = ?, categoria = ?, isbn = ?, ano_publicacao = ? WHERE id = ?";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setString(1, livro.getTitulo());
            comando.setDouble(2, livro.getPreco());
            comando.setInt(3, livro.getIdAutor());
            comando.setString(4, livro.getCategoria());
            comando.setString(5, livro.getIsbn());
            comando.setInt(6, livro.getAnoPublicacao());
            comando.setInt(7, livro.getId());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public boolean excluir(int id) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "DELETE FROM livro WHERE id = ?";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setInt(1, id);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public boolean adicionarGenerosAoLivro(int idLivro, List<Integer> idsGeneros) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "INSERT INTO livro_genero (id_livro, id_genero) VALUES (?, ?)";
        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            for (int idGenero : idsGeneros) {
                comando.setInt(1, idLivro);
                comando.setInt(2, idGenero);
                comando.addBatch();
            }
            comando.executeBatch();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public List<String> buscarGenerosDoLivro(int idLivro) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT g.nome FROM genero g " +
                     "INNER JOIN livro_genero lg ON g.id = lg.id_genero " +
                     "WHERE lg.id_livro = ?";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;
        List<String> generos = new ArrayList<>();
        try {
            comando.setInt(1, idLivro);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                generos.add(resultado.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }
        return generos;
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
                livro.setPreco(resultado.getDouble("preco"));
                livro.setIdAutor(resultado.getInt("id_autor"));
                livro.setCategoria(resultado.getString("categoria"));
                livro.setIsbn(resultado.getString("isbn"));
                livro.setAnoPublicacao(resultado.getInt("ano_publicacao"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
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
                livro.setPreco(resultado.getDouble("preco"));
                livro.setIdAutor(resultado.getInt("id_autor"));
                livro.setCategoria(resultado.getString("categoria"));
                livro.setIsbn(resultado.getString("isbn"));
                livro.setAnoPublicacao(resultado.getInt("ano_publicacao"));
                lista.add(livro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return lista;
    }
}
