package L05.Q3Q4;

public class PilhaLista<T> implements Pilha<T> {

	private ListaEncadeada<T> lista;

    public PilhaLista() {
        lista = new ListaEncadeada<>();
    }

    // push -> empilha (insere no início)
    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    // pop -> remove do topo
    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }

        return lista.retirar();
    }

    // peek -> consulta topo
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }

        return lista.getPrimeiro();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}