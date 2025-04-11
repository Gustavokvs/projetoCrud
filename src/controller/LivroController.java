
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livro;
import java.sql.*;
import java.util.ArrayList;

public class LivroController {

    // Método para inserir um livro no banco de dados
    public boolean inserir(Livro livro) {
        String sql = "INSERT INTO livro (titulo, autor, categoria, isbn, preco, ano_publicacao) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, livro.getTitulo());
            comando.setString(2, livro.getAutor());
            comando.setString(3, livro.getIsbn());
            comando.setDouble(4, livro.getPreco());
            comando.setInt(5, livro.getAnoPublicacao());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para atualizar um livro
    public boolean atualizar(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, categoria = ?, isbn = ?, preco = ?, ano_publicacao = ? WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, livro.getTitulo());
            comando.setString(2, livro.getAutor());
            comando.setString(3, livro.getCategoria());
            comando.setString(4, livro.getIsbn());
            comando.setDouble(5, livro.getPreco());
            comando.setInt(6, livro.getAnoPublicacao());
            comando.setInt(7, livro.getId());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para excluir um livro
    public boolean excluir(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Método para buscar um livro pelo ID
    public Livro buscarPorId(int id) {
        String sql = "SELECT * FROM livro WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Livro livro = new Livro();
                livro.setId(resultado.getInt("id"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setCategoria(resultado.getString("categoria"));
                livro.setIsbn(resultado.getString("isbn"));
                livro.setPreco(resultado.getDouble("preco"));
                livro.setAnoPublicacao(resultado.getInt("ano_publicacao"));
                return livro;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Método para listar todos os livros
    public ArrayList<Livro> listarTodos() {
        String sql = "SELECT * FROM livro";
        ArrayList<Livro> lista = new ArrayList<>();
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Livro livro = new Livro();
                livro.setId(resultado.getInt("id"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setCategoria(resultado.getString("categoria"));
                livro.setIsbn(resultado.getString("isbn"));
                livro.setPreco(resultado.getDouble("preco"));
                livro.setAnoPublicacao(resultado.getInt("ano_publicacao"));
                lista.add(livro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}


