package projeto_pizzaria_faculdade.Util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import projeto_pizzaria_faculdade.Util.items.StatusPedido;

public class Pedido {
	private static int proximoId= 1;
	
	private int idPedido;
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
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
	
	public double calcularTotal() {
        this.total = itens.stream()
            .mapToDouble(ItemPedido::getPreco)
            .sum();
        return this.total;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        this.total = calcularTotal();
    }

    public boolean removerItem(ItemPedido item) {
        boolean removido = itens.remove(item);
        if (removido) {
            this.total = calcularTotal();
        }
        return removido;
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

            public StatusPedido getStatus() {
                return status;
            }
        

   
}