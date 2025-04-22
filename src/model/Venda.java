package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Venda {

    private int id;
    private int idCliente;
    private String clienteNome; // Pode ser evitado, já que é redundante
    private LocalDate dataVenda;
    private Map<Livro, Integer> livrosVendidos;
    private double valorTotal;

    public Venda(int id, Cliente cliente, Map<Livro, Integer> livrosVendidos, LocalDate dataVenda) {
        this.id = id;
        setCliente(cliente);  // Define o ID do cliente e o nome
        this.livrosVendidos = livrosVendidos != null ? livrosVendidos : new HashMap<>();
        this.dataVenda = dataVenda != null ? dataVenda : LocalDate.now();
        this.valorTotal = calcularValorTotal();
    }

    public Venda() {
        this.id = 0;
        this.idCliente = 0;
        this.clienteNome = "";
        this.livrosVendidos = new HashMap<>();
        this.dataVenda = LocalDate.now();
        this.valorTotal = 0.0;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getClienteNome() {
        return clienteNome;  // Pode ser evitado se for buscado do banco
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Map<Livro, Integer> getLivrosVendidos() {
        return livrosVendidos;
    }

    public void setLivrosVendidos(Map<Livro, Integer> livrosVendidos) {
        this.livrosVendidos = livrosVendidos;
        this.valorTotal = calcularValorTotal();  // Recalcula o valor total após alteração
    }

    public void setCliente(Cliente cliente) {
        this.idCliente = cliente.getId();
        this.clienteNome = cliente.getNome();  // Nome do cliente não deve ser mantido redundante
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // Método para calcular o valor total da venda
    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Map.Entry<Livro, Integer> entry : livrosVendidos.entrySet()) {
            Livro livro = entry.getKey();
            int quantidade = entry.getValue();
            valorTotal += livro.getPreco() * quantidade;
        }
        return valorTotal;
    }

    // Método para preparar os dados da venda para o banco de dados
    public void prepararDadosVenda() {
        // Aqui você pode realizar qualquer formatação necessária antes de enviar os dados para o banco
        // Exemplo: criar uma lista de IDs de livros vendidos com quantidades para a tabela Venda_Livro
    }

   
}
