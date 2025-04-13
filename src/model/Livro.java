package model;

import controller.GeneroController;

public class Livro {

    private int id;
    private String titulo;
    private double preco;
    private int idAutor;
    private int idGenero;  // Agora armazena o id do gênero diretamente
    private String isbn;
    private int anoPublicacao;

    private Genero genero;  // Novo campo para armazenar a referência ao objeto Genero

    // Construtor
    public Livro() {
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        if (genero != null) {
            this.genero = genero;
        } else {
            System.out.println("Erro: Gênero não encontrado");
        }
    }
    
    @Override
    public String toString() {
        return "Livro{"
                + "id=" + id
                + ", titulo='" + titulo + '\''
                + ", preco=" + preco
                + ", idAutor=" + idAutor
                + ", idGenero=" + idGenero
                + ", isbn='" + isbn + '\''
                + ", anoPublicacao=" + anoPublicacao
                + '}';
    }

    // Método para obter o nome da categoria
    public String getCategoria() {
        return genero != null ? genero.getNome() : "Categoria não definida";
    }

    // Método para setar a categoria a partir de um nome
    public void setCategoria(String categoriaStr) {
        // Lógica para buscar o objeto Genero a partir do nome
        GeneroController controller = new GeneroController();
        Genero genero = controller.buscarPorNome(categoriaStr);  // Usando buscarPorNome
        if (genero != null) {
            this.setGenero(genero);  // Atualiza o objeto Genero e o id
        } else {
            this.setGenero(null);  // Ou defina como um valor padrão, caso não encontre
        }
    }
}
