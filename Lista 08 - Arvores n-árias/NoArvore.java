package L08;

public class NoArvore<T> {
	
    private T info;
    private NoArvore<T> primeiro; // primeiro filho
    private NoArvore<T> proximo;  // próximo irmão

    // Construtor
    public NoArvore(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }

    // Insere um filho (no início da lista de filhos)
    public void inserirFilho(NoArvore<T> filho) {
        filho.setProximo(this.primeiro); // novo filho aponta para o antigo primeiro
        this.primeiro = filho;           // atualiza o primeiro filho
    }

    // Getters e setters
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoArvore<T> primeiro) {
        this.primeiro = primeiro;
    }

    public NoArvore<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoArvore<T> proximo) {
        this.proximo = proximo;
    }
}
