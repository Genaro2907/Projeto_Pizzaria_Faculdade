package projeto_pizzaria_faculdade.Util.items;


import projeto_pizzaria_faculdade.Util.ItemPedido;
import projeto_pizzaria_faculdade.Util.TipoBebida;

public class Bebida extends ItemPedido {
    private String marca;
    private TipoBebida tipo;
    private String tamanho;
    private boolean comGelo;

    public Bebida(String marca, TipoBebida tipo, double preco, String tamanho, boolean comGelo) {
        super(gerarNome(tipo, marca), preco);
        this.marca = marca;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.comGelo = comGelo;
    }

    private static String gerarNome(TipoBebida tipo, String marca) {
        return tipo.toString().charAt(0) + tipo.toString().substring(1).toLowerCase() + " " + marca;
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public TipoBebida getTipo() {
		return tipo;
	}

	public void setTipo(TipoBebida tipo) {
		this.tipo = tipo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public boolean isComGelo() {
		return comGelo;
	}

	public void setComGelo(boolean comGelo) {
		this.comGelo = comGelo;
	}
    
}
