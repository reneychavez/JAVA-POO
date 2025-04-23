public class PagamentoEspecie extends MetodoPagamento {
    private double valorRecebido;
    
    public PagamentoEspecie(double valor, double valorRecebido) {
        super(valor);
        this.valorRecebido = valorRecebido;
    }
    
    @Override
    public void processarPagamento() {
        try {
            if (valorRecebido < getValor()) {
                throw new PagamentoException("Valor recebido é menor que o valor devido.");
            }
            
            double troco = valorRecebido - getValor();
            System.out.println("Pagamento em dinheiro no valor de R$" + getValor() + " realizado.");
            
            if (troco > 0) {
                System.out.println("Troco: R$" + troco);
            }
        } catch (PagamentoException e) {
            System.err.println("Erro no pagamento: " + e.getMessage());
        }
    }
    
    @Override
    public void emitirRecibo() {
        System.out.println("=== RECIBO ===");
        System.out.println("Tipo: Dinheiro");
        System.out.println("Valor: R$" + getValor());
        System.out.println("Valor recebido: R$" + valorRecebido);
        System.out.println("Troco: R$" + (valorRecebido - getValor()));
        System.out.println("==============");
    }
}