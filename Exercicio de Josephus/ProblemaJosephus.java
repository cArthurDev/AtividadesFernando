import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProblemaJosephus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int n = 5;

        List<Pessoa> pessoas = criarPessoas(n);

        int m = random.nextInt(n) + 1; // Gera um número entre 1 e n

        Pessoa sobrevivente = encontrarSobrevivente(pessoas, m, random);

        System.out.println("A pessoa sobrevivente é: " + sobrevivente);

        scanner.close();
    }

    public static List<Pessoa> criarPessoas(int n) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            System.out.println("Digite as informações da pessoa " + i + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            pessoas.add(new Pessoa(i, nome, telefone, endereco, cpf));
        }

        return pessoas;
    }

    public static Pessoa encontrarSobrevivente(List<Pessoa> pessoas, int m, Random random) {
        int index = 0;

        while (pessoas.size() > 1) {

            index = random.nextInt(pessoas.size());

            index = (index + m - 1) % pessoas.size();
            System.out.println("Eliminando - " + pessoas.get(index));
            pessoas.remove(index);
        }
        
        return pessoas.get(0);
    }
}