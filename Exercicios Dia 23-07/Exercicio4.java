import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Exercicio4 {
    public static void main(String[] args) {
        Queue<Integer> filaF1 = new LinkedList<>();
        Queue<Integer> filaF2 = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            filaF1.add(random.nextInt(1000));
        }

        Stack<Integer> stack = new Stack<>();
        while (!filaF1.isEmpty()) {
            stack.push(filaF1.poll());
        }
        while (!stack.isEmpty()) {
            filaF2.add(stack.pop());
        }

        System.out.println("Fila F1 invertida (F2): " + filaF2);
    }
}
