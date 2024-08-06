import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valo de x: ");
        int x = scanner.nextInt();
        System.out.println("Digite o valo de y: ");
        int y = scanner.nextInt();
        int result = mdc(x, y);
        System.out.println("O MDC de " + x + " e " + y + " é " + result);
    }

    public static int mdc(int x, int y) {
        if (x == y) {
            return x;
        }
        if (x > y) {
            return mdc(x - y, y);
        }
        return mdc(y - x, x);
    }
}
