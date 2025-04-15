package controller;

import model.Venda;
import model.Livro;
import java.sql.*;
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
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmtVendaLivro != null) stmtVendaLivro.close(); } catch (SQLException e) {}
            try { if (stmtVenda != null) stmtVenda.close(); } catch (SQLException e) {}
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
}
