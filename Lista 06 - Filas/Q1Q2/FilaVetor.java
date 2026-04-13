package L06.Q1Q2;

public class FilaVetor<T> implements Fila<T> {

	private Object[] info; // vetor que guarda os dados
    private int limite;    // capacidade máxima
    private int tamanho;   // quantidade atual de elementos
    private int inicio;    // posição do primeiro elemento

    // Construtor
    public FilaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }

    // Inserir
    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException("Fila está cheia!");
        }

        int pos = (inicio + tamanho) % limite;
        info[pos] = valor;
        tamanho++;
    }

    // Verificar se está vazia
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Espiar o primeiro elemento
    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila está vazia!");
        }

        return (T) info[inicio];
    }

    // Remover
    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException("Fila está vazia!");
        }

        T valor = (T) info[inicio];
        inicio = (inicio + 1) % limite;
        tamanho--;

        return valor;
    }

    // Limpar fila
    @Override
    public void liberar() {
        tamanho = 0;
        inicio = 0;
        info = new Object[limite];
    }

    // Concatenar filas
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> nova = new FilaVetor<>(this.tamanho + f2.tamanho);

        // copiar f1 (this)
        for (int i = 0; i < this.tamanho; i++) {
            int pos = (this.inicio + i) % this.limite;
            nova.inserir((T) this.info[pos]);
        }

        // copiar f2
        for (int i = 0; i < f2.tamanho; i++) {
            int pos = (f2.inicio + i) % f2.limite;
            nova.inserir((T) f2.info[pos]);
        }

        return nova;
    }

    @Override
    public String toString() {
        if (estaVazia()) return "";

        String resultado = "";

        for (int i = 0; i < tamanho; i++) {
            int pos = (inicio + i) % limite;
            resultado += info[pos];

            if (i < tamanho - 1) {
                resultado += ",";
            }
        }

        return resultado;
    }

    public int getLimite() {
        return limite;
    }
}