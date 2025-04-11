package model;

public class Livro {

    private int id;
    private String titulo;
    private String isbn;
    private double preco;
    private int anoPublicacao;
    private String autor;
    private String categoria;

    public Livro() {
    }

    public Livro(int id, String titulo, String isbn, double preco, int anoPublicacao, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.preco = preco;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
