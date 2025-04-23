public class PagamentoCartaoCredito extends MetodoPagamento implements Autenticavel {
    private String numeroCartao;
    private String nomeTitular;
    private String dataValidade;
    private String cvv;
    
    public PagamentoCartaoCredito(double valor, String numeroCartao, String nomeTitular, String dataValidade, String cvv) {
        super(valor);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }
    
    @Override
    public boolean autenticar() {
        // Simulação de autenticação - na prática, seria uma chamada a um serviço externo
        return numeroCartao != null && !numeroCartao.isEmpty() 
               && cvv != null && cvv.length() == 3;
    }
    
    @Override
    public void processarPagamento() {
        try {
            if (!autenticar()) {
                throw new PagamentoException("Falha na autenticação do cartão.");
            }
            
            // Simulação de processamento do pagamento
            System.out.println("Processando pagamento com cartão de crédito...");
            System.out.println("Pagamento no valor de R$" + getValor() + " aprovado.");
        } catch (PagamentoException e) {
            System.err.println("Erro no pagamento: " + e.getMessage());
        }
    }
    
    @Override
    public void emitirRecibo() {
        System.out.println("=== RECIBO ===");
        System.out.println("Tipo: Cartão de Crédito");
        System.out.println("Valor: R$" + getValor());
        System.out.println("Número do cartão: **** **** **** " + numeroCartao.substring(12));
        System.out.println("Titular: " + nomeTitular);
        System.out.println("==============");
    }
}