
abstract class Funcionarios {
    public abstract double calcularSalario();
}

class MeioPeriodo extends Funcionarios {
    private double salarioPorHora;
    private double horasTrabalhadas;

    public MeioPeriodo(double salarioPorHora, double horasTrabalhadas) {
        this.salarioPorHora = salarioPorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularSalario() {
        return salarioPorHora * horasTrabalhadas;
    }
}

class Contratados extends Funcionarios {
    private double valorServico;

    public Contratados(double valorServico) {
        this.valorServico = valorServico;
    }

    @Override
    public double calcularSalario() {
        return valorServico;
    }
}

class TempoIntegral extends Funcionarios {
    private double salario;

    public TempoIntegral(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
}