package L02;

public class ListaEstaticaObjetos {

	private Object[] info;
    private int tamanho;
    
    public ListaEstaticaObjetos() {
        super();
        this.info = new Object[10];
        this.tamanho = 0;
    }
    
    public void inserir(Object valor) {
        if (this.info.length == this.tamanho) {
            this.redimensionar();
        }
        this.info[this.tamanho] = valor;
        this.tamanho ++;
    }
    
    private void redimensionar() {
        Object novovetor[];
        novovetor = new Object[this.info.length + 10];
        for(int i = 0; i < this.tamanho; i++) {
            novovetor[i] = this.info[i];
        }
        this.info = novovetor;
    }
    
    // Agora usamos equals() para comparar objetos, pois não estamos mais comparando tipos primitivos.
    public int buscar(Object valor) {
        for(int i = 0; i < this.tamanho; i++) {
            if(this.info[i].equals(valor)) {
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
    
    public void retirar(Object valor) {
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
        String s = "";
        for(int i = 0; i < this.tamanho-1; i ++) {
            s = s + this.info[i] + ",";
        }
        if(tamanho > 0) {
            s  = s + this.info[tamanho-1];
        }
        return s;
    }
    
    public void liberar() {
        this.info = new Object[10];
        this.tamanho = 0;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
    
    // Retorna o elemento armazenado em uma posição específica.
    // Lança exceção caso a posição seja inválida.
    public Object obterElemento(int posicao) {
        if(posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return this.info[posicao];
    }
    
    // Inverte a ordem dos elementos da lista sem criar um novo vetor.
    // Apenas troca os elementos das extremidades até o centro da lista.
    public void inverter() {
        int inicio = 0;
        int fim = this.tamanho - 1;
        
        while(inicio < fim) {
            Object aux = this.info[inicio];
            this.info[inicio] = this.info[fim];
            this.info[fim] = aux;
            
            inicio++;
            fim--;
        }
    }
}