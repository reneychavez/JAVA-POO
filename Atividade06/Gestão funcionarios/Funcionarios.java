// Funcionário comum
public class FuncionarioRegular extends Funcionario {
    private int horasExtras;
    
    public FuncionarioRegular(String matricula, String nome, double salarioBase, Departamento departamento, int horasExtras) {
        super(matricula, nome, salarioBase, departamento);
        this.horasExtras = horasExtras;
    }
    
    @Override
    public double calcularSalario() {
        // Salário base + valor das horas extras (R$50 por hora)
        return getSalarioBase() + (horasExtras * 50);
    }
    
    @Override
    public void exibirInformacoes() {
        System.out.println("\nFuncionário Regular:");
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Nome: " + getNome());
        System.out.println("Departamento: " + getDepartamento().getNome());
        System.out.println("Salário Base: R$" + getSalarioBase());
        System.out.println("Horas Extras: " + horasExtras);
        System.out.println("Salário Total: R$" + calcularSalario());
    }
}

// Gerente
public class Gerente extends Funcionario {
    private double bonusAnual;
    private String areaResponsavel;
    
    public Gerente(String matricula, String nome, double salarioBase, Departamento departamento, 
                  double bonusAnual, String areaResponsavel) {
        super(matricula, nome, salarioBase, departamento);
        this.bonusAnual = bonusAnual;
        this.areaResponsavel = areaResponsavel;
    }
    
    @Override
    public double calcularSalario() {
        // Salário base + parte do bônus anual (dividido por 12)
        return getSalarioBase() + (bonusAnual / 12);
    }
    
    @Override
    public void exibirInformacoes() {
        System.out.println("\nGerente:");
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Nome: " + getNome());
        System.out.println("Departamento: " + getDepartamento().getNome());
        System.out.println("Área Responsável: " + areaResponsavel);
        System.out.println("Salário Base: R$" + getSalarioBase());
        System.out.println("Bônus Anual: R$" + bonusAnual);
        System.out.println("Salário Total (com bônus mensal): R$" + calcularSalario());
    }
    
    // Método específico para gerentes
    public void realizarReuniao() {
        System.out.println(getNome() + " está realizando uma reunião com a equipe da área " + areaResponsavel);
    }
}