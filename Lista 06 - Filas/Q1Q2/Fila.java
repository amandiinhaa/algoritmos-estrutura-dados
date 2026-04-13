package L06.Q1Q2;

public interface Fila<T> {

	void inserir (T valor);
	
	boolean estaVazia();
	
	T peek();
	
	T retirar();
	
	void liberar();
}
