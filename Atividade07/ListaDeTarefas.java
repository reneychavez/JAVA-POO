import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeTarefas {
    public static void main(String[] args) {
        List<String> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Lista de Tarefas ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Listar tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opcao: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa a ser adicionada: ");
                    String novaTarefa = scanner.nextLine();
                    tarefas.add(novaTarefa);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;
                    
                case 2:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas está vazia!");
                    } else {
                        System.out.println("Tarefas disponíveis:");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                        System.out.print("Digite o número da tarefa a ser removida: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < tarefas.size()) {
                            String tarefaRemovida = tarefas.remove(indice);
                            System.out.println("Tarefa '" + tarefaRemovida + "' removida com sucesso!");
                        } else {
                            System.out.println("Índice inválido!");
                        }
                    }
                    break;
                    
                case 3:
                    if (tarefas.isEmpty()) {
                        System.out.println("A lista de tarefas está vazia!");
                    } else {
                        System.out.println("\n--- Tarefas ---");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("Saindo do aplicativo...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}