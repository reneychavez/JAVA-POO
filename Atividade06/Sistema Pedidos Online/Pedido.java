public class Pedido {
    private String numeroPedido;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Date dataPedido;
    private String status;
    
    public Pedido(String numeroPedido, Cliente cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataPedido = new Date(); // Data atual
        this.status = "Em processamento";
    }
    
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }
    
    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }
    
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }
    
    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }
    
    public void exibirResumo() {
        System.out.println("\nPedido #" + numeroPedido);
        System.out.println("Data: " + dataPedido);
        System.out.println("Status: " + status);
        System.out.println("Itens:");
        
        for (ItemPedido item : itens) {
            System.out.println("- " + item.getNome() + ": R$" + item.calcularPreco());
        }
        
        System.out.println("Total: R$" + calcularTotal());
    }
    
    public void exibirDetalhesCompletos() {
        exibirResumo();
        System.out.println("\nDetalhes do Cliente:");
        cliente.exibirPerfil();
        
        System.out.println("\nDetalhes dos Itens:");
        for (ItemPedido item : itens) {
            item.exibirDetalhes();
            System.out.println();
        }
    }
}