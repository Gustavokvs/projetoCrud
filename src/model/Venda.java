package model;

import java.util.Date;
import java.util.List;

public class Venda {

    private int id;
    private List<Livro> livro;
    private Cliente cliente;
    private Date dataVenda;
    private int quantidade;

    public Venda() {
    }

    public Venda(int id, Livro livro, Cliente cliente, Date dataVenda, int quantidade) {
        this.id = id;
        this.livro = (List<Livro>) livro;
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

    public List<Livro> getLivros() {
        return livro;
    }

    public void setLivros(List<Livro>livros) {
        this.livro = (List<Livro>) livro;
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
