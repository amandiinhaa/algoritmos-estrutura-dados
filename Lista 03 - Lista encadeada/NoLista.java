package L03;

// Classe genérica que representa um nó da lista encadeada
public class NoLista<T> {

	// variável que guarda a informação armazenada no nó
    private T info;

    // referência para o próximo nó da lista
    private NoLista<T> proximo;

    // retorna a informação armazenada no nó
    public T getInfo() {
        return info;
    }

    // define a informação que será armazenada no nó
    public void setInfo(T info) {
        this.info = info;
    }

    // retorna o próximo nó da lista
    public NoLista<T> getProximo() {
        return proximo;
    }

    // define qual será o próximo nó
    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
}