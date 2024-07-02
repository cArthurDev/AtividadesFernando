import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class TorresDeHanoi {

    static class HanoiTask extends RecursiveAction {
        int n;
        char origem, destino, auxiliar;
        boolean print;

        HanoiTask(int n, char origem, char destino, char auxiliar, boolean print) {
            this.n = n;
            this.origem = origem;
            this.destino = destino;
            this.auxiliar = auxiliar;
            this.print = print;
        }

        @Override
        protected void compute() {
            if (n <= 10) {
                resolverSequencial(n, origem, destino, auxiliar);
            } else {
                HanoiTask task1 = new HanoiTask(n - 1, origem, auxiliar, destino, false);
                HanoiTask task2 = new HanoiTask(1, origem, destino, auxiliar, print);
                HanoiTask task3 = new HanoiTask(n - 1, auxiliar, destino, origem, false);

                invokeAll(task1, task2, task3);
            }
        }

        private void resolverSequencial(int n, char origem, char destino, char auxiliar) {
            if (n == 1) {
                if (print) {
                    System.out.println(" Disco " + n + " de " + origem + " para " + destino);
                }
                return;
            }
            resolverSequencial(n - 1, origem, auxiliar, destino);
            if (print) {
                System.out.println(" Disco " + n + " de " + origem + " para " + destino);
            }
            resolverSequencial(n - 1, auxiliar, destino, origem);
        }
    }

    public static void main(String[] args) {
        int n = 40;

        long startTime = System.currentTimeMillis();

        long movimento = (long) Math.pow(2, n) - 1;

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new HanoiTask(n, 'A','C', 'B', false));

        long endTime = System.currentTimeMillis();
        long tempoMilissegundos = endTime - startTime;

        long tempoSegundos = tempoMilissegundos / 1000;
        long milissegundosRestantes = tempoMilissegundos % 1000;
        long minutos = (tempoSegundos % 3600) / 60;
        long segundos = tempoSegundos % 60;


        System.out.println("Número de movimentos: " + movimento);
        System.out.format("Tempo Levado para Resolver: %02d Minutos %02d Segundos %d Milissegundos%n", minutos, segundos, milissegundosRestantes);
    }
}
