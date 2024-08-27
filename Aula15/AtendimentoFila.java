import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Pessoa {
    int id;
    String sexo;
    int idade;
    boolean gestante;
    boolean lactante;
    boolean necessidadeEspecial;
    int prioridade;

    public Pessoa(int id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
        this.prioridade = calcularPrioridade();
    }

    private int calcularPrioridade() {
        if (gestante || lactante) {
            return 3;
        } else if (necessidadeEspecial) {
            return 2;
        } else if (idade > 60) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Sexo: " + sexo + ", Idade: " + idade +
                ", Gestante: " + gestante + ", Lactante: " + lactante +
                ", Necessidade Especial: " + necessidadeEspecial +
                ", Prioridade: " + prioridade;
    }
}

public class AtendimentoFila {
    public static void main(String[] args) {
        Queue<Pessoa> fila = new LinkedList<>();
        Deque<Pessoa> deque = new ArrayDeque<>();
        Random random = new Random();

        int totalAtendidos = 0;

        for (int grupo = 1; totalAtendidos < 100; grupo++) {
            for (int i = 1; i <= 10; i++) {
                Pessoa p = gerarPessoa(random, totalAtendidos + i);
                fila.offer(p);
            }

            while (!fila.isEmpty()) {
                Pessoa p = fila.poll();
                if (p.prioridade == 3) {
                    deque.addFirst(p);
                } else if (p.prioridade == 2) {
                    deque.addFirst(p);
                } else if (p.prioridade == 1) {
                    deque.addLast(p);
                } else {
                    deque.offerLast(p);
                }
            }

            int numeroAtendidos = Math.min(grupo, deque.size());
            for (int i = 0; i < numeroAtendidos; i++) {
                Pessoa atendida = deque.pollFirst();
                System.out.println("Atendida: " + atendida);
                totalAtendidos++;
            }
        }

        System.out.println("\nPessoas que não foram atendidas:");
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
        }
    }

    private static Pessoa gerarPessoa(Random random, int id) {
        String sexo = random.nextBoolean() ? "M" : "F";
        int idade = random.nextInt(80) + 18;
        boolean gestante = sexo.equals("F") && random.nextBoolean();
        boolean lactante = sexo.equals("F") && random.nextBoolean();
        boolean necessidadeEspecial = random.nextBoolean();

        return new Pessoa(id, sexo, idade, gestante, lactante, necessidadeEspecial);
    }
}
