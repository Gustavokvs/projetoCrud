package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

public class FuncionarioController {

    // Método para inserir um funcionário no banco de dados
    public boolean inserir(String funcionario) {
        String sql = "INSERT INTO funcionario (nome, cargo, email, telefone, ativo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            Funcionario fun = new Funcionario();

            comando.setString(1, fun.getNome());
            comando.setString(2, fun.getCargo());
            comando.setString(3, fun.getEmail());
            comando.setString(4, fun.getTelefone());
            comando.setBoolean(5, fun.isAtivo());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para atualizar um funcionário
    public boolean atualizar(String funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cargo = ?, email = ?, telefone = ?, ativo = ? WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            Funcionario fun = new Funcionario();
            
            comando.setString(1, fun.getNome());
            comando.setString(2, fun.getCargo());
            comando.setString(3, fun.getEmail());
            comando.setString(4, fun.getTelefone());
            comando.setBoolean(5, fun.isAtivo());
            comando.setInt(6, fun.getId());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para excluir um funcionário
    public boolean excluir(int id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
                PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para buscar um funcionário pelo ID
    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
                PreparedStatement comando = conexao.prepareStatement(sql)) {

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
        }
        return null;
    }

    // Método para listar todos os funcionários
    public ArrayList<Funcionario> listarTodos() {
        String sql = "SELECT * FROM funcionario";
        ArrayList<Funcionario> lista = new ArrayList<>();
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
                PreparedStatement comando = conexao.prepareStatement(sql);
                ResultSet resultado = comando.executeQuery()) {

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
        }
        return lista;
    }

}
