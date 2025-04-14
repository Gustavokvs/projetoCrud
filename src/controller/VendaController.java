package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
  public boolean inserir(Venda venda, GerenciadorConexao conexao) {
    String sql = "INSERT INTO venda (id_cliente, data_venda, quantidade) VALUES (?, ?, ?)";

    try (
        Connection conn = conexao.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql)
    ) {
        stmt.setInt(1, venda.getCliente().getId());
        stmt.setDate(2, new java.sql.Date(venda.getDataVenda().getTime()));
        stmt.setInt(3, venda.getQuantidade());

        int linhasAfetadas = stmt.executeUpdate();

        return linhasAfetadas > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
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

                // Buscando os livros associados a essa venda
                List<Livro> livros = getLivrosPorVenda(v.getId(), conexao);
                v.setLivros(livros);

                lista.add(v);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }

    // Método para buscar os livros relacionados a uma venda
    private List<Livro> getLivrosPorVenda(int idVenda, GerenciadorConexao conexao) throws SQLException {
        List<Livro> livros = new ArrayList<>();
        String sqlLivros = "SELECT l.id, l.titulo FROM livro l "
                + "JOIN venda vl ON l.id = vl.id_livro "
                + "WHERE vl.id = ?";

        PreparedStatement comandoLivros = conexao.prepararComando(sqlLivros);
        comandoLivros.setInt(1, idVenda);
        ResultSet resultSetLivros = comandoLivros.executeQuery();

        while (resultSetLivros.next()) {
            Livro livro = new Livro();
            livro.setId(resultSetLivros.getInt("id"));
            livro.setTitulo(resultSetLivros.getString("titulo"));
            livros.add(livro);
        }

        return livros;
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

    // Método para excluir uma venda
    public boolean excluir(int id) {
        GerenciadorConexao conexao = new GerenciadorConexao();

        // Primeiro, exclui os livros relacionados
        String sqlVendaLivro = "DELETE FROM venda_livro WHERE id_venda=?";
        PreparedStatement comandoVendaLivro = conexao.prepararComando(sqlVendaLivro);
        try {
            comandoVendaLivro.setInt(1, id);
            comandoVendaLivro.executeUpdate();

            // Agora, exclui a venda
            String sqlVenda = "DELETE FROM venda WHERE id=?";
            PreparedStatement comandoVenda = conexao.prepararComando(sqlVenda);
            comandoVenda.setInt(1, id);
            comandoVenda.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comandoVendaLivro);
        }
    }
}
