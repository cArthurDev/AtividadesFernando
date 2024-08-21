import java.util.Scanner;

class No {
    char dado;
    No proximo;

    No(char dado) {
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

    public void empilhar(char dado) {
        No novoNo = new No(dado);
        novoNo.proximo = topo;
        topo = novoNo;
    }

    public char desempilhar() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia");
        }
        char dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public char espiar() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha vazia");
        }
        return topo.dado;
    }
}

public class Atividade1 {
    public static boolean verificarExpressao(String expressao) {
        Pilha pilha = new Pilha();

        for (int i = 0; i < expressao.length(); i++) {
            char ch = expressao.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                pilha.empilhar(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (pilha.estaVazia()) {
                    return false;
                }

                char topo = pilha.desempilhar();
                if ((ch == ')' && topo != '(') ||
                        (ch == '}' && topo != '{') ||
                        (ch == ']' && topo != '[')) {
                    return false;
                }
            }
        }

        return pilha.estaVazia();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma expressão: ");
        String expressao = scanner.nextLine();

        if (verificarExpressao(expressao)) {
            System.out.println("A expressão está correta.");
        } else {
            System.out.println("A expressão está incorreta.");
        }

        scanner.close();
    }
}
