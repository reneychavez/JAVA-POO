
public class Main {
    public static void main(String[] args) {
        TempoIntegral funcionarioTempoIntegral = new TempoIntegral(4500);
        System.out.println("Salário do Funcionário de Tempo Integral: R$" + String.format("%.2f", funcionarioTempoIntegral.calcularSalario()));

        MeioPeriodo funcionarioMeioPeriodo = new MeioPeriodo(50, 60);
        System.out.println("Salário do Funcionário de Meio Período: R$" + String.format("%.2f", funcionarioMeioPeriodo.calcularSalario()));

        Contratados funcionarioContratado = new Contratados(2500);
        System.out.println("Salário do Funcionário Contratado: R$" + String.format("%.2f", funcionarioContratado.calcularSalario()));
    }
}