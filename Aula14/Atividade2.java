import java.util.Scanner;

class No {
    int dado;
    No proximo;

    No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class Pilha {
    private No topo;

    Pilha() {
        this.topo = null;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void empilhar(int dado) {
        No novoNo = new No(dado);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public int desempilhar() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia");
        }
        int dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public int contarElementos() {
        int contador = 0;
        No atual = topo;
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }

    public void mostrarElementos() {
        No atual = topo;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class Atividade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilhaPar = new Pilha();
        Pilha pilhaImpar = new Pilha();

        int valor;
        System.out.println("Digite valores inteiros entre -127 e 128 (0 para encerrar):");

        do {
            valor = scanner.nextInt();
            if (valor == 0) break;

            if (valor % 2 == 0) {
                pilhaPar.empilhar(valor);
            } else {
                pilhaImpar.empilhar(valor);
            }
        } while (valor != 0);

        System.out.println("\nRemovendo elementos alternadamente das pilhas:");
        boolean parVazio = false;
        boolean imparVazio = false;

        while (!pilhaPar.estaVazia() && !pilhaImpar.estaVazia()) {
            if (!pilhaImpar.estaVazia()) {
                System.out.println("Retirado da PILHA ÍMPAR: " + pilhaImpar.desempilhar());
            }
            if (!pilhaPar.estaVazia()) {
                System.out.println("Retirado da PILHA PAR: " + pilhaPar.desempilhar());
            }
        }

        if (pilhaPar.estaVazia() && pilhaImpar.estaVazia()) {
            System.out.println("\nAmbas as pilhas estão vazias.");
        } else {
            if (!pilhaImpar.estaVazia()) {
                System.out.println("\nA PILHA ÍMPAR ainda possui elementos.");
                System.out.println("Total de elementos restantes: " + pilhaImpar.contarElementos());
                System.out.print("Elementos restantes na PILHA ÍMPAR: ");
                pilhaImpar.mostrarElementos();
            } else {
                System.out.println("\nA PILHA PAR ainda possui elementos.");
                System.out.println("Total de elementos restantes: " + pilhaPar.contarElementos());
                System.out.print("Elementos restantes na PILHA PAR: ");
                pilhaPar.mostrarElementos();
            }
        }

        scanner.close();
    }
}
