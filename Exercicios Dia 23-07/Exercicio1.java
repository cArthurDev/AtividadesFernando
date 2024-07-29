import java.util.Scanner;
import java.util.Stack;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma sequência de caracteres:");
        String input = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        System.out.print("Texto na ordem inversa: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();

        String normalized = input.replaceAll("[\\s.]", "").toLowerCase();
        stack.clear();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("O texto é um palíndromo.");
        } else {
            System.out.println("O texto não é um palíndromo.");
        }

        scanner.close();
    }
}
