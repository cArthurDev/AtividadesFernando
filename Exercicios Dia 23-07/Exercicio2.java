import java.util.Scanner;
import java.util.Stack;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Digite os elementos da pilha (inteiros, termine com -1):");
        int element;
        while ((element = scanner.nextInt()) != -1) {
            stack.push(element);
        }

        System.out.println("Digite a chave a ser removida:");
        int key = scanner.nextInt();

        Stack<Integer> auxStack = new Stack<>();

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (top != key) {
                auxStack.push(top);
            }
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }

        System.out.println("Pilha após remoção do elemento:");
        for (int item : stack) {
            System.out.println(item);
        }

        scanner.close();
    }
}
