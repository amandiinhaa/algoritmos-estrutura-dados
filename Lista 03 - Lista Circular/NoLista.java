package L03_ListaCircular;

// Classe que representa um nó da lista
public class NoLista<T> {

	private T info; // valor armazenado no nó
    private NoLista<T> proximo; // referência para o próximo nó

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
}