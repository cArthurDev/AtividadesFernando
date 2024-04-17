import java.util.Scanner;
import java.util.Stack;

public class AppInvertida {

    public static String inverterPalavras(String input) {
        String[] palavras = input.split("\\s+");
        Stack<Character> pilha = new Stack<>();
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            pilha.clear();
            for (char letra : palavra.toCharArray()) {
                pilha.push(letra);
            }
            while (!pilha.isEmpty()) {
                resultado.append(pilha.pop());
            }
            if (!palavra.equals(palavras[palavras.length - 1])) {
                resultado.append(" ");
            }
        }
        return resultado.toString();
    }

    public static void main(String[] args) {

        String frase = "FRASE: UM CIENTISTA DA COMPUTAÇAO OU UM TECNÓLOGO EM SISTEMAS PARA INTERNET DEVE RESOLVER OS PROBLEMAS LOGICAMENTE";

        String fraseInvertida = inverterPalavras(frase);
        System.out.println("Frase invertida: " + fraseInvertida);

    }
}
