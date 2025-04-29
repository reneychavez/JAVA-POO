import java.util.*;
import java.io.*;

public class GerenciadorContatos {
    private static final String ARQUIVO_CONTATOS = "contatos.dat";
    private static Map<String, Contato> contatos = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    private static class Contato implements Serializable, Comparable<Contato> {
        private String nome;
        private String telefone;
        private String email;

        public Contato(String nome, String telefone, String email) {
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email + "\n";
        }

        // Implementação para ordenação natural (por nome)
        @Override
        public int compareTo(Contato outro) {
            return this.nome.compareToIgnoreCase(outro.nome);
        }

        // Getters
        public String getNome() { return nome; }
        public String getTelefone() { return telefone; }
        public String getEmail() { return email; }
        
        // Setters
        public void setTelefone(String telefone) { this.telefone = telefone; }
        public void setEmail(String email) { this.email = email; }
    }

    public static void main(String[] args) {
        carregarContatos();
        exibirMenu();
    }

    private static void exibirMenu() {
        while (true) {
            System.out.println("\n=== GERENCIADOR DE CONTATOS ===");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Buscar contato");
            System.out.println("3. Listar contatos");
            System.out.println("4. Remover contato");
            System.out.println("5. Editar contato");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        adicionarContato();
                        break;
                    case 2:
                        buscarContato();
                        break;
                    case 3:
                        menuOrdenacao();
                        break;
                    case 4:
                        removerContato();
                        break;
                    case 5:
                        editarContato();
                        break;
                    case 6:
                        salvarContatos();
                        System.out.println("Contatos salvos. Até logo!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um número válido.");
                scanner.nextLine(); // Limpar input inválido
            }
        }
    }

    private static void menuOrdenacao() {
        System.out.println("\n=== ORDENAR CONTATOS POR ===");
        System.out.println("1. Nome (A-Z)");
        System.out.println("2. Telefone");
        System.out.println("3. Email");
        System.out.println("4. Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        switch (opcao) {
            case 1:
                listarContatos(Comparator.comparing(Contato::getNome, String.CASE_INSENSITIVE_ORDER));
                break;
            case 2:
                listarContatos(Comparator.comparing(Contato::getTelefone));
                break;
            case 3:
                listarContatos(Comparator.comparing(Contato::getEmail));
                break;
            case 4:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void listarContatos(Comparator<Contato> comparador) {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
            return;
        }

        // Converter valores do Map para List e ordenar
        List<Contato> contatosOrdenados = new ArrayList<>(contatos.values());
        contatosOrdenados.sort(comparador);

        System.out.println("\n=== LISTA DE CONTATOS ===");
        contatosOrdenados.forEach(contato -> {
            System.out.println(contato);
            System.out.println("---------------------");
        });
    }

    // Métodos restantes permanecem iguais (adicionarContato, buscarContato, removerContato, editarContato, carregarContatos, salvarContatos)
    // ... (manter todos os outros métodos existentes sem alterações)
    
    private static void adicionarContato() {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        contatos.put(nome.toLowerCase(), new Contato(nome, telefone, email));
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void buscarContato() {
        System.out.print("Digite o nome do contato a buscar: ");
        String nome = scanner.nextLine().toLowerCase();

        Contato contato = contatos.get(nome);
        if (contato != null) {
            System.out.println("\nContato encontrado:\n" + contato);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void removerContato() {
        System.out.print("Digite o nome do contato a remover: ");
        String nome = scanner.nextLine().toLowerCase();

        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void editarContato() {
        System.out.print("Digite o nome do contato a editar: ");
        String nome = scanner.nextLine().toLowerCase();

        Contato contato = contatos.get(nome);
        if (contato == null) {
            System.out.println("Contato não encontrado.");
            return;
        }

        System.out.println("\nEditando contato:\n" + contato);
        System.out.println("1. Editar telefone");
        System.out.println("2. Editar email");
        System.out.println("3. Cancelar");
        System.out.print("Escolha o que editar: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        switch (opcao) {
            case 1:
                System.out.print("Novo telefone: ");
                contato.setTelefone(scanner.nextLine());
                System.out.println("Telefone atualizado!");
                break;
            case 2:
                System.out.print("Novo email: ");
                contato.setEmail(scanner.nextLine());
                System.out.println("Email atualizado!");
                break;
            case 3:
                System.out.println("Edição cancelada.");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    @SuppressWarnings("unchecked")
    private static void carregarContatos() {
        File arquivo = new File(ARQUIVO_CONTATOS);
        if (!arquivo.exists()) {
            System.out.println("Arquivo de contatos não encontrado. Iniciando com lista vazia.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            Object obj = ois.readObject();
            if (obj instanceof HashMap) {
                contatos = (HashMap<String, Contato>) obj;
                System.out.println("Contatos carregados com sucesso!");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }

    private static void salvarContatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))) {
            oos.writeObject(contatos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }
}