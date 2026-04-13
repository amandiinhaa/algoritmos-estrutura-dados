package L05.Q3Q4;

public class ListaEncadeada<T> {

	private NoLista<T> inicio;

    public ListaEncadeada() {
        inicio = null;
    }

    // insere no início (IMPORTANTE para pilha)
    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>(valor);
        novo.setProximo(inicio);
        inicio = novo;
    }

    // remove do início
    public T retirar() {
        if (inicio == null) {
            throw new PilhaVaziaException("Lista vazia!");
        }

        T valor = inicio.getInfo();
        inicio = inicio.getProximo();
        return valor;
    }

    // consulta o início
    public T getPrimeiro() {
        if (inicio == null) {
            throw new PilhaVaziaException("Lista vazia!");
        }

        return inicio.getInfo();
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void liberar() {
        inicio = null;
    }

    public String toString() {
        String s = "";
        NoLista<T> atual = inicio;

        while (atual != null) {
            s += atual.getInfo();

            if (atual.getProximo() != null) {
                s += ", ";
            }

            atual = atual.getProximo();
        }

        return s;
    }
}
