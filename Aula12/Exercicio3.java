import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valo de x: ");
        int x = scanner.nextInt();
        System.out.println("Digite o valo de y: ");
        int y = scanner.nextInt();
        int result = mod(x, y);
        System.out.println("O resto da divisão de " + x + " por " + y + " é " + result);
    }

    public static int mod(int x, int y) {
        if (x == y) {
            return 0;
        }
        if (x < y) {
            return x;
        }
        return mod(x - y, y);
    }
}
