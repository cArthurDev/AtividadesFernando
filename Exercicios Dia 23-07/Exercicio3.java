import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Aviao {
    String nome;
    int id;

    Aviao(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Avião [Nome: " + nome + ", ID: " + id + "]";
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Aviao> filaDecolagem = new LinkedList<>();

        while (true) {
            System.out.println("\n1. Listar número de aviões na fila de decolagem");
            System.out.println("2. Autorizar decolagem do primeiro avião");
            System.out.println("3. Adicionar avião à fila de espera");
            System.out.println("4. Listar todos os aviões na fila de espera");
            System.out.println("5. Listar características do primeiro avião da fila");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Número de aviões na fila de decolagem: " + filaDecolagem.size());
                    break;
                case 2:
                    if (!filaDecolagem.isEmpty()) {
                        System.out.println("Autorizando decolagem do avião: " + filaDecolagem.poll());
                    } else {
                        System.out.println("Nenhum avião na fila de decolagem.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome do avião:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o ID do avião:");
                    int id = scanner.nextInt();
                    filaDecolagem.add(new Aviao(nome, id));
                    System.out.println("Avião adicionado à fila de espera.");
                    break;
                case 4:
                    if (!filaDecolagem.isEmpty()) {
                        System.out.println("Aviões na fila de espera:");
                        for (Aviao aviao : filaDecolagem) {
                            System.out.println(aviao);
                        }
                    } else {
                        System.out.println("Nenhum avião na fila de espera.");
                    }
                    break;
                case 5:
                    if (!filaDecolagem.isEmpty()) {
                        System.out.println("Primeiro avião na fila: " + filaDecolagem.peek());
                    } else {
                        System.out.println("Nenhum avião na fila de decolagem.");
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
