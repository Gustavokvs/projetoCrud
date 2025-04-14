package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Livro;
import model.Cliente;
public class Venda {

    
    private int id;
    private List<Livro> livros;
    private Cliente cliente;
    private Date dataVenda;
    private int quantidade;
    private double valorTotal;

    public Venda() {
        this.livros = new ArrayList<>();
    }

    public Venda(int id, List<Livro> livros, Cliente cliente, Date dataVenda, int quantidade, double valorTotal) {
        this.id = id;
        this.livros = livros; // Ajuste aqui
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
