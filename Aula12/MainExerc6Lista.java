import java.util.ArrayList;

public class MainExerc6Lista {

    public static void main(String[] args) {
        ListaExerc6 listaexerc = new ListaExerc6();

        System.out.println("Lista 1");
        listaexerc.mostrarLista(listaexerc.getLista1());

        System.out.println("\nLista 1 invertida");
        System.out.println(listaexerc.inverterLista(listaexerc.getLista1()));

        System.out.println("\nLista 2");
        listaexerc.mostrarLista(listaexerc.getLista2());

        System.out.println("\nLista 2 invertida");
        System.out.println(listaexerc.inverterLista(listaexerc.getLista2()));

        System.out.println("\nLista 1 e 2 impares");
        System.out.println(listaexerc.retornaImpares(listaexerc.getLista1(), listaexerc.getLista2()));

        System.out.println("\nConcatenação entre lista 1 e 2");
        System.out.println(listaexerc.concatena(listaexerc.getLista1(), listaexerc.getLista2()));

        System.out.println("\nInterseção entre lista 1 e 2");
        ArrayList<Integer> intersecao = listaexerc.intersecao(listaexerc.getLista1(), listaexerc.getLista2());
        listaexerc.mostrarLista(intersecao);

        System.out.println("\nIntercalar 1 entre lista 1 e 2:");
        ArrayList<Integer> intercalada1 = ListaExerc6.intercalar1(listaexerc.getLista1(), listaexerc.getLista2());
        listaexerc.mostrarLista(intercalada1);

        System.out.println("\nIntercalar 2 entre lista 1 e 2 (em ordem crescente):");
        ArrayList<Integer> intercalada2 = ListaExerc6.intercalar2(listaexerc.getLista1(), listaexerc.getLista2());
        listaexerc.mostrarLista(intercalada2);
    }
}