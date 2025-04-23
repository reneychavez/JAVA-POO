// Classe abstrata para representar um usuário do sistema
public abstract class Usuario {
    private String id;
    private String nome;
    private String email;
    
    public Usuario(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    
    // Método abstrato para exibir informações específicas do tipo de usuário
    public abstract void exibirPerfil();
}

// Classe abstrata para representar um item genérico que pode ser pedido
public abstract class ItemPedido {
    private String codigo;
    private String nome;
    private double preco;
    
    public ItemPedido(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    
    // Método abstrato para calcular preço com possíveis descontos/adicionais
    public abstract double calcularPreco();
    
    // Método abstrato para exibir detalhes específicos do item
    public abstract void exibirDetalhes();
}