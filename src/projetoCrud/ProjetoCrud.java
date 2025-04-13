package projetoCrud;

import controller.AutorController;
import javax.swing.JOptionPane;
import model.Cliente;
import controller.ClienteController;
import utils.Utils;
import controller.GerenciadorConexao;
import model.Autor;
import view.FrMenu;

/**
 *
 * @author gusta
 */
public class ProjetoCrud {

    public static void main(String[] args) {
        // Instancia o menu
        FrMenu menu = new FrMenu();
        menu.setVisible(true);

        // Criação de um autor para cadastro
        Autor autor = new Autor();
        autor.setNome("J.K. Rowling");

        // Criação do controlador de autor e inserção no banco
        AutorController autorController = new AutorController();
        boolean sucesso = autorController.inserir(autor);

        // Exibe uma mensagem confirmando a inserção
        if (sucesso) {
            System.out.println("Autor cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar autor.");
        }
    }

}
