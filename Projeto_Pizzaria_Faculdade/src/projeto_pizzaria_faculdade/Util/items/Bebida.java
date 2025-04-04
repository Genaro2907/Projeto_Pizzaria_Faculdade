package projeto_pizzaria_faculdade.Util.items;


import projeto_pizzaria_faculdade.Util.ItemPedido;

public class Bebida extends ItemPedido {
    
    public static final String REFRIGERANTE_COCA_COLA = "Refrigerante Coca-Cola";
    public static final String REFRIGERANTE_COCA_COLA_ZERO = "Refrigerante Coca-Cola Zero Açucar";
    public static final String REFRIGERANTE_GUARANA = "Refrigerante Guaraná";
    public static final String REFRIGERANTE_PEPSI = "Refrigerante Pepsi";
    public static final String REFRIGERANTE_PEPSI_BLACK = "Refrigerante Pepsi Black";
    public static final String AGUA_MINERAL_CRISTAL = "Água Mineral Cristal";
    public static final String CERVEJA_HEINEKEN = "Cerveja Heineken";
    public static final String CERVEJA_SKOL = "Cerveja Skol";
    
    public enum Tamanho {
        PEQUENO(300, 5.00),  
        MEDIO(500, 7.00),    
        GRANDE(1000, 10.00); 
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

    private Bebida(String marca, Tamanho tamanho, boolean comGelo) {
    super(marca, calcularPreco(marca, tamanho));
    this.marca = marca;
    this.tamanho = tamanho;
    this.comGelo = comGelo;
    }


    private static double calcularPreco(String marca, Tamanho tamanho) {
    double precoBase = tamanho.getPrecoBase();
      switch(marca) {
        case REFRIGERANTE_COCA_COLA:
            return precoBase + 1.50; 
        case REFRIGERANTE_COCA_COLA_ZERO:
            return precoBase + 2.00;
        case REFRIGERANTE_GUARANA:
            return precoBase + 1.00;
        case REFRIGERANTE_PEPSI:
            return precoBase + 1.00;
        case REFRIGERANTE_PEPSI_BLACK:
            return precoBase + 2.50;
        case AGUA_MINERAL_CRISTAL:
            return precoBase - 1.00; 
        case CERVEJA_HEINEKEN:
            return precoBase + 5.00; 
        case CERVEJA_SKOL:
            return precoBase + 3.00;
        default:
            return precoBase;
    }
}

    public static Bebida criarRefrigeranteCocaCola(Tamanho tamanho, boolean comGelo) {
        return new Bebida(REFRIGERANTE_COCA_COLA, tamanho, comGelo);
    }
        public static Bebida criarRefrigeranteCocaColaZero(Tamanho tamanho, boolean comGelo) {
        return new Bebida(REFRIGERANTE_COCA_COLA_ZERO, tamanho, comGelo);
    }

    public static Bebida criarRefrigeranteGuarana(Tamanho tamanho, boolean comGelo) {
        return new Bebida(REFRIGERANTE_GUARANA, tamanho, comGelo);
    }
    public static Bebida criarRefrigerantePepsi(Tamanho tamanho, boolean comGelo) {
        return new Bebida(REFRIGERANTE_PEPSI, tamanho, comGelo);
    }
        public static Bebida criarRefrigerantePepsiBlack(Tamanho tamanho, boolean comGelo) {
        return new Bebida(REFRIGERANTE_PEPSI_BLACK, tamanho, comGelo);
    }
    public static Bebida criarAguaMineral(Tamanho tamanho, boolean comGelo) {
        return new Bebida(AGUA_MINERAL_CRISTAL, tamanho, comGelo);
    }
    public static Bebida criarCervejaHeineken(Tamanho tamanho, boolean comGelo) {
        return new Bebida(CERVEJA_HEINEKEN, tamanho, comGelo);
    }
    public static Bebida criarCervejaSkol(Tamanho tamanho, boolean comGelo) {
        return new Bebida(CERVEJA_SKOL, tamanho, comGelo);
    }
    
    public String getMarca() { return marca; }
    public Tamanho getTamanho() { return tamanho; }
    public boolean isComGelo() { return comGelo; }
}