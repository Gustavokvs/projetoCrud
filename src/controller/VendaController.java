package controller;

import model.Venda;
import model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendaController {

    // Método para registrar uma nova venda no banco de dados
    public void registrarVenda(Venda venda) {
        Connection conn = null;
        PreparedStatement stmtVenda = null;
        PreparedStatement stmtVendaLivro = null;
        ResultSet rs = null;
        GerenciadorConexao conexao = null;

        try {
            // Usando o GerenciadorConexao para instanciar a conexão
            conexao = new GerenciadorConexao();
            conn = conexao.getConexao(); // Obter a conexão corretamente

            conexao.abrirTransacao(); // Iniciar transação

            // Inserir na tabela venda
            String sqlVenda = "INSERT INTO venda (id_cliente, data_venda) VALUES (?, ?)";
            stmtVenda = conexao.prepararComando(sqlVenda, Statement.RETURN_GENERATED_KEYS);
            stmtVenda.setInt(1, venda.getIdCliente());
            // Passando a data da venda fornecida e não a atual
            stmtVenda.setDate(2, java.sql.Date.valueOf(venda.getDataVenda()));
            stmtVenda.executeUpdate();

            rs = stmtVenda.getGeneratedKeys();
            int idVenda = 0;
            if (rs.next()) {
                idVenda = rs.getInt(1);
                venda.setId(idVenda);
            }

            // Inserir na tabela venda_livro (relacionando livros com a venda)
            String sqlVendaLivro = "INSERT INTO venda_livro (id_venda, id_livro, quantidade) VALUES (?, ?, ?)";
            stmtVendaLivro = conexao.prepararComando(sqlVendaLivro);

            // Garantir que a quantidade de livros seja passada corretamente
            for (Map.Entry<Livro, Integer> entry : venda.getLivrosVendidos().entrySet()) {
                stmtVendaLivro.setInt(1, idVenda);
                stmtVendaLivro.setInt(2, entry.getKey().getId());
                stmtVendaLivro.setInt(3, entry.getValue()); // Certificando que a quantidade é passada corretamente
                stmtVendaLivro.executeUpdate(); // Executando a inserção de cada livro vendido com a quantidade correta
            }

            conexao.confirmarTransacao(); // Finaliza a transação
            System.out.println("Venda registrada com sucesso no banco!");

        } catch (Exception e) {
            if (conexao != null) {
                conexao.cancelarTransacao(); // Desfaz transação em caso de erro
            }
            e.printStackTrace();
        } finally {
            // Fechar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (stmtVendaLivro != null) {
                    stmtVendaLivro.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (stmtVenda != null) {
                    stmtVenda.close();
                }
            } catch (SQLException e) {
            }
            if (conexao != null) {
                conexao.fecharConexao(); // Fechar a conexão após o uso
            }
        }
    }

    // Método para adicionar um livro à venda
    public void adicionarLivroAVenda(Venda venda, Livro livro, int quantidade) {
        Map<Livro, Integer> livrosVendidos = venda.getLivrosVendidos();
        if (livrosVendidos.containsKey(livro)) {
            livrosVendidos.put(livro, livrosVendidos.get(livro) + quantidade);
        } else {
            livrosVendidos.put(livro, quantidade);
        }
        venda.setLivrosVendidos(livrosVendidos);
    }

    // Método para remover um livro da venda
    public void removerLivroDaVenda(Venda venda, Livro livro) {
        Map<Livro, Integer> livrosVendidos = venda.getLivrosVendidos();
        if (livrosVendidos.containsKey(livro)) {
            livrosVendidos.remove(livro);
            venda.setLivrosVendidos(livrosVendidos);
        }
    }

    // Método para finalizar a venda
    public void finalizarVenda(Venda venda) {
        registrarVenda(venda); // Chama o método para registrar no banco
        System.out.println("Venda finalizada com sucesso!");
    }

    // Método para exibir detalhes da venda
    public void exibirDetalhesVenda(Venda venda) {
        System.out.println("ID da Venda: " + venda.getId());
        System.out.println("Cliente: " + venda.getClienteNome());
        System.out.println("Data da Venda: " + venda.getDataVenda());
        System.out.println("Livros Vendidos:");
        for (Map.Entry<Livro, Integer> entry : venda.getLivrosVendidos().entrySet()) {
            System.out.println(" - " + entry.getKey().getTitulo() + " (Quantidade: " + entry.getValue() + ")");
        }
    }

    public List<Venda> listarVendas() {
        List<Venda> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        GerenciadorConexao conexao = new GerenciadorConexao();

        try {
            conn = conexao.getConexao();
            String sql = "SELECT v.id, v.data_venda, c.id AS id_cliente, c.nome AS nome_cliente "
                    + "FROM venda v JOIN cliente c ON v.id_cliente = c.id";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setIdCliente(rs.getInt("id_cliente"));
                venda.setClienteNome(rs.getString("nome_cliente"));
                venda.setDataVenda(rs.getDate("data_venda").toLocalDate());

                // Agora buscar os livros dessa venda
                Map<Livro, Integer> livros = buscarLivrosPorVenda(venda.getId(), conn);
                venda.setLivrosVendidos(livros);

                lista.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
            conexao.fecharConexao();
        }

        return lista;
    }

    private Map<Livro, Integer> buscarLivrosPorVenda(int idVenda, Connection conn) throws SQLException {
        Map<Livro, Integer> livros = new HashMap<>();
        String sql = "SELECT vl.id_livro, l.titulo, l.preco, vl.quantidade "
                + "FROM venda_livro vl JOIN livro l ON vl.id_livro = l.id WHERE vl.id_venda = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idVenda);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livro livro = new Livro();
                    livro.setId(rs.getInt("id_livro"));
                    livro.setTitulo(rs.getString("titulo"));
                    livro.setPreco(rs.getDouble("preco"));

                    int quantidade = rs.getInt("quantidade");
                    livros.put(livro, quantidade);
                }
            }
        }
        return livros;
    }

    // Método para alterar uma venda
    public void alterarVenda(Venda venda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        GerenciadorConexao conexao = null;

        try {
            // Usando o GerenciadorConexao para instanciar a conexão
            conexao = new GerenciadorConexao();
            conn = conexao.getConexao(); // Obter a conexão corretamente

            // Atualizar a venda na tabela venda
            String sql = "UPDATE venda SET id_cliente = ?, data_venda = ? WHERE id = ?";
            stmt = conexao.prepararComando(sql);

            stmt.setInt(1, venda.getIdCliente());
            stmt.setDate(2, java.sql.Date.valueOf(venda.getDataVenda()));
            stmt.setInt(3, venda.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Venda alterada com sucesso!");
            } else {
                System.out.println("Erro ao alterar venda!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
            }
            if (conexao != null) {
                conexao.fecharConexao(); // Fechar a conexão após o uso
            }
        }
    }
// Método para excluir uma venda

    public void excluirVenda(int idVenda) throws Exception {
    Connection conn = null;
    PreparedStatement stmtVendaLivro = null;
    PreparedStatement stmtVenda = null;
    GerenciadorConexao conexao = null;

    try {
        // Usando o GerenciadorConexao para instanciar a conexão
        conexao = new GerenciadorConexao();
        conn = conexao.getConexao(); // Obter a conexão corretamente

        conexao.abrirTransacao(); // Iniciar transação

        // Deletar da tabela venda_livro
        String sqlVendaLivro = "DELETE FROM venda_livro WHERE id_venda = ?";
        stmtVendaLivro = conexao.prepararComando(sqlVendaLivro);
        stmtVendaLivro.setInt(1, idVenda);
        stmtVendaLivro.executeUpdate();

        // Deletar da tabela venda
        String sqlVenda = "DELETE FROM venda WHERE id = ?";
        stmtVenda = conexao.prepararComando(sqlVenda);
        stmtVenda.setInt(1, idVenda);
        stmtVenda.executeUpdate();

        conexao.confirmarTransacao(); // Finaliza a transação
        System.out.println("Venda excluída com sucesso!");

    } catch (Exception e) {
        if (conexao != null) {
            conexao.cancelarTransacao(); // Desfaz transação em caso de erro
        }
        throw new Exception("Erro ao excluir a venda", e); // Lança uma exceção com a mensagem de erro
    } finally {
        try {
            if (stmtVenda != null) {
                stmtVenda.close();
            }
        } catch (SQLException e) {
        }
        try {
            if (stmtVendaLivro != null) {
                stmtVendaLivro.close();
            }
        } catch (SQLException e) {
        }
        if (conexao != null) {
            conexao.fecharConexao(); // Fechar a conexão após o uso
        }
    }
}


}
