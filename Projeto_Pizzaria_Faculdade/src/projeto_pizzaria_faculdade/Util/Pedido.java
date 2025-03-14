package projeto_pizzaria_faculdade.Util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private static int proximoId= 1;
	
	private int idPedido;
	private Cliente cliente;
	private List<ItemPedido> itens;
	private LocalDateTime dataHora;
	private double total;
	
	
	public Pedido(Cliente cliente) {
		this.idPedido = proximoId++;
		this.cliente = cliente;
		this.itens = new ArrayList<>();
		this.dataHora = LocalDateTime.now();
		this.total = 0.0;
	}
	
	public void adicionarItem(ItemPedido item) {
        itens.add(item);
        total += item.getPreco();
    }

    public void removerItem(int index) {
        ItemPedido removido = itens.remove(index);
        total -= removido.getPreco();
    }

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
