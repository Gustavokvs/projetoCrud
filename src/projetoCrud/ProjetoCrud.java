package projetoCrud;

import controller.AutorController;
import javax.swing.JOptionPane;
import model.Cliente;
import controller.ClienteController;
import utils.Utils;
import controller.GerenciadorConexao;
import model.Autor;
/**
 *
 * @author gusta
 */
public class ProjetoCrud {
    
    public static void main(String[] args) {
        // Instanciando um objeto Autor
        Autor autor = new Autor();
        autor.setNome("J.K. Rowling");

        // Criando uma instância do controlador AutorController
        AutorController autorController = new AutorController();

        // Inserindo o autor no banco de dados
        boolean sucesso = autorController.inserir(autor);

        if (sucesso) {
            System.out.println("Autor inserido com sucesso!");
        } else {
            System.out.println("Erro ao inserir o autor.");
        }

        // Exibindo a instância criada
        System.out.println("Autor: " + autor.getNome());
    }

    /* public static void main(String[] args) {

        GerenciadorConexao conexao = new GerenciadorConexao();
        ClienteController clienteControl = new ClienteController();
        Cliente c = new Cliente();

        c.setNome("Gustavo");
        c.setEmail("gustavo@gmail.com");
        c.setId(1);
        c.setDataNascimento(Utils.converterStringToDate("18/12/2004"));

        if (clienteControl.inserir(c)) {
            JOptionPane.showMessageDialog(null, "Usuário gravado com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "O cadastro não foi gravado");

        }

    }*/
}
