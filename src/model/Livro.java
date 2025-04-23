package model;

import java.util.List;

public class Livro {

    private int id;
    private String titulo;
    private String isbn;
    private double preco;
    private int anoPublicacao;
    private int idAutor;
    private List<Integer> idsCategorias; // id dos gêneros (categoria)

    public Livro() {
    }

    public Livro(int id, String titulo, String isbn, double preco, int anoPublicacao, int idAutor, List<Integer> idsCategorias) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.preco = preco;
        this.anoPublicacao = anoPublicacao;
        this.idAutor = idAutor;
        this.idsCategorias = idsCategorias;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public List<Integer> getIdsCategorias() {
        return idsCategorias;
    }

    public void setIdsCategorias(List<Integer> idsCategorias) {
        this.idsCategorias = idsCategorias;
    }

    public String getCategorias() {
        if (idsCategorias == null) return ""; // evita NullPointerException
        return String.join(",", idsCategorias.stream().map(String::valueOf).toArray(String[]::new));
    }
}
