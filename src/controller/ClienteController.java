package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import java.util.Date;
import java.sql.Timestamp;

public class ClienteController {

    // Método de validação de email
    public boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public boolean inserir(Cliente cliente) {
        if (!validarEmail(cliente.getEmail())) {
            System.out.println("Email inválido.");
            return false;  // Não insere o cliente caso o email seja inválido
        }

        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "INSERT INTO cliente (nome, email, telefone, data_nascimento, ativo) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getTelefone());
            comando.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));  // Mudança para java.sql.Date
            comando.setBoolean(5, cliente.isAtivo());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para buscar clientes por nome
    public ArrayList<Cliente> buscarPorNome(String nome) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try {
            comando.setString(1, "%" + nome + "%");  // Pesquisa que seja semelhante ao nome
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setDataNascimento(new Date(resultado.getTimestamp("data_nascimento").getTime()));
                cliente.setAtivo(resultado.getBoolean("ativo"));
                listaClientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return listaClientes;
    }

    public boolean atualizar(Cliente cliente) {
        if (!validarEmail(cliente.getEmail())) {
            System.out.println("Email inválido.");
            return false;  // Não atualiza o cliente caso o email seja inválido
        }

        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, data_nascimento = ?, ativo = ? WHERE id = ?";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmail());
            comando.setString(3, cliente.getTelefone());
            comando.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));  // Mudança para java.sql.Date
            comando.setBoolean(5, cliente.isAtivo());
            comando.setInt(6, cliente.getId());

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
        String sql = "DELETE FROM cliente WHERE id = ?";

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

    public Cliente buscarPorId(int id) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;
        Cliente cliente = null;

        try {
            comando.setInt(1, id);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setDataNascimento(new Date(resultado.getTimestamp("data_nascimento").getTime()));
                cliente.setAtivo(resultado.getBoolean("ativo"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return cliente;
    }

    public ArrayList<Cliente> listarTodos() {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT * FROM cliente";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultado = null;
        ArrayList<Cliente> lista = new ArrayList<>();

        try {
            resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setDataNascimento(new Date(resultado.getTimestamp("data_nascimento").getTime()));
                cliente.setAtivo(resultado.getBoolean("ativo"));
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando, resultado);
        }

        return lista;
    }
}
