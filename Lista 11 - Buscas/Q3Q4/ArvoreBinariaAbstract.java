package L11.Q3Q4;

public abstract class ArvoreBinariaAbstract<T> {

    private NoArvoreBinaria<T> raiz;

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    /*
     * Método abstrato:
     * cada árvore implementa
     * sua própria busca.
     */
    public abstract NoArvoreBinaria<T> buscar(T info);

    /*
     * Reaproveita buscar()
     */
    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {

        if (no == null)
            return 0;

        return 1
                + contarNos(no.getEsquerda())
                + contarNos(no.getDireita());
    }

    @Override
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {

        if (no == null)
            return "<>";

        return "<"
                + no.getInfo()
                + arvorePre(no.getEsquerda())
                + arvorePre(no.getDireita())
                + ">";
    }
}
