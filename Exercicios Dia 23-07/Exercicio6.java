import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Exercicio6 {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            fila.add(random.nextInt(100) + 1);
            fila.add(-(random.nextInt(100) + 1));
        }

        while (!fila.isEmpty()) {
            int num = fila.poll();
            if (num > 0) {
                pilha.push(num);
            } else {
                if (!pilha.isEmpty()) {
                    System.out.println("Número no topo da pilha: " + pilha.pop());
                }
            }
        }
    }
}
