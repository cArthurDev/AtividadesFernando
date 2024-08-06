import java.util.ArrayList;
import java.util.Random;

public class GeradorListasExerc6 {
    Random rand = new Random();

    public ArrayList<Integer> gerarLista(int n) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            lista.add(rand.nextInt(-100,101));
        }
        return lista;
    }
}
