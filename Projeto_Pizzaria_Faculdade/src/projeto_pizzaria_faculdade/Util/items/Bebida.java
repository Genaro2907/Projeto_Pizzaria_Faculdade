package projeto_pizzaria_faculdade.Util.items;


import projeto_pizzaria_faculdade.Util.ItemPedido;

public class Bebida extends ItemPedido{
	
	private boolean comGelo;
	private String tamanho;
	
	public Bebida(String nome, double preco, String tamanho, boolean comGelo) {
        super(nome, preco);
        this.tamanho = tamanho;
        this.comGelo = comGelo;
    }

	public boolean isComGelo() {
		return comGelo;
	}

	public void setComGelo(boolean comGelo) {
		this.comGelo = comGelo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
}
