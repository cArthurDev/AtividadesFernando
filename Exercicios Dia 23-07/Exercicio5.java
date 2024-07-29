import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Exercicio5 {
    public static void main(String[] args) {
        Queue<Integer> filaF = new LinkedList<>();
        Stack<Integer> pilhaP = new Stack<>();
        Set<Integer> set = new HashSet<>();
        Random random = new Random();

        while (filaF.size() < 100) {
            int num = random.nextInt(1000);
            if (set.add(num)) {
                filaF.add(num);
            }
        }

        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(1000);
            if (set.add(num)) {
                filaF.add(num);
            } else {
                pilhaP.add(num);
            }
        }

        System.out.println("Fila F: " + filaF);
        System.out.println("Pilha P: " + pilhaP);
    }
}
