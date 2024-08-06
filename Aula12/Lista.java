public class Lista {
    private No cabeça;
    private int tamanho;

    public Lista() {
        this.cabeça = null;
        this.tamanho = 0;
    }

    public void inicializar() {
        this.cabeça = null;
        this.tamanho = 0;
    }

    public boolean isVazia() {
        return cabeça == null;
    }

    public void inserir(int elemento) {
        No novo = new No(elemento);
        if (cabeça == null || cabeça.getInfo() >= elemento) {
            novo.setProx(cabeça);
            cabeça = novo;
        } else {
            No atual = cabeça;
            while (atual.getProx() != null && atual.getProx().getInfo() < elemento) {
                atual = atual.getProx();
            }
            novo.setProx(atual.getProx());
            atual.setProx(novo);
        }
        tamanho++;
    }

    public void remover(int elemento) {
        if (cabeça == null) return;
        if (cabeça.getInfo() == elemento) {
            cabeça = cabeça.getProx();
            tamanho--;
            return;
        }
        No atual = cabeça;
        while (atual.getProx() != null && atual.getProx().getInfo() != elemento) {
            atual = atual.getProx();
        }
        if (atual.getProx() != null) {
            atual.setProx(atual.getProx().getProx());
            tamanho--;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean iguais(Lista outra) {
        if (this.tamanho != outra.tamanho) return false;
        No atual1 = this.cabeça;
        No atual2 = outra.cabeça;
        while (atual1 != null) {
            if (atual1.getInfo() != atual2.getInfo()) return false;
            atual1 = atual1.getProx();
            atual2 = atual2.getProx();
        }
        return true;
    }

    public double media() {
        if (cabeça == null) return 0;
        int soma = 0;
        No atual = cabeça;
        while (atual != null) {
            soma += atual.getInfo();
            atual = atual.getProx();
        }
        return (double) soma / tamanho;
    }

    public String busca(int valor) {
        No atual = cabeça;
        while (atual != null) {
            if (atual.getInfo() == valor) return "sim";
            atual = atual.getProx();
        }
        return "não";
    }

    public void elimina(int elemento) {
        while (cabeça != null && cabeça.getInfo() == elemento) {
            cabeça = cabeça.getProx();
            tamanho--;
        }
        No atual = cabeça;
        while (atual != null && atual.getProx() != null) {
            if (atual.getProx().getInfo() == elemento) {
                atual.setProx(atual.getProx().getProx());
                tamanho--;
            } else {
                atual = atual.getProx();
            }
        }
    }

    public void eliminaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return;
        if (posicao == 0) {
            cabeça = cabeça.getProx();
        } else {
            No atual = cabeça;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProx();
            }
            atual.setProx(atual.getProx().getProx());
        }
        tamanho--;
    }

    public void insereDireita(int posicao, int valor) {
        if (posicao < 0 || posicao >= tamanho) return;
        No novo = new No(valor);
        No atual = cabeça;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProx();
        }
        novo.setProx(atual.getProx());
        atual.setProx(novo);
        tamanho++;
    }

    public void insereEsquerda(int posicao, int valor) {
        if (posicao < 0 || posicao >= tamanho) return;
        No novo = new No(valor);
        if (posicao == 0) {
            novo.setProx(cabeça);
            cabeça = novo;
        } else {
            No atual = cabeça;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProx();
            }
            novo.setProx(atual.getProx());
            atual.setProx(novo);
        }
        tamanho++;
    }
}