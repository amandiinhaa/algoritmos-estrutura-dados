package TrabalhoFinal;

public class Pilha<T> {
	protected Object[] info;
    private int topo;
    private int tamanho;

    public Pilha(int limite) {
        info = new Object[limite];
        topo = 0;
        tamanho = 0;
    }
    
    public int getTamanho() {
    	return this.tamanho;
    }
    public void push(T valor) {
        info[topo++] = valor;
        tamanho++;
    }

    public T pop() {
    	tamanho--;
        return (T) info[--topo];
    }

    public boolean estaVazia() {
        return topo == 0;
    }
}
