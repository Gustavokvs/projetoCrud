package controller;

import model.Venda;
import model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class VendaController {

    // Método para registrar uma nova venda no banco de dados
// Método para registrar uma nova venda no banco de dados
public boolean registrarVenda(Venda venda) {
    String sqlVenda = "INSERT INTO venda (id_cliente, data_venda) VALUES (?, ?)";
    String sqlVendaLivroVerifica = "SELECT COUNT(*) FROM venda_livro WHERE id_venda = ? AND id_livro = ?";
    String sqlVendaLivroInserir = "INSERT INTO venda_livro (id_venda, id_livro, quantidade) VALUES (?, ?, ?)";
    String sqlVendaLivroAtualizar = "UPDATE venda_livro SET quantidade = quantidade + ? WHERE id_venda = ? AND id_livro = ?";

    try (Connection conn = new GerenciadorConexao().getConexao();
            PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stmtVendaLivroVerifica = conn.prepareStatement(sqlVendaLivroVerifica);
            PreparedStatement stmtVendaLivroInserir = conn.prepareStatement(sqlVendaLivroInserir);
            PreparedStatement stmtVendaLivroAtualizar = conn.prepareStatement(sqlVendaLivroAtualizar)) {

        // Inicia a transação
        conn.setAutoCommit(false);

        // Inserir na tabela venda
        stmtVenda.setInt(1, venda.getIdCliente());
        stmtVenda.setDate(2, java.sql.Date.valueOf(venda.getDataVenda()));
        stmtVenda.executeUpdate();

        // Recupera o ID da venda gerado
        try (ResultSet rs = stmtVenda.getGeneratedKeys()) {
            if (rs.next()) {
                venda.setId(rs.getInt(1));
            }
        }

        // Inserir ou atualizar na tabela venda_livro (relacionando livros com a venda)
        for (Map.Entry<Livro, Integer> entry : venda.getLivrosVendidos().entrySet()) {
            // Verificar se o livro já está associado à venda
            stmtVendaLivroVerifica.setInt(1, venda.getId());
            stmtVendaLivroVerifica.setInt(2, entry.getKey().getId());
            try (ResultSet rsVerifica = stmtVendaLivroVerifica.executeQuery()) {
                if (rsVerifica.next() && rsVerifica.getInt(1) > 0) {
                    // Se já existir, atualize a quantidade
                    stmtVendaLivroAtualizar.setInt(1, entry.getValue());
                    stmtVendaLivroAtualizar.setInt(2, venda.getId());
                    stmtVendaLivroAtualizar.setInt(3, entry.getKey().getId());
                    stmtVendaLivroAtualizar.executeUpdate();
                } else {
                    // Caso contrário, insira o novo registro
                    stmtVendaLivroInserir.setInt(1, venda.getId());
                    stmtVendaLivroInserir.setInt(2, entry.getKey().getId());
                    stmtVendaLivroInserir.setInt(3, entry.getValue());
                    stmtVendaLivroInserir.executeUpdate();
                }
            }
        }

        // Confirma a transação
        conn.commit();
        System.out.println("Venda registrada com sucesso no banco!");

        return true;  // Retorna true indicando que a venda foi registrada com sucesso

    } catch (SQLException e) {
        e.printStackTrace();
        try (Connection conn = new GerenciadorConexao().getConexao()) {
            if (conn != null) {
                conn.rollback(); // Desfaz a transação em caso de erro
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;  // Retorna false em caso de erro
    }
}

    // Método para adicionar um livro à venda
    public void adicionarLivroAVenda(Venda venda, Livro livro, int quantidade) {
        Map<Livro, Integer> livrosVendidos = venda.getLivrosVendidos();
        livrosVendidos.merge(livro, quantidade, Integer::sum);
        venda.setLivrosVendidos(livrosVendidos);
    }

    // Método para remover um livro da venda
    public void removerLivroDaVenda(Venda venda, Livro livro) {
        Map<Livro, Integer> livrosVendidos = venda.getLivrosVendidos();
        livrosVendidos.remove(livro);
        venda.setLivrosVendidos(livrosVendidos);
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

    // Método para listar todas as vendas
// Método para listar todas as vendas
    public ArrayList<Venda> listarTodos() {
        ArrayList<Venda> lista = new ArrayList<>();
        String sqlVenda = "SELECT v.id, v.data_venda, v.id_cliente, c.nome AS cliente_nome "
                + "FROM venda v JOIN cliente c ON v.id_cliente = c.id";
        String sqlVendaLivro = "SELECT vl.id_livro, vl.quantidade, l.titulo, l.preco "
                + "FROM venda_livro vl JOIN livro l ON vl.id_livro = l.id WHERE vl.id_venda = ?";

        try (Connection conn = new GerenciadorConexao().getConexao();
                PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda);
                PreparedStatement stmtVendaLivro = conn.prepareStatement(sqlVendaLivro);
                ResultSet rsVenda = stmtVenda.executeQuery()) {

            while (rsVenda.next()) {
                Venda venda = new Venda();
                venda.setId(rsVenda.getInt("id"));
                venda.setDataVenda(rsVenda.getDate("data_venda").toLocalDate());
                venda.setIdCliente(rsVenda.getInt("id_cliente")); // ✅ Aqui está o que faltava!
                venda.setClienteNome(rsVenda.getString("cliente_nome"));

                // Obter os livros relacionados à venda
                stmtVendaLivro.setInt(1, venda.getId());
                try (ResultSet rsVendaLivro = stmtVendaLivro.executeQuery()) {
                    while (rsVendaLivro.next()) {
                        Livro livro = new Livro();
                        livro.setId(rsVendaLivro.getInt("id_livro"));
                        livro.setTitulo(rsVendaLivro.getString("titulo"));
                        livro.setPreco(rsVendaLivro.getDouble("preco"));

                        // Adicionando o livro à venda
                        venda.getLivrosVendidos().put(livro, rsVendaLivro.getInt("quantidade"));
                    }
                }

                lista.add(venda);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Método para alterar uma venda
// Método para alterar uma venda
    public void alterarVenda(Venda venda) {
        String sqlVenda = "UPDATE venda SET id_cliente = ?, data_venda = ? WHERE id = ?";
        String sqlVendaLivroDelete = "DELETE FROM venda_livro WHERE id_venda = ?";
        String sqlVendaLivroInsert = "INSERT INTO venda_livro (id_venda, id_livro, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = new GerenciadorConexao().getConexao();
                PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda);
                PreparedStatement stmtVendaLivroDelete = conn.prepareStatement(sqlVendaLivroDelete);
                PreparedStatement stmtVendaLivroInsert = conn.prepareStatement(sqlVendaLivroInsert)) {

            // Inicia a transação
            conn.setAutoCommit(false);

            // Atualiza a tabela venda
            stmtVenda.setInt(1, venda.getIdCliente());
            stmtVenda.setDate(2, java.sql.Date.valueOf(venda.getDataVenda()));
            stmtVenda.setInt(3, venda.getId());
            stmtVenda.executeUpdate();

            // Exclui os livros anteriores da venda
            stmtVendaLivroDelete.setInt(1, venda.getId());
            stmtVendaLivroDelete.executeUpdate();

            // Insere os novos livros na venda
            for (Map.Entry<Livro, Integer> entry : venda.getLivrosVendidos().entrySet()) {
                stmtVendaLivroInsert.setInt(1, venda.getId());
                stmtVendaLivroInsert.setInt(2, entry.getKey().getId());
                stmtVendaLivroInsert.setInt(3, entry.getValue());
                stmtVendaLivroInsert.executeUpdate();
            }

            // Confirma a transação
            conn.commit();
            System.out.println("Venda alterada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conn = new GerenciadorConexao().getConexao()) {
                if (conn != null) {
                    conn.rollback(); // Desfaz a transação em caso de erro
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para excluir uma venda
    public static void excluirVenda(int idVenda) {
        String sqlVendaLivro = "DELETE FROM venda_livro WHERE id_venda = ?";
        String sqlVenda = "DELETE FROM venda WHERE id = ?";

        try (Connection conn = new GerenciadorConexao().getConexao();
                PreparedStatement stmtVendaLivro = conn.prepareStatement(sqlVendaLivro);
                PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda)) {

            // Inicia a transação
            conn.setAutoCommit(false);

            // Exclui os livros relacionados à venda
            stmtVendaLivro.setInt(1, idVenda);
            stmtVendaLivro.executeUpdate();

            // Exclui a venda
            stmtVenda.setInt(1, idVenda);
            stmtVenda.executeUpdate();

            // Confirma a transação
            conn.commit();
            System.out.println("Venda excluída com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conn = new GerenciadorConexao().getConexao()) {
                if (conn != null) {
                    conn.rollback(); // Desfaz a transação em caso de erro
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
