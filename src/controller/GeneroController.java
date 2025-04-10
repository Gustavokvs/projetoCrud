package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Genero;

public class GeneroController {

    private GerenciadorConexao gerenciador;

    public GeneroController() {
        gerenciador = new GerenciadorConexao();
    }

    public ArrayList<Genero> listarTodos() {
        ArrayList<Genero> lista = new ArrayList<>();
        String sql = "SELECT * FROM genero";

        PreparedStatement comando = gerenciador.prepararComando(sql);
        ResultSet resultado = null;

        try {
            resultado = comando.executeQuery();
            while (resultado.next()) {
                Genero g = new Genero();
                g.setId(resultado.getInt("id"));
                g.setNome(resultado.getString("nome"));
                lista.add(g);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar gêneros: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return lista;
    }

    public Genero buscarPorId(int id) {
        Genero genero = null;
        String sql = "SELECT * FROM genero WHERE id = ?";

        PreparedStatement comando = gerenciador.prepararComando(sql);
        ResultSet resultado = null;

        try {
            comando.setInt(1, id);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                genero = new Genero();
                genero.setId(resultado.getInt("id"));
                genero.setNome(resultado.getString("nome"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar gênero: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return genero;
    }
}
