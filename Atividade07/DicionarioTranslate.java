import java.io.*;
import java.util.*;

public class DicionarioTranslate {
    private static final String ARQUIVO_DICIONARIO = "dicionario.dat";
    private static Map<String, Map<String, String>> dicionario = new HashMap<>();
    private static String idiomaPrincipal = "en";
    private static String idiomaSecundario = "pt";

    public static void main(String[] args) {
        carregarDicionario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== DICIONÁRIO AVANÇADO ===");
            System.out.println("1. Traduzir palavra");
            System.out.println("2. Adicionar palavra");
            System.out.println("3. Alterar idiomas (Atual: " + idiomaPrincipal + "->" + idiomaSecundario + ")");
            System.out.println("4. Listar todas as palavras");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        traduzirPalavra(scanner);
                        break;
                    case 2:
                        adicionarPalavra(scanner);
                        break;
                    case 3:
                        alterarIdiomas(scanner);
                        break;
                    case 4:
                        listarPalavras();
                        break;
                    case 5:
                        salvarDicionario();
                        System.out.println("Dicionário salvo. Até logo!");
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

    private static void traduzirPalavra(Scanner scanner) {
        System.out.print("Digite a palavra para traduzir (" + idiomaPrincipal + "->" + idiomaSecundario + "): ");
        String palavra = scanner.nextLine().toLowerCase();

        if (dicionario.containsKey(idiomaPrincipal)) {
            Map<String, String> traducoes = dicionario.get(idiomaPrincipal);
            if (traducoes.containsKey(palavra)) {
                System.out.println("Tradução: " + traducoes.get(palavra));
            } else {
                System.out.println("Palavra não encontrada no dicionário.");
            }
        } else {
            System.out.println("Idioma principal não configurado corretamente.");
        }
    }

    private static void adicionarPalavra(Scanner scanner) {
        System.out.print("Digite a palavra no idioma " + idiomaPrincipal + ": ");
        String palavra = scanner.nextLine().toLowerCase();
        System.out.print("Digite a tradução para " + idiomaSecundario + ": ");
        String traducao = scanner.nextLine().toLowerCase();

        // Adicionar no idioma principal
        dicionario.computeIfAbsent(idiomaPrincipal, k -> new HashMap<>()).put(palavra, traducao);
        // Adicionar no idioma secundário (para busca reversa)
        dicionario.computeIfAbsent(idiomaSecundario, k -> new HashMap<>()).put(traducao, palavra);
        
        System.out.println("Palavra adicionada com sucesso!");
    }

    private static void alterarIdiomas(Scanner scanner) {
        System.out.print("Digite o código do idioma principal (ex: en, pt, es): ");
        String novoPrimario = scanner.nextLine().toLowerCase();
        System.out.print("Digite o código do idioma secundário: ");
        String novoSecundario = scanner.nextLine().toLowerCase();

        if (!dicionario.containsKey(novoPrimario)) {
            dicionario.put(novoPrimario, new HashMap<>());
        }
        if (!dicionario.containsKey(novoSecundario)) {
            dicionario.put(novoSecundario, new HashMap<>());
        }

        idiomaPrincipal = novoPrimario;
        idiomaSecundario = novoSecundario;
        System.out.println("Idiomas alterados para: " + idiomaPrincipal + "->" + idiomaSecundario);
    }

    private static void listarPalavras() {
        if (dicionario.containsKey(idiomaPrincipal)) {
            System.out.println("\nPalavras disponíveis (" + idiomaPrincipal + "->" + idiomaSecundario + "):");
            dicionario.get(idiomaPrincipal).forEach((palavra, traducao) -> 
                System.out.println(palavra + " -> " + traducao));
        } else {
            System.out.println("Idioma principal não possui palavras cadastradas.");
        }
    }

    @SuppressWarnings("unchecked")
    private static void carregarDicionario() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_DICIONARIO))) {
            dicionario = (Map<String, Map<String, String>>) ois.readObject();
            System.out.println("Dicionário carregado com sucesso!");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dicionário não encontrado. Criando novo dicionário.");
            inicializarDicionarioPadrao();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dicionário. Criando novo dicionário.");
            inicializarDicionarioPadrao();
        }
    }

    private static void salvarDicionario() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DICIONARIO))) {
            oos.writeObject(dicionario);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dicionário: " + e.getMessage());
        }
    }

    private static void inicializarDicionarioPadrao() {
        dicionario.put("en", new HashMap<>()); // Inglês
        dicionario.put("pt", new HashMap<>()); // Português
        
        // Adicionar algumas palavras padrão
        dicionario.get("en").put("hello", "olá");
        dicionario.get("pt").put("olá", "hello");
        
        dicionario.get("en").put("world", "mundo");
        dicionario.get("pt").put("mundo", "world");
        
        dicionario.get("en").put("computer", "computador");
        dicionario.get("pt").put("computador", "computer");
    }
}