package model;

public class Funcionario {

    private int id;
    private String nome;
    private String cargo;
    private String email;
    private String telefone;
    private boolean ativo;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String cargo, String email, String telefone, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.telefone = telefone;
        this.ativo = ativo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public String ativoToString() {
        return ativo ? "Ativo" : "Inativo";
    }
}
