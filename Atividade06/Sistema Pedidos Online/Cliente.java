public class Cliente extends Usuario {
    private String endereco;
    private List<Pedido> historicoPedidos;
    
    public Cliente(String id, String nome, String email, String endereco) {
        super(id, nome, email);
        this.endereco = endereco;
        this.historicoPedidos = new ArrayList<>();
    }
    
    public void adicionarPedido(Pedido pedido) {
        historicoPedidos.add(pedido);
    }
    
    @Override
    public void exibirPerfil() {
        System.out.println("=== PERFIL DO CLIENTE ===");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Endereço: " + endereco);
        System.out.println("Total de pedidos: " + historicoPedidos.size());
    }
    
    public void listarPedidos() {
        System.out.println("\nHistórico de Pedidos:");
        for (Pedido pedido : historicoPedidos) {
            pedido.exibirResumo();
        }
    }
}