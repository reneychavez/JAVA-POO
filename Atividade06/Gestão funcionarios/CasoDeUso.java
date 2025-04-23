public class CasoDeUso {
    public static void main(String[] args) {
        // Criando departamentos
        DepartamentoAdministrativo deptAdm = new DepartamentoAdministrativo("ADM001", "Administrativo", 10000);
        DepartamentoTecnico deptTec = new DepartamentoTecnico("TEC001", "Tecnologia", 50000);
        
        // Criando funcionários
        FuncionarioRegular func1 = new FuncionarioRegular("F001", "João Silva", 3000, deptAdm, 5);
        FuncionarioRegular func2 = new FuncionarioRegular("F002", "Maria Souza", 3500, deptTec, 2);
        Gerente gerente1 = new Gerente("G001", "Carlos Oliveira", 8000, deptAdm, 12000, "Financeira");
        Gerente gerente2 = new Gerente("G002", "Ana Santos", 9000, deptTec, 15000, "Desenvolvimento");
        
        // Adicionando funcionários aos departamentos
        deptAdm.adicionarFuncionario(func1);
        deptAdm.adicionarFuncionario(gerente1);
        deptTec.adicionarFuncionario(func2);
        deptTec.adicionarFuncionario(gerente2);
        
        // Exibindo informações
        System.out.println("=== SISTEMA DE GESTÃO DE FUNCIONÁRIOS ===");
        
        // Exibindo informações dos funcionários
        func1.exibirInformacoes();
        func2.exibirInformacoes();
        gerente1.exibirInformacoes();
        gerente2.exibirInformacoes();
        
        // Exibindo informações dos departamentos
        deptAdm.exibirRelatorio();
        deptAdm.listarFuncionarios();
        
        deptTec.exibirRelatorioTecnico();
        deptTec.listarFuncionarios();
        
        // Ações específicas
        gerente1.realizarReuniao();
        gerente2.realizarReuniao();
        
        // Calculando folha de pagamento total
        double folhaTotal = deptAdm.calcularOrcamento() + deptTec.calcularOrcamento();
        System.out.println("\nFolha de Pagamento Total da Empresa: R$" + folhaTotal);
    }
}