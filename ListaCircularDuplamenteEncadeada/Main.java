package ListaCircularDuplamenteEncadeada;

import java.util.Random;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class CircularDoublyLinkedList {
    Node sentinel;

    CircularDoublyLinkedList() {
        sentinel = new Node(0);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void insertSorted(int value) {
        Node newNode = new Node(value);
        Node current = sentinel.next;

        while (current != sentinel && current.data < value) {
            current = current.next;
        }

        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
    }

    public void printList() {
        Node current = sentinel.next;
        if (current == sentinel) {
            System.out.println("Lista está vazia.");
            return;
        }
        while (current != sentinel) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printDescending() {
        Node current = sentinel.prev;
        if (current == sentinel) {
            System.out.println("Lista está vazia.");
            return;
        }
        while (current != sentinel) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public void removePrimes() {
        Node current = sentinel.next;
        while (current != sentinel) {
            if (isPrime(current.data)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            current = current.next;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] vetor = new int[10];

        System.out.print("Vetor => [");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(19999) - 9999;
            System.out.print(vetor[i]);
            if (i < vetor.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        for (int num : vetor) {
            list.insertSorted(num);
            System.out.print("Lista => ");
            list.printList();
        }

        System.out.println("Lista em ordem crescente:");
        list.printList();

        System.out.println("Lista em ordem decrescente:");
        list.printDescending();

        list.removePrimes();
        System.out.println("Lista após remoção dos números primos:");
        list.printList();
    }
}

