/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto_pizzaria_faculdade;

import java.util.ArrayList;

import projeto_pizzaria_faculdade.Util.Cliente;
import projeto_pizzaria_faculdade.Util.Pedido;
import projeto_pizzaria_faculdade.Util.TipoBebida;
import projeto_pizzaria_faculdade.Util.items.Bebida;
import projeto_pizzaria_faculdade.Util.items.Pizza;
import projeto_pizzaria_faculdade.Util.items.StatusPedido;

/**
 *
 * @author Gabriel
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	        Cliente cliente = new Cliente("João Silva", "Rua das Flores, 123");
    	        
    	        Pedido pedido = new Pedido(cliente);
    	        
    	        pedido.adicionarItem(new Pizza("Margherita", 25.0, "Média", new ArrayList<>()));
    	        
    	        Bebida refrigerante = new Bebida("Coca-Cola", TipoBebida.REFRIGERANTE, 8.0, "500ml", true);
    	        Bebida agua = new Bebida("Minalba", TipoBebida.AGUA, 5.0, "500ml", false);
    	        Bebida cerveja = new Bebida("Heineken", TipoBebida.CERVEJA, 10.0, "600ml", true);
    	        
    	        pedido.adicionarItem(refrigerante);
    	        pedido.adicionarItem(agua);
    	        pedido.adicionarItem(cerveja);
    	        
    	        pedido.setStatus(StatusPedido.EM_PREPARO);
    	        
    	        System.out.println("========== DETALHES DO PEDIDO ==========");
    	        System.out.println(pedido.getDetalhesPedido());
    	        System.out.println("========================================");
    	        
    	        System.out.println("\nTodos os pedidos registrados:");
    	        for (Pedido p : Pedido.getTodosPedidos()) {
    	            System.out.println("Pedido #" + p.getIdPedido() + " - " + p.getCliente().getNomeCliente());
    	   }
    }
  
}
