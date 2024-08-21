import java.util.Random;
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

    public void mostrarElementos() {
        No atual = topo;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class Atividade3 {
    public static void main(String[] args) {
        Random random = new Random();

        Pilha pilha1 = new Pilha();
        Pilha pilha2 = new Pilha();
        Pilha pilha3 = new Pilha();

        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(9) + 1;
            if (numero >= 1 && numero <= 3) {
                pilha1.empilhar(numero);
            } else if (numero >= 4 && numero <= 6) {
                pilha2.empilhar(numero);
            } else if (numero >= 7 && numero <= 9) {
                pilha3.empilhar(numero);
            }
        }

        System.out.println("Fase 1 - Pilhas após sorteio:");
        imprimirPilhas(pilha1, pilha2, pilha3);


        for (int i = 0; i < 100; i++) {
            int escolhaPilha = random.nextInt(3) + 1;
            if (pilha1.estaVazia() || pilha2.estaVazia() || pilha3.estaVazia()) {
                break;
            }
            int topoPilha1 = pilha1.desempilhar();
            int topoPilha2 = pilha2.desempilhar();
            int topoPilha3 = pilha3.desempilhar();

            if (escolhaPilha == 1) {
                System.out.println("Empilhando os números " + topoPilha2 + " e " + topoPilha3 + " na pilha 1");
                pilha1.empilhar(topoPilha2);
                pilha1.empilhar(topoPilha3);
            } else if (escolhaPilha == 2) {
                System.out.println("Empilhando os números " + topoPilha1 + " e " + topoPilha3 + " na pilha 2");
                pilha2.empilhar(topoPilha1);
                pilha2.empilhar(topoPilha3);
            } else if (escolhaPilha == 3) {
                System.out.println("Empilhando os números " + topoPilha1 + " e " + topoPilha2 + " na pilha 3");
                pilha3.empilhar(topoPilha1);
                pilha3.empilhar(topoPilha2);
            }

            if (pilha1.estaVazia() || pilha2.estaVazia() || pilha3.estaVazia()) {
                break;
            }
        }

        System.out.println("\nFase 2 - Pilhas após redistribuição:");
        imprimirPilhas(pilha1, pilha2, pilha3);

        if (pilha1.estaVazia()) {
            System.out.println("O programa foi encerrado porque a pilha 1 está vazia.");
        } else if (pilha2.estaVazia()) {
            System.out.println("O programa foi encerrado porque a pilha 2 está vazia.");
        } else if (pilha3.estaVazia()) {
            System.out.println("O programa foi encerrado porque a pilha 3 está vazia.");
        } else {
            System.out.println("O programa foi encerrado porque os 100 números sorteados foram atingidos.");
        }
    }

    public static void imprimirPilhas(Pilha pilha1, Pilha pilha2, Pilha pilha3) {
        System.out.println("Pilha 1:");
        pilha1.mostrarElementos();

        System.out.println("Pilha 2:");
        pilha2.mostrarElementos();

        System.out.println("Pilha 3:");
        pilha3.mostrarElementos();
    }
}
