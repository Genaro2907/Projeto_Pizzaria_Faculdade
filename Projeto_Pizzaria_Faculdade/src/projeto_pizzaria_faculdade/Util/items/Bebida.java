package projeto_pizzaria_faculdade.Util.items;


import projeto_pizzaria_faculdade.Util.ItemPedido;

public class Bebida extends ItemPedido {
    // Tipos pré-definidos de bebidas
    public static final String COCA_COLA = "Coca-Cola";
    public static final String GUARANA = "Guaraná";
    public static final String AGUA_MINERAL = "Água Mineral";
    
    // Tamanhos pré-definidos
    public enum Tamanho {
        PEQUENO(300, 5.0),  // 300ml
        MEDIO(500, 7.0),    // 500ml
        GRANDE(1000, 10.0); // 1L
        
        private final int ml;
        private final double precoBase;
        
        Tamanho(int ml, double precoBase) {
            this.ml = ml;
            this.precoBase = precoBase;
        }
        
        public int getMl() { return ml; }
        public double getPrecoBase() { return precoBase; }
    }

    private String marca;
    private Tamanho tamanho;
    private boolean comGelo;

    // Construtor privado para controlar a criação
    private Bebida(String marca, Tamanho tamanho, boolean comGelo) {
        super(marca, calcularPreco(tamanho));
        this.marca = marca;
        this.tamanho = tamanho;
        this.comGelo = comGelo;
    }

    // Método para calcular preço baseado no tamanho
    private static double calcularPreco(Tamanho tamanho) {
        return tamanho.getPrecoBase();
    }

    // Métodos estáticos para criar bebidas pré-definidas
    public static Bebida criarCocaCola(Tamanho tamanho, boolean comGelo) {
        return new Bebida(COCA_COLA, tamanho, comGelo);
    }

    public static Bebida criarGuarana(Tamanho tamanho, boolean comGelo) {
        return new Bebida(GUARANA, tamanho, comGelo);
    }

    public static Bebida criarAguaMineral(Tamanho tamanho, boolean comGelo) {
        return new Bebida(AGUA_MINERAL, tamanho, comGelo);
    }

    // Getters
    public String getMarca() { return marca; }
    public Tamanho getTamanho() { return tamanho; }
    public boolean isComGelo() { return comGelo; }
}