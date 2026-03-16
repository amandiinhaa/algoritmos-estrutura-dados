package L01;

public class ListaEstatica {

	private int[] info;
	private int tamanho;
	
	public ListaEstatica() {
		super();
		this.info = new int[10];
		this.tamanho = 0;
	}
	
	public void inserir(int valor) {
		if (this.info.length == this.tamanho) {
			this.redimensionar();
		}
		this.info[this.tamanho] = valor;
		this.tamanho ++;
	}
	
	private void redimensionar() {
		int novovetor[];
		novovetor = new int[this.info.length + 10];
		for(int i = 0; i < this.tamanho; i++) {
			novovetor[i] = this.info[i];
		}
		this.info = novovetor;
	}
	
	public int buscar(int valor) {
		for(int i = 0; i < this.tamanho; i++) {
			if(this.info[i] == valor) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isVazia() {
		if(this.tamanho == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void retirar(int valor) {
		int pos = this.buscar(valor);
		if(pos != -1) {
			for(int i = pos; i < this.tamanho-1; i++) {
				this.info[i] = this.info[i+1];
			}
			this.tamanho--;
		}
	}
	
	public void exibir() {
		for(int i = 0; i < this.tamanho; i++) {
			System.out.println(this.info[i]);
		}
	}
	
	public String toString() {
		String s = " [ ";
		for(int i = 0; i < this.tamanho-1; i ++) {
			s = s + this.info[i] + ", ";
		}
		if(tamanho > 0) {
			s  = s + this.info[tamanho-1] + " ] ";
		}
		return s;
	}
	
	public void liberar() {
		this.info = new int[10];
		this.tamanho = 0;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
}