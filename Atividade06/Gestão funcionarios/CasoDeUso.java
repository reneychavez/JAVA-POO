public class CasoDeUso {
    public static void main(String[] args) {
        // Criando departamentos
        DepartamentoAdministrativo deptAdm = new DepartamentoAdministrativo("ADM001", "Administrativo", 100000);
        DepartamentoTecnico deptTec = new DepartamentoTecnico("TECNO001", "Tecnologia", 500000);
        
        // Criando funcionários
        FuncionarioRegular func1 = new FuncionarioRegular("FUNC01", "Marcos Silva", 3500, deptAdm, 6);
        FuncionarioRegular func2 = new FuncionarioRegular("FUNC02", "Maria Mesa", 4000, deptTec, 4);
        Gerente gerente1 = new Gerente("GER01", "Marcia Oliveira", 8000, deptAdm, 12000, "Financeira");
        Gerente gerente2 = new Gerente("GER02", "Ana Santos", 9000, deptTec, 15000, "Desenvolvimento");
        
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