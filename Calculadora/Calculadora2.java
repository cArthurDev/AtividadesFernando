package Calculadora;

//Construir um programa de uma calculadora funcional com as 4 operações básicas. Deve ser informado em qual tipo de notação a expressão estará sendo inserida na calculadora
//(infixa, pós-fixa ou pré-fixa) realizar o cálculo e após o cálculo apresentar a expressão nas três notações.

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Calculadora2 {
    public static double calcularPosfixa(String expressao) {
        Deque<Double> pilha = new ArrayDeque<>();

        for (char token : expressao.toCharArray()) {
            if (Character.isDigit(token)) {
                pilha.push((double) Character.getNumericValue(token));
            } else {
                double operando2 = pilha.pop();
                double operando1 = pilha.pop();
                double resultado = 0;
                switch (token) {
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }
                pilha.push(resultado);
            }
        }

        return pilha.pop(); 
    }

    public static double calcularPrefixa(String expressao) {
        Deque<Double> pilha = new ArrayDeque<>();

        for (int i = expressao.length() - 1; i >= 0; i--) {
            char token = expressao.charAt(i);
            if (Character.isDigit(token)) {
                pilha.push((double) Character.getNumericValue(token));
            } else {
                double operando1 = pilha.pop();
                double operando2 = pilha.pop();
                double resultado = 0;
                switch (token) {
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }
                pilha.push(resultado);
            }
        }

        return pilha.pop();
    }

    public static double calcularInfixa(String expressao) {
        String expressaoPosfixa = infixarParaPosfixa(expressao);
        return calcularPosfixa(expressaoPosfixa);
    }

    public static String infixarParaPosfixa(String expressao) {
        StringBuilder saida = new StringBuilder();
        Deque<Character> pilha = new ArrayDeque<>();

        for (char ch : expressao.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                saida.append(ch);
            } else if (ch == '(') {
                pilha.push(ch);
            } else if (ch == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    saida.append(pilha.pop());
                }
                if (!pilha.isEmpty() && pilha.peek() == '(') {
                    pilha.pop(); // Remover o '(' da pilha
                }
            } else {
                while (!pilha.isEmpty() && precedencia(pilha.peek()) >= precedencia(ch)) {
                    saida.append(pilha.pop());
                }
                pilha.push(ch);
            }
        }

        while (!pilha.isEmpty()) {
            saida.append(pilha.pop());
        }

        return saida.toString();
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static String infixarParaPrefixa(String expressao) {
        StringBuilder saida = new StringBuilder();
        Deque<Character> pilha = new ArrayDeque<>();

        for (int i = expressao.length() - 1; i >= 0; i--) {
            char ch = expressao.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                saida.append(ch);
            } else if (ch == ')') {
                pilha.push(ch);
            } else if (ch == '(') {
                while (!pilha.isEmpty() && pilha.peek() != ')') {
                    saida.append(pilha.pop());
                }
                if (!pilha.isEmpty() && pilha.peek() == ')') {
                    pilha.pop();
                }
            } else {
                while (!pilha.isEmpty() && precedencia(pilha.peek()) > precedencia(ch)) {
                    saida.append(pilha.pop());
                }
                pilha.push(ch);
            }
        }

        while (!pilha.isEmpty()) {
            saida.append(pilha.pop());
        }

        return saida.reverse().toString();
    }

    public static String posfixaParaInfixa(String expressao) {
        Deque<String> pilha = new ArrayDeque<>();

        for (char token : expressao.toCharArray()) {
            if (Character.isDigit(token)) {
                pilha.push(Character.toString(token));
            } else {
                String operando2 = pilha.pop();
                String operando1 = pilha.pop();
                String resultado = "(" + operando1 + token + operando2 + ")";
                pilha.push(resultado);
            }
        }

        return pilha.pop();
    }

    public static String prefixaParaInfixa(String expressao) {
        Deque<String> pilha = new ArrayDeque<>();

        for (int i = expressao.length() - 1; i >= 0; i--) {
            char ch = expressao.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                pilha.push(Character.toString(ch));
            } else {
                String operando1 = pilha.pop();
                String operando2 = pilha.pop();
                String resultado = "(" + operando1 + ch + operando2 + ")";
                pilha.push(resultado);
            }
        }

        return pilha.pop();
    }

    public static String prefixaParaPosfixa(String expressao) {
        Deque<String> pilha = new ArrayDeque<>();

        for (int i = expressao.length() - 1; i >= 0; i--) {
            char token = expressao.charAt(i);
            if (Character.isDigit(token)) {
                pilha.push(Character.toString(token));
            } else {
                String operando1 = pilha.pop();
                String operando2 = pilha.pop();
                String resultado = operando1 + operando2 + token;
                pilha.push(resultado);
            }
        }

        return pilha.pop();
    }

    public static String posfixaParaPrefixa(String expressao) {
        Deque<String> pilha = new ArrayDeque<>();

        for (char token : expressao.toCharArray()) {
            if (Character.isDigit(token)) {
                pilha.push(Character.toString(token));
            } else {
                String operando2 = pilha.pop();
                String operando1 = pilha.pop();
                String resultado = operando2 + operando1 + token;
                pilha.push(resultado);
            }
        }

        return pilha.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de notação:");
        System.out.println("1. Infixa");
        System.out.println("2. Pós-fixa");
        System.out.println("3. Pré-fixa");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a expressão:");
        String expressao = scanner.nextLine();

        String expressaoConvertida = "";
        String expressaoInfixa = "";
        String expressaoPrefixa = "";
        double resultado = 0;
        switch (opcao) {
            case 1:
                expressaoConvertida = infixarParaPosfixa(expressao);
                expressaoInfixa = expressao;
                expressaoPrefixa = infixarParaPrefixa(expressao);
                resultado = calcularInfixa(expressao);
                break;
            case 2:
                expressaoInfixa = posfixaParaInfixa(expressao);
                expressaoConvertida = expressao;
                expressaoPrefixa = posfixaParaPrefixa(expressao);
                resultado = calcularPosfixa(expressao);
                break;
            case 3:
                expressaoConvertida = infixarParaPrefixa(expressao);
                expressaoInfixa = prefixaParaInfixa(expressao);
                expressaoPrefixa = expressao;
                resultado = calcularPrefixa(expressao);
                break;
        }

        System.out.println("Resultado: " + resultado);
        System.out.println("Expressão convertida para infixa: " + expressaoInfixa);
        System.out.println("Expressão convertida para pós-fixa: " + expressaoConvertida);
        System.out.println("Expressão convertida para pré-fixa: " + expressaoPrefixa);
        scanner.close();
    }
}
