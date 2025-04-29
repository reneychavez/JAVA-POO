import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RemocaoDuplicatas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite os itens separados por vírgula (ex: maçã, laranja, uva, banana):");
        String entrada = scanner.nextLine();
        
        // Dividir a entrada em itens individuais
        List<String> itens = Arrays.asList(entrada.split("\\s*,\\s*"));
        
        // Usar Set para remover duplicatas
        Set<String> itensUnicos = new HashSet<>(itens);
        
        // Converter de volta para List
        List<String> listaSemDuplicatas = new ArrayList<>(itensUnicos);
        
        System.out.println("\nLista original: " + itens);
        System.out.println("Lista sem duplicatas: " + listaSemDuplicatas);
    }
}