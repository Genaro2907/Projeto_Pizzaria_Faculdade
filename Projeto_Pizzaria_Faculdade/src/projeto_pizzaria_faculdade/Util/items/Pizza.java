
package projeto_pizzaria_faculdade.Util.items;

import java.util.List;

import projeto_pizzaria_faculdade.Util.ItemPedido;

public class Pizza extends ItemPedido {
    // Sabores pré-definidos
    public static final String MARGHERITA = "Margherita";
    public static final String CALABRESA = "Calabresa";
    public static final String PORTUGUESA = "Portuguesa";

    private String tamanho;
    private List<String> ingredientesExtras;

    // Construtor privado para controlar a criação
    private Pizza(String nome, String tamanho, List<String> extras) {
        super(nome, calcularPreco(tamanho, getPrecoBase(nome), extras.size()));
        this.tamanho = tamanho;
        this.ingredientesExtras = extras;
    }

    // Método para obter o preço base baseado no sabor
    private static double getPrecoBase(String sabor) {
        return switch(sabor) {
            case MARGHERITA -> 25.0;
            case CALABRESA -> 30.0;
            case PORTUGUESA -> 35.0;
            default -> 25.0; // Preço padrão
        };
    }

    // Método para calcular o preço total
    private static double calcularPreco(String tamanho, double base, int qtdExtras) {
        return switch(tamanho.toUpperCase()) {
            case "G" -> base + 10.00 + (qtdExtras * 2.5);
            case "M" -> base + 5.00 + (qtdExtras * 2.5);
            default -> base + (qtdExtras * 2.5); // Tamanho P
        };
    }

    // Métodos estáticos para criar pizzas pré-definidas
    public static Pizza criarMargherita(String tamanho, List<String> extras) {
        return new Pizza(MARGHERITA, tamanho, extras);
    }

    public static Pizza criarCalabresa(String tamanho, List<String> extras) {
        return new Pizza(CALABRESA, tamanho, extras);
    }

    public static Pizza criarPortuguesa(String tamanho, List<String> extras) {
        return new Pizza(PORTUGUESA, tamanho, extras);
    }

    // Getters
    public String getTamanho() {
        return tamanho;
    }

    public List<String> getIngredientesExtras() {
        return ingredientesExtras;
    }
}
