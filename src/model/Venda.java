package model;

import java.util.Date;

public class Venda {

    private int id;
    private int idCliente;
    private int idFuncionario;
    private Date dataVenda;
    private double valorTotal;

    public Venda() {
    }

    public Venda(int id, int idCliente, int idFuncionario, Date dataVenda, double valorTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    public Date getDataVenda() { return dataVenda; }
    public void setDataVenda(Date dataVenda) { this.dataVenda = dataVenda; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
}
