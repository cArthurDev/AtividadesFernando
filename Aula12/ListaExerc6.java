import java.util.ArrayList;
import java.util.Collections;

public class ListaExerc6 {
    GeradorListasExerc6 gerarLista = new GeradorListasExerc6();

    ArrayList<Integer> lista1 = gerarLista.gerarLista(50);
    ArrayList<Integer> lista2 = gerarLista.gerarLista(50);

    public void mostrarLista(ArrayList<Integer> lista) {
        System.out.println(lista);
    }

    public ArrayList<Integer> getLista1() {
        return lista1;
    }

    public ArrayList<Integer> getLista2() {
        return lista2;
    }

    public ArrayList<Integer> inverterLista(ArrayList<Integer> lista) {
        ArrayList<Integer> listaInvertida = new ArrayList<>(lista);
        Collections.reverse(listaInvertida);
        return listaInvertida;
    }

    public ArrayList<Integer> retornaImpares(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.addAll(lista1);
        lista.addAll(lista2);

        ArrayList<Integer> impares = new ArrayList<>();
        for (int num : lista) {
            if (num % 2 != 0) {
                impares.add(num);
            }
        }
        return impares;
    }

    public ArrayList<Integer> concatena(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> listaConcatenada = new ArrayList<>(lista1);
        listaConcatenada.addAll(lista2);
        return listaConcatenada;
    }
    public ArrayList<Integer> intersecao(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> intersecao = new ArrayList<>();
        for (Integer num : lista1) {
            if (lista2.contains(num)) {
                intersecao.add(num);
            }
        }
        return intersecao;
    }
    public static ArrayList<Integer> intercalar1(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> intercalada = new ArrayList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            intercalada.add(lista1.get(i++));
            intercalada.add(lista2.get(j++));
        }

        while (i < lista1.size()) {
            intercalada.add(lista1.get(i++));
        }

        while (j < lista2.size()) {
            intercalada.add(lista2.get(j++));
        }

        return intercalada;
    }

    public static ArrayList<Integer> intercalar2(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> intercalada = new ArrayList<>();
        int i = 0, j = 0;

        Collections.sort(lista1);
        Collections.sort(lista2);

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                intercalada.add(lista1.get(i++));
            } else {
                intercalada.add(lista2.get(j++));
            }
        }

        while (i < lista1.size()) {
            intercalada.add(lista1.get(i++));
        }

        while (j < lista2.size()) {
            intercalada.add(lista2.get(j++));
        }

        return intercalada;
    }
}