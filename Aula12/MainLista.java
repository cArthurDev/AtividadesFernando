public class MainLista {
    public static void main(String[] args) {
        Lista lista = new Lista();

        // Initialize the list
        lista.inicializar();

        // Insert elements
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);

        // Print the size of the list
        System.out.println("Tamanho da lista: " + lista.tamanho());

        // Check if the list is empty
        System.out.println("A lista está vazia? " + lista.isVazia());

        // Remove an element
        lista.remover(30);
        System.out.println("Tamanho da lista após remover 30: " + lista.tamanho());

        // Check if a value is in the list
        System.out.println("O valor 20 está na lista? " + lista.busca(20));

        // Calculate the average of elements
        System.out.println("Média dos elementos da lista: " + lista.media());

        // Remove all occurrences of an element
        lista.elimina(20);
        System.out.println("Tamanho da lista após eliminar todas as ocorrências de 20: " + lista.tamanho());

        // Insert a value to the right of the 1st element
        lista.insereDireita(1, 25);
        System.out.println("Tamanho da lista após inserir 25 à direita do 1º elemento: " + lista.tamanho());

        // Insert a value to the left of the 1st element
        lista.insereEsquerda(1, 15);
        System.out.println("Tamanho da lista após inserir 15 à esquerda do 1º elemento: " + lista.tamanho());

        // Remove an element at a given position
        lista.eliminaPosicao(2);
        System.out.println("Tamanho da lista após eliminar o elemento na posição 2: " + lista.tamanho());
    }
}