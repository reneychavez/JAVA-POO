public class Main {
    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente = new Cliente("CLI001", "João Silva", "joao@email.com", "Rua das Flores, 123");
        
        // Criando produtos
        ItemPedido livro = new ProdutoFisico("LIV123", "Domain-Driven Design", 89.90, 0.5, "15x21cm");
        ItemPedido ebook = new ProdutoDigital("EBOOK456", "Clean Code", 59.90, "PDF", 5.2);
        ItemPedido celular = new ProdutoFisico("CEL789", "Smartphone XYZ", 1999.90, 0.3, "15x7x0.8cm");
        
        // Criando um pedido
        Pedido pedido1 = new Pedido("PED2023001", cliente);
        pedido1.adicionarItem(livro);
        pedido1.adicionarItem(ebook);
        
        // Adicionando o pedido ao histórico do cliente
        cliente.adicionarPedido(pedido1);
        
        // Criando outro pedido
        Pedido pedido2 = new Pedido("PED2023002", cliente);
        pedido2.adicionarItem(celular);
        pedido2.atualizarStatus("Enviado");
        cliente.adicionarPedido(pedido2);
        
        // Exibindo informações
        cliente.exibirPerfil();
        cliente.listarPedidos();
        
        // Exibindo detalhes de um pedido específico
        System.out.println("\nDetalhes do primeiro pedido:");
        pedido1.exibirDetalhesCompletos();
    }
}