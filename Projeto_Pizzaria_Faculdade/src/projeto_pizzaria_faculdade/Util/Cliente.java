/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_pizzaria_faculdade.Util;

public class Cliente {
    
    String nomeCliente;
    String enderecoCliente;
    public Cliente() {};
    
    public Cliente(String nomeCliente, String enderecoCliente) {
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
    }

    public String getNomeCliente() {
		return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
		return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
    }
    
    

}
