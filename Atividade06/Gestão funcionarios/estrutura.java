public abstract class Funcionario {
    private String matricula;
    private String nome;
    private double salarioBase;
    private Departamento departamento;
    
    public Funcionario(String matricula, String nome, double salarioBase, Departamento departamento) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }
    
    // Getters e Setters
    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public double getSalarioBase() { return salarioBase; }
    public Departamento getDepartamento() { return departamento; }
    
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
    
    // Método para cálculo do salário
    public abstract double calcularSalario();
    
    // Método para exibir informações específicas do funcionário
    public abstract void exibirInformacoes();
}

// Classe para representar um departamento
public abstract class Departamento {
    private String codigo;
    private String nome;
    private List<Funcionario> funcionarios;
    
    public Departamento(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
    
    // Método para adicionar funcionário ao departamento
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        funcionario.setDepartamento(this);
    }
    
    // Método abstrato para calcular orçamento do departamento
    public abstract double calcularOrcamento();
    
    // Método para listar todos os funcionários do departamento
    public void listarFuncionarios() {
        System.out.println("\nFuncionários do departamento " + nome + ":");
        for (Funcionario func : funcionarios) {
            System.out.println("- " + func.getNome() + " (" + func.getMatricula() + ")");
        }
    }
}