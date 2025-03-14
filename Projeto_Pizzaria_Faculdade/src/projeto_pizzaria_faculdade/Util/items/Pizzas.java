package projeto_pizzaria_faculdade.Util.items;

import java.util.List;

import projeto_pizzaria_faculdade.Util.ItemPedido;

public class Pizzas extends ItemPedido{
	
	private String tamanho;
	private List<String> ingredientesExtras;
	
	
	public Pizzas(String nome, double precoBase, String tamanho, List<String> extras) {
		super(nome, calcularPreco(tamanho,precoBase, extras.size()));
		
		this.tamanho = tamanho;
		this.ingredientesExtras = extras;
	}


	private static double calcularPreco(String tamanho, double base, int qtdExtras) {
		return switch(tamanho.toUpperCase()) {
		 case "G" -> base + 10.00 + (qtdExtras * 2.5);
         case "M" -> base + 5.00 + (qtdExtras * 2.5);
         default -> base + (qtdExtras * 2.5); // Tamanho P
		};
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public List<String> getIngredientesExtras() {
		return ingredientesExtras;
	}

	public void setIngredientesExtras(List<String> ingredientesExtras) {
		this.ingredientesExtras = ingredientesExtras;
	}
	

}
