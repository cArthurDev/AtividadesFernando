import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valo de N: ");
        int N = scanner.nextInt();
        System.out.println("Digite o valo de k: ");
        int K = scanner.nextInt();
        int count = contagemDigito(Integer.toString(N), Character.forDigit(K, 10));
        System.out.println("O dígito " + K + " ocorre " + count + " vezes no número " + N);
    }

    public static int contagemDigito(String N, char K) {
        if (N.isEmpty()) {
            return 0;
        }

        int count = (N.charAt(0) == K) ? 1 : 0;

        return count + contagemDigito(N.substring(1), K);
    }
}
