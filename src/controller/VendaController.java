
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Venda;
import model.Livro;
import model.Cliente;


public class VendaController {
    
    private List<Venda> vendas = new ArrayList<>();
    
    public Venda criarVenda(Cliente cliente, List<Livro> livros, int quantidade){
        Venda novaVenda = new Venda();
        novaVenda.setId(vendas.size()+1);
        novaVenda.setCliente(cliente);
        novaVenda.setLivros(livros);
        novaVenda.setQuantidade(quantidade);
        novaVenda.setDataVenda(new Date());
        
        vendas.add(novaVenda);
        
        return novaVenda;
    }
    
     public boolean inserir(Venda venda) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "INSERT INTO venda (codigo_livro, cliente, data, quantidade) VALUES (?, ?, ?, ?)";

         PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setInt(1, venda.getId());
            comando.setString(2, venda.getCliente().getNome());
            comando.setDate(3, (java.sql.Date) venda.getDataVenda());
            comando.setInt(4, venda.getQuantidade());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public List<Venda> listar() {
        List<Venda> lista = new ArrayList<>();
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "SELECT * FROM venda";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {
                Venda v = new Venda();
                Cliente cliente = new Cliente();
               
                v.setId(resultSet.getInt("código_livro"));    
                cliente.setNome(resultSet.getString("cliente")); 
                v.setCliente(cliente);
                v.setDataVenda(resultSet.getDate("data"));
                v.setQuantidade(resultSet.getInt("quantidade"));
                lista.add(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }

        return lista;
    }

    public boolean atualizar(Venda venda) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "UPDATE venda SET codigo_livro=?, cliente=?, data=?, quantidade=? WHERE id=?";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setInt(1, venda.getId());
            comando.setString(2, venda.getCliente().getNome());
            comando.setDate(3, (java.sql.Date) venda.getDataVenda());
            comando.setInt(4, venda.getQuantidade());
            comando.setInt(5, venda.getId());

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
        String sql = "DELETE FROM venda WHERE id=?";

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
}