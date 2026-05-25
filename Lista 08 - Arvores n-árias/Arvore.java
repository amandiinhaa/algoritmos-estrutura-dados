package L08;

public class Arvore<T> {
	
    private NoArvore<T> raiz;

    // Construtor: inicia árvore vazia
    public Arvore() {
        this.raiz = null;
    }

    // Retorna a raiz
    public NoArvore<T> getRaiz() {
        return raiz;
    }

    // Define a raiz
    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    // Representação textual da árvore
    public String toString() {
        return obterRepresentacaoTextual(raiz);
    }

    // Método recursivo para montar a string
    private String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null) return "";

        String s = "<" + no.getInfo();

        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            s += obterRepresentacaoTextual(filho);
            filho = filho.getProximo();
        }
 
        s += ">";

        return s;
    }

    // Verifica se um valor pertence à árvore
    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) return false;

        if (no.getInfo().equals(info)) return true;

        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            if (pertence(filho, info)) {
                return true;
            }
            filho = filho.getProximo();
        }

        return false;
    }

    // Conta quantidade total de nós
    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        if (no == null) return 0;

        int total = 1; // conta o nó atual

        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            total += contarNos(filho);
            filho = filho.getProximo();
        }

        return total;
    }
}
