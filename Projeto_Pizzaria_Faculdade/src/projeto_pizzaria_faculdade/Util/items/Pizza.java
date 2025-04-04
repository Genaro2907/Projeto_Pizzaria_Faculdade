package projeto_pizzaria_faculdade.Util.items;

import java.util.ArrayList;
import java.util.List;
import projeto_pizzaria_faculdade.Util.ItemPedido;

public class Pizza extends ItemPedido {
    
    public static final String MARGHERITA = "Margherita";
    public static final String CALABRESA = "Calabresa";
    public static final String PORTUGUESA = "Portuguesa";
    public static final String MUSSARELA = "Mussarela";
    public static final String FRANGO_CATUPIRY = "Frango c/ Catupiry";
    public static final String CALABRESA_ACEHBOL = "Calabresa c/ Cebola";
    public static final String BACON = "Bacon";
    public static final String QUATRO_QUEIJOS = "4 Queijos";
    public static final String MARGUERITA_ESPECIAL = "Margherita Especial";
    public static final String NAPOLITANA = "Napolitana";
    public static final String BRIGADEIRO = "Brigadeiro (Doce)";
    public static final String ROMEU_JULIETA = "Romeu e Julieta (Doce)";
    public static final String BORDA_CATUPIRY = "Borda de Catupiry";
    
    private String tamanho;
    private List<String> ingredientesExtras;
    private boolean bordaRecheada;

    private Pizza(String nome, String tamanho, List<String> extras, boolean bordaRecheada) {
        super(nome, calcularPreco(tamanho, getPrecoBase(nome), 
            extras != null ? extras.size() : 0, bordaRecheada));
        this.tamanho = tamanho;
        this.ingredientesExtras = extras != null ? extras : new ArrayList<>();
        this.bordaRecheada = bordaRecheada;
        

        if(bordaRecheada && !this.ingredientesExtras.contains(BORDA_CATUPIRY)) {
            this.ingredientesExtras.add(BORDA_CATUPIRY);
        }
    }
    private static double getPrecoBase(String sabor) {
        return switch(sabor) {
            case MARGHERITA -> 28.0;
            case MUSSARELA -> 30.0;
            case CALABRESA -> 32.0;
            case PORTUGUESA -> 36.0;
            case FRANGO_CATUPIRY -> 38.0;
            case CALABRESA_ACEHBOL -> 34.0;
            case BACON -> 37.0;
            case QUATRO_QUEIJOS -> 40.0;
            case MARGUERITA_ESPECIAL -> 42.0;
            case NAPOLITANA -> 35.0;
            case BRIGADEIRO -> 45.0;
            case ROMEU_JULIETA -> 43.0;
            default -> 30.0;
        };
    }
    private static double calcularPreco(String tamanho, double base, int qtdExtras, boolean bordaRecheada) {
        double preco = switch(tamanho.toUpperCase()) {
            case "G" -> base + 12.00;
            case "M" -> base + 6.00;
            default -> base;
        };
        
        preco += qtdExtras * 3.0;
        
        if (bordaRecheada) {
            preco += 1.00;
        }
        
        return preco;
    }
    public static Pizza criarMargherita(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(MARGHERITA, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarMussarela(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(MUSSARELA, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarCalabresa(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(CALABRESA, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarPortuguesa(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(PORTUGUESA, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarFrangoCatupiry(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(FRANGO_CATUPIRY, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarCalabresaAcebolada(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(CALABRESA_ACEHBOL, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarBacon(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(BACON, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarQuatroQueijos(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(QUATRO_QUEIJOS, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarMargueritaEspecial(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(MARGUERITA_ESPECIAL, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarNapolitana(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(NAPOLITANA, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarBrigadeiro(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(BRIGADEIRO, tamanho, extras, bordaRecheada);
    }

    public static Pizza criarRomeueJulieta(String tamanho, List<String> extras, boolean bordaRecheada) {
        return new Pizza(ROMEU_JULIETA, tamanho, extras, bordaRecheada);
    }

    public String getTamanho() {
        return tamanho;
    }

    public List<String> getIngredientesExtras() {
        return ingredientesExtras;
    }

    public boolean temBordaRecheada() {
        return bordaRecheada;
    }
}