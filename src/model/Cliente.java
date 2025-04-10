package model;

import java.util.Date;

public class Cliente {

    private int id;
    private String nome;
    private String email;
    private Date dataNascimento;
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(int id, String nome, String email, Date dataNascimento, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String ativoToString() {
        return ativo ? "Ativo" : "Inativo";
    }

    @Override
    public String toString() {
        return nome;
    }
}
