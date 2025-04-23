// Departamento administrativo
public class DepartamentoAdministrativo extends Departamento {
    private double verbaGerencial;
    
    public DepartamentoAdministrativo(String codigo, String nome, double verbaGerencial) {
        super(codigo, nome);
        this.verbaGerencial = verbaGerencial;
    }
    
    @Override
    public double calcularOrcamento() {
        // Soma dos salários + verba gerencial
        double totalSalarios = 0;
        for (Funcionario func : getFuncionarios()) {
            totalSalarios += func.calcularSalario();
        }
        return totalSalarios + verbaGerencial;
    }
    
    public void exibirRelatorio() {
        System.out.println("\nRelatório do Departamento Administrativo - " + getNome());
        System.out.println("Verba Gerencial: R$" + verbaGerencial);
        System.out.println("Total de Funcionários: " + getFuncionarios().size());
        System.out.println("Orçamento Total: R$" + calcularOrcamento());
    }
}

// Departamento técnico
public class DepartamentoTecnico extends Departamento {
    private double verbaEquipamentos;
    
    public DepartamentoTecnico(String codigo, String nome, double verbaEquipamentos) {
        super(codigo, nome);
        this.verbaEquipamentos = verbaEquipamentos;
    }
    
    @Override
    public double calcularOrcamento() {
        // Soma dos salários + verba de equipamentos
        double totalSalarios = 0;
        for (Funcionario func : getFuncionarios()) {
            totalSalarios += func.calcularSalario();
        }
        return totalSalarios + verbaEquipamentos;
    }
    
    public void exibirRelatorioTecnico() {
        System.out.println("\nRelatório do Departamento Técnico - " + getNome());
        System.out.println("Verba para Equipamentos: R$" + verbaEquipamentos);
        System.out.println("Total de Funcionários: " + getFuncionarios().size());
        System.out.println("Orçamento Total: R$" + calcularOrcamento());
    }
}