
public class ProdutoFisico extends ItemPedido {
    private double peso;
    private String dimensoes;
    
    public ProdutoFisico(String codigo, String nome, double preco, double peso, String dimensoes) {
        super(codigo, nome, preco);
        this.peso = peso;
        this.dimensoes = dimensoes;
    }
    
    @Override
    public double calcularPreco() {
        // Produtos físicos podem ter acréscimo por frete
        double frete = peso * 0.5; // Simulação de cálculo de frete
        return getPreco() + frete;
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Produto Físico: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Preço base: R$" + getPreco());
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Dimensões: " + dimensoes);
        System.out.println("Preço final (com frete): R$" + calcularPreco());
    }
}

// Produto digital (ex: ebook, curso online)
public class ProdutoDigital extends ItemPedido {
    private String formato;
    private double tamanhoMB;
    
    public ProdutoDigital(String codigo, String nome, double preco, String formato, double tamanhoMB) {
        super(codigo, nome, preco);
        this.formato = formato;
        this.tamanhoMB = tamanhoMB;
    }
    
    @Override
    public double calcularPreco() {
        // Produtos digitais podem ter desconto promocional
        return getPreco() * 0.9; // 10% de desconto
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Produto Digital: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Formato: " + formato);
        System.out.println("Tamanho: " + tamanhoMB + " MB");
        System.out.println("Preço com desconto: R$" + calcularPreco());
    }
}