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
    
    // Método para criar uma venda sem inserir no banco ainda
    public Venda criarVenda(Cliente cliente, List<Livro> livros, int quantidade) {
        Venda novaVenda = new Venda();
        novaVenda.setId(vendas.size() + 1);
        novaVenda.setCliente(cliente);
        novaVenda.setLivros(livros);
        novaVenda.setQuantidade(quantidade);
        novaVenda.setDataVenda(new Date());
        
        vendas.add(novaVenda);
        
        return novaVenda;
    }
    
    // Método para inserir uma venda no banco
    public boolean inserir(Venda venda) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sqlVenda = "INSERT INTO venda (id_cliente, data_venda, quantidade) VALUES (?, ?, ?)";
        
        PreparedStatement comandoVenda = conexao.prepararComando(sqlVenda);
        try {
            // Inserindo a venda na tabela "venda"
            comandoVenda.setInt(1, venda.getCliente().getId());  // Usando o ID do cliente, não o nome
            comandoVenda.setDate(2, new java.sql.Date(venda.getDataVenda().getTime()));  // Convertendo para java.sql.Date
            comandoVenda.setInt(3, venda.getQuantidade());
            
            int resultadoVenda = comandoVenda.executeUpdate();
            
            // Após inserir a venda, obtivemos o ID gerado para a venda
            if (resultadoVenda > 0) {
                int idVenda = getIdUltimaVenda(conexao);  // Pegando o ID da última venda inserida
                
                // Agora, inserimos os livros vendidos na tabela "venda_livro"
                String sqlVendaLivro = "INSERT INTO venda_livro (id_venda, id_livro) VALUES (?, ?)";
                PreparedStatement comandoVendaLivro = conexao.prepararComando(sqlVendaLivro);
                
                for (Livro livro : venda.getLivros()) {
                    comandoVendaLivro.setInt(1, idVenda);
                    comandoVendaLivro.setInt(2, livro.getId());  // Usando o ID do livro
                    comandoVendaLivro.addBatch();  // Adicionando a operação no batch
                }
                
                // Executando todas as inserções de livros
                comandoVendaLivro.executeBatch();
                
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comandoVenda);
        }
    }

    // Método para buscar o ID da última venda inserida
    private int getIdUltimaVenda(GerenciadorConexao conexao) throws SQLException {
        String sql = "SELECT LAST_INSERT_ID()";
        PreparedStatement comando = conexao.prepararComando(sql);
        ResultSet resultSet = comando.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);  // Retorna o último ID gerado
        }
        return -1;  // Retorna -1 se não encontrar
    }

    // Método para listar todas as vendas
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
                v.setId(resultSet.getInt("id"));
                cliente.setId(resultSet.getInt("id_cliente"));  // Corrigindo: agora está pegando o ID do cliente
                v.setCliente(cliente);
                v.setDataVenda(resultSet.getDate("data_venda"));
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

    // Método para atualizar uma venda
    public boolean atualizar(Venda venda) {
        GerenciadorConexao conexao = new GerenciadorConexao();
        String sql = "UPDATE venda SET id_cliente=?, data_venda=?, quantidade=? WHERE id=?";

        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setInt(1, venda.getCliente().getId());  // Usando o ID do cliente
            comando.setDate(2, new java.sql.Date(venda.getDataVenda().getTime()));
            comando.setInt(3, venda.getQuantidade());
            comando.setInt(4, venda.getId());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }
    
    public boolean inserirVendaLivro(int idVenda, int idLivro) {
    GerenciadorConexao conexao = new GerenciadorConexao();
    String sql = "INSERT INTO venda_livro (id_venda, id_livro) VALUES (?, ?)";

    PreparedStatement comando = conexao.prepararComando(sql);
    try {
        comando.setInt(1, idVenda);
        comando.setInt(2, idLivro);
        comando.executeUpdate();
        return true;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        conexao.fecharConexao(comando);
    }
}


    // Método para excluir uma venda
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
