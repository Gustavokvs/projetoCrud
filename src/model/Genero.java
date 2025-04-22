package model;

import java.util.ArrayList;
import java.util.List;

public class Genero {

    private int id;
    private String nome;
    private List<Livro> livros;  // Lista de livros

    // Construtor
    public Genero() {}

    public Genero(int id, String nome, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros != null ? livros : new ArrayList<>();  // Evita lista nula
    }

    // Getters e Setters
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros != null ? livros : new ArrayList<>();  // Evita lista nula
    }

    @Override
    public String toString() {
        return nome;
    }
}
