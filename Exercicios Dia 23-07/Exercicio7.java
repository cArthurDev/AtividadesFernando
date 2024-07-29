import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Exercicio7 {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            fila.add(random.nextInt(100));
        }

        while (!fila.isEmpty()) {
            pilha.push(fila.poll());
        }
        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }

        System.out.println("Fila invertida: " + fila);
    }
}
