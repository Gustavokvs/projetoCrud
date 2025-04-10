package model;

import java.util.Date;

public class Venda {

    private int id;
    private Livro livro;
    private Cliente cliente;
    private Date dataVenda;
    private int quantidade;

    public Venda() {
    }

    public Venda(int id, Livro livro, Cliente cliente, Date dataVenda, int quantidade) {
        this.id = id;
        this.livro = livro;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
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
}
