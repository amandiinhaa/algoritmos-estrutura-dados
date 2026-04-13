package L05.Q1Q2;

public class PilhaVetor<T> implements Pilha<T> {

	private Object[] info; // vetor que armazena os elementos
    private int limite;    // capacidade máxima da pilha
    private int tamanho;   // quantidade de elementos atuais

    // a) Construtor
    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0; // começa vazia
    }

    // b) push -> empilha
    @Override
    public void push(T valor) {

        // verifica se a pilha está cheia
        if (tamanho == limite) {
            throw new PilhaCheiaException("Pilha cheia!");
        }

        // adiciona no topo
        info[tamanho] = valor;

        // incrementa o tamanho (topo sobe)
        tamanho++;
    }

    // d) pop -> remove do topo
    @Override
    public T pop() {

        // verifica se está vazia
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }

        // diminui primeiro (topo desce)
        tamanho--;

        // retorna o elemento do topo
        return (T) info[tamanho];
    }

    // c) peek -> apenas consulta o topo
    @Override
    public T peek() {

        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia!");
        }

        return (T) info[tamanho - 1];
    }

    // e) verifica se está vazia
    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // f) liberar -> limpa a pilha
    @Override
    public void liberar() {
        tamanho = 0;
    }

    // g) toString -> do topo até a base
    @Override
    public String toString() {

        String resultado = "";

        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];

            if (i != 0) {
                resultado += ", ";
            }
        }

        return resultado;
    }

    // h) concatenar
    public void concatenar(PilhaVetor<T> p) {

        // verifica capacidade
        if (this.tamanho + p.tamanho > this.limite) {
            throw new RuntimeException("Sem espaço para concatenar!");
        }

        // pilha auxiliar para manter ordem correta
        PilhaVetor<T> aux = new PilhaVetor<>(p.limite);

        // esvazia p para aux (invertendo)
        while (!p.estaVazia()) {
            aux.push(p.pop());
        }

        // devolve para p e adiciona na atual
        while (!aux.estaVazia()) {
            T valor = aux.pop();
            p.push(valor);      // restaura p
            this.push(valor);   // adiciona na atual
        }
    }
}