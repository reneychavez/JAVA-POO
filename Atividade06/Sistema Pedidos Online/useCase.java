public class useCase {
    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente = new Cliente("CLI001", "Mateus Sousa", "mateSsous@gmail.com", "Rua Casemiro, 123");
        
        // Criando produtos
        ItemPedido livro = new ProdutoFisico("LIVRO222", "Clean Architecture", 99.90, 0.10, "12x21cm");
        ItemPedido ebook = new ProdutoDigital("EBOOK4", "Clean Code", 79.90, "PDF", 10.2);
        ItemPedido celular = new ProdutoFisico("CEL789", "POCO X7", 1999.90, 2.3, "19x8x0.9cm");
        
        // Criando um pedido
        Pedido pedido1 = new Pedido("LIV202501", cliente);
        pedido1.adicionarItem(livro);
        pedido1.adicionarItem(ebook);
        
        // Adicionando o pedido ao histórico do cliente
        cliente.adicionarPedido(pedido1);
        
        // Criando outro pedido
        Pedido pedido2 = new Pedido("CELL202501", cliente);
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