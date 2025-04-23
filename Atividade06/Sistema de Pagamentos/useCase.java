public class useCase {
    public static void main(String[] args) {
        // Criando diferentes métodos de pagamento
        MetodoPagamento dinheiro = new PagamentoDinheiro(150.50, 200.00);
        MetodoPagamento cartao = new PagamentoCartaoCredito(250.75, "2023035165345", "Edson Tavares", "12/27", "456");
        
        // Processando os pagamentos
        System.out.println("Processando pagamento em dinheiro:");
        dinheiro.processarPagamento();
        dinheiro.emitirRecibo();
        
        System.out.println("\nProcessando pagamento com cartão:");
        cartao.processarPagamento();
        cartao.emitirRecibo();
        
        // Testando pagamento com cartão inválido
        System.out.println("\nTestando cartão inválido:");
        MetodoPagamento cartaoInvalido = new PagamentoCartaoCredito(500.00, "", "Nome Inválido", "01/23", "129");
        cartaoInvalido.processarPagamento();
    }
}