package model;

import java.util.Date;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataNascimento;
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String telefone, Date dataNascimento, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Date getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public String ativoToString() {
        return ativo ? "Ativo" : "Inativo";
    }
}
