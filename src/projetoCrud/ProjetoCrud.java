package projetoCrud;

import javax.swing.JOptionPane;
import model.Cliente;
import controller.ClienteController;
import utils.Utils;
import controller.GerenciadorConexao;

/**
 *
 * @author gusta
 */
public class ProjetoCrud {

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
