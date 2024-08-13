public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserir(1);
        lista.inserir(2);
        lista.exibir();

        lista.inserir(3);
        lista.exibir();

        System.out.println("Tamanho: " + lista.tamanho());

        lista.remover(1);
        lista.exibir();

        System.out.println("Contém Bart? " + lista.contem(2));

        lista.esvaziar();
        lista.exibir();
    }
}
