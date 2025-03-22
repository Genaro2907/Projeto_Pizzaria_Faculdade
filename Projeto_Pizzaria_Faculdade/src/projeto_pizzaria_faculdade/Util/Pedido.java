package projeto_pizzaria_faculdade.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import projeto_pizzaria_faculdade.Util.items.Bebida;
import projeto_pizzaria_faculdade.Util.items.Pizza;
import projeto_pizzaria_faculdade.Util.items.StatusPedido;

public class Pedido {
	private static int proximoId= 1;
	
	private int idPedido;
	private Cliente cliente;
	private List<ItemPedido> itens;
	private LocalDateTime dataHora;
	private double total;
	private StatusPedido status;
	private static List<Pedido> todosPedidos = new ArrayList<>();
	
        public Pedido(){};
	public Pedido(Cliente cliente) {
		this.idPedido = proximoId++;
		this.cliente = cliente;
		this.itens = new ArrayList<>();
		this.dataHora = LocalDateTime.now();
		this.status = StatusPedido.EM_ABERTO;
		this.total = 0.0;
		todosPedidos.add(this);
	}
	
	public void adicionarItem(ItemPedido item) {
	    itens.add(item);
	    calcularTotal(); 
	}

	public boolean removerItem(ItemPedido item) {
	    boolean removido = itens.remove(item);
	    if(removido) {
	        calcularTotal();
	    }
	    return removido;
	}
	private void calcularTotal() {
	    this.total = itens.stream()
	        .mapToDouble(ItemPedido::getPreco)
	        .sum();
	}
	public static List<Pedido> getTodosPedidos() {
	    return new ArrayList<>(todosPedidos); //
	}
    public String getDetalhesPedido() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(idPedido).append("\n");
        sb.append("Cliente: ").append(cliente.getNomeCliente()).append("\n");
        sb.append("Endereço: ").append(cliente.getEnderecoCliente()).append("\n");
        sb.append("Data/Hora: ").append(DateTimeFormatter
            .ofPattern("dd/MM/yyyy HH:mm").format(dataHora)).append("\n");
        sb.append("Itens:\n");
        
        for (ItemPedido item : itens) {
            if (item instanceof Pizza) {
            	Pizza pizza = (Pizza) item;
                sb.append("- Pizza ").append(pizza.getNome())
                  .append(" (Tamanho: ").append(pizza.getTamanho())
                  .append(", Extras: ").append(String.join(", ", pizza.getIngredientesExtras()))
                  .append(") → R$ ").append(pizza.getPreco()).append("\n");
            } else if (item instanceof Bebida) {
                Bebida bebida = (Bebida) item;
                sb.append("- ")
                  .append(bebida.getTipo().toString().charAt(0))
                  .append(bebida.getTipo().toString().substring(1).toLowerCase())
                  .append(" ")
                  .append(bebida.getMarca())
                  .append(" (")
                  .append(bebida.getTamanho())
                  .append(", Gelo: ").append(bebida.isComGelo() ? "Sim" : "Não")
                  .append(") → R$ ").append(bebida.getPreco()).append("\n");
            }
        }
        
        sb.append("\nTotal: R$ ").append(String.format("%.2f", total));
        sb.append("\nStatus: ").append(status);
        
        return sb.toString();
    }
	public int getIdPedido() {
		return idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public double getTotal() {
		return total;
	}
	
	public void setStatus(StatusPedido status) {
	        this.status = status;
	    }
}
