package L09;

public class NoMapa<T> {

    private int chave;
    private T valor;

    public NoMapa(int chave, T valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    /*
     * Dois nós são considerados iguais se possuem a mesma chave.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof NoMapa))
            return false;

        NoMapa<?> outro = (NoMapa<?>) obj;

        return this.chave == outro.chave;
    }

    @Override
    public String toString() {
        return "[" + chave + " = " + valor + "]";
    }
}
