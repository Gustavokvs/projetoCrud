package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

public class FuncionarioController {

    // Método para inserir um funcionário no banco de dados
    public boolean inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cargo, email, telefone, ativo) VALUES (?, ?, ?, ?, ?)";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCargo());
            comando.setString(3, funcionario.getEmail());
            comando.setString(4, funcionario.getTelefone());
            comando.setBoolean(5, funcionario.isAtivo());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para atualizar um funcionário
    public boolean atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ?, email = ?, telefone = ?, ativo = ? WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCargo());
            comando.setString(3, funcionario.getEmail());
            comando.setString(4, funcionario.getTelefone());
            comando.setBoolean(5, funcionario.isAtivo());
            comando.setInt(6, funcionario.getId());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para excluir um funcionário
    public boolean excluir(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
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

    // Método para buscar um funcionário pelo ID
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Funcionario funcionario = new Funcionario(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cargo"),
                        resultado.getString("email"),
                        resultado.getString("telefone"),
                        resultado.getBoolean("ativo")
                );
                return funcionario;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return null;
    }

    // Método para listar todos os funcionários
    public ArrayList<Funcionario> listarTodos() {
        String sql = "SELECT * FROM funcionario";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Funcionario> lista = new ArrayList<>();

        try {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("cargo"),
                        resultado.getString("email"),
                        resultado.getString("telefone"),
                        resultado.getBoolean("ativo")
                );
                lista.add(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }
}
