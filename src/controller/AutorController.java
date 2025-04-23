package controller;

import java.sql.*;
import java.util.ArrayList;
import model.Autor;

public class AutorController {

    // Método para inserir um autor no banco de dados
    public boolean inserir(Autor autor) {
        String sql = "INSERT INTO autor (nome) VALUES (?)";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, autor.getNome());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para atualizar um autor
    public boolean atualizar(Autor autor) {
        String sql = "UPDATE autor SET nome = ? WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, autor.getNome());
            comando.setInt(2, autor.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para excluir um autor
    public boolean excluir(int id) {
        String sql = "DELETE FROM autor WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
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

    // Método para buscar um autor pelo ID
    public Autor buscarPorId(int id) {
        String sql = "SELECT * FROM autor WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                return new Autor(
                        resultado.getInt("id"),
                        resultado.getString("nome")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return null;
    }

    // Método para listar todos os autores
    public ArrayList<Autor> listarTodos() {
        String sql = "SELECT * FROM autor";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Autor> lista = new ArrayList<>();

        try {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                lista.add(new Autor(
                        resultado.getInt("id"),
                        resultado.getString("nome")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }

    // Método para buscar autores pelo nome
    public ArrayList<Autor> buscarPorNome(String nome) {
        String sql = "SELECT * FROM autor WHERE nome LIKE ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Autor> lista = new ArrayList<>();

        try {
            // Usamos o LIKE para buscar qualquer autor cujo nome contenha o valor fornecido
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                lista.add(new Autor(
                        resultado.getInt("id"),
                        resultado.getString("nome")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }

}
