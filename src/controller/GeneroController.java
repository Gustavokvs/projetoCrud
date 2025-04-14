package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Genero;

public class GeneroController {

    // Método para inserir um gênero no banco de dados
    public boolean inserir(Genero genero) {
        String sql = "INSERT INTO genero (nome) VALUES (?)";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, genero.getNome());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public Genero buscarPorNome(String nomeGenero) {
        String sql = "SELECT * FROM genero WHERE nome = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, nomeGenero);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Genero genero = new Genero();
                genero.setId(resultado.getInt("id"));
                genero.setNome(resultado.getString("nome"));
                return genero;
            } else {
                System.out.println("Nenhum gênero encontrado com o nome: " + nomeGenero);  // Mensagem de depuração
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return null;  // Retorna null se não encontrar
    }

    // Método para atualizar um gênero
    public boolean atualizar(Genero genero) {
        String sql = "UPDATE genero SET nome = ? WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, genero.getNome());
            comando.setInt(2, genero.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para excluir um gênero
    public boolean excluir(int id) {
        String sql = "DELETE FROM genero WHERE id = ?";
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

    // Método para buscar um gênero pelo ID
    public Genero buscarPorId(int id) {
        String sql = "SELECT * FROM genero WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Genero genero = new Genero();
                genero.setId(resultado.getInt("id"));
                genero.setNome(resultado.getString("nome"));
                return genero;
            } else {
                System.out.println("Nenhum gênero encontrado com o ID: " + id);  // Mensagem de depuração
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return null;
    }

    // Método para listar todos os gêneros
    public ArrayList<Genero> listarTodos() {
        String sql = "SELECT * FROM genero";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Genero> lista = new ArrayList<>();

        try {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Genero genero = new Genero();
                genero.setId(resultado.getInt("id"));
                genero.setNome(resultado.getString("nome"));
                lista.add(genero);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }
}
