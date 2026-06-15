package TrabalhoFinal;

public class Fila<T> {
	private Object[] info;
	private int limite, tamanho, inicio;
	
	public Fila(int limite) {
		info = new Object[limite];
		this.limite = limite;
		this.tamanho = 0;
		this.inicio = 0;
	}
	
	public Object[] getInfo() {
		return info;
	}

	public void setInfo(Object[] info) {
		this.info = info;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}

	public void inserir(T valor) {
	    if (tamanho == limite) {
	        throw new FilaCheiaException("Fila cheia");
	    }

	    int iInserir = (inicio + tamanho) % limite;
	    info[iInserir] = valor;
	    tamanho++;
	}
	
	public boolean estaVazia() {
		if (tamanho == 0) {
			return true;
		}
		return false;
	}
	
	public T peek() {
		if (estaVazia()) {
			throw new FilaVaziaException("Fila vazia");
		}
		return (T)info[inicio];
	}
	
	public T retirar() {
	    if (estaVazia()) {
	        throw new FilaVaziaException("Fila vazia");
	    }

	    T valor = (T) info[inicio];
	    info[inicio] = null;
	    inicio = (inicio + 1) % limite;
	    tamanho--;

	    return valor;
	}
	
	public void liberar() {
		while (!estaVazia()) {
			retirar();
		}
	}
	
	public int getLimite() {
		return limite;
	}
	
	@Override
	public String toString() {
		String texto = "";
	    for (Object valor : getInfo()) {
	    	texto += "["+valor+"]";
	    }
	    return texto;
	}
}
