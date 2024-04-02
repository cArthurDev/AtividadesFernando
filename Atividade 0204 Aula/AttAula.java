package ed1.AtividadeAUla;

public class AttAula {
    public static void main(String[] args) {
        Fila fila = new Fila(); 
        fila.criarFila(10); 
        fila.inserirElemento(10); 
        fila.inserirElemento(20);
        fila.inserirElemento(30); 
        System.out.println("Elemento removido: " + fila.removerElemento()); 
        int posicao = fila.localizarElemento(20); 
        if (posicao != -1) {
            System.out.println("Elemento 20 encontrado na posição: " + posicao);
        } else {
            System.out.println("Elemento 20 não encontrado na fila.");
        }
        fila.destruirFila();
    }
}
