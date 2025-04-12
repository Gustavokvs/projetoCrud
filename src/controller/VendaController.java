
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Venda;
import model.Livro;
import model.Cliente;


public class VendaController {
    
    private List<Venda> vendas = new ArrayList<>();
    
    public Venda criarVenda(Cliente cliente, List<Livro> livros, int quantidade){
        Venda novaVenda = new Venda();
        novaVenda.setId(vendas.size()+1);
        novaVenda.setCliente(cliente);
        novaVenda.setLivros(livros);
        novaVenda.setQuantidade(quantidade);
        novaVenda.setDataVenda(new Date());
        
        vendas.add(novaVenda);
        
        return novaVenda;
    }
    
    public List<Venda>listarVendas(){
        return vendas;
    }
    
    public Venda buscarVendaPorId(int id){
        for(Venda venda : vendas){
            if(venda.getId()== id){
                return venda;
            }
        }
        return null;
    } 
    
    
  }

   
    
    

