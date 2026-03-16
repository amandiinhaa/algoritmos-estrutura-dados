package L03;

// Classe que representa a lista encadeada
public class ListaEncadeada<T> {

	// referência para o primeiro nó da lista
    private NoLista<T> primeiro;

    // a) Construtor da classe
    // quando a lista é criada ela começa vazia
    public ListaEncadeada() {
        primeiro = null;
    }

    // b) Método getter para retornar o primeiro nó da lista
    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    // c) Método para inserir um novo nó no início da lista
    public void inserir(T valor) {

        // cria um novo nó
        NoLista<T> novo = new NoLista<>();

        // armazena o valor recebido dentro do nó
        novo.setInfo(valor);

        // se a lista não estiver vazia
        if (primeiro != null) {

            // o próximo do novo nó passa a ser o antigo primeiro nó
            novo.setProximo(primeiro);
        }

        // o novo nó passa a ser o primeiro da lista
        primeiro = novo;
    }

    // d) verifica se a lista está vazia
    public boolean estaVazia() {

        // se o primeiro for null significa que não há nós na lista
        return primeiro == null;
    }

    // e) busca um valor dentro da lista
    public NoLista<T> buscar(T valor) {

        // começa a busca a partir do primeiro nó
        NoLista<T> atual = primeiro;

        // percorre a lista enquanto houver nós
        while (atual != null) {

            // verifica se o valor do nó atual é igual ao valor procurado
            if (atual.getInfo().equals(valor)) {

                // se encontrou, retorna o nó
                return atual;
            }

            // passa para o próximo nó da lista
            atual = atual.getProximo();
        }

        // se não encontrou o valor retorna null
        return null;
    }

    // f) remove o primeiro nó que contém o valor informado
    public void retirar(T valor) {

        // começa no primeiro nó
        NoLista<T> atual = primeiro;

        // guarda o nó anterior para ajustar os ponteiros
        NoLista<T> anterior = null;

        // percorre a lista
        while (atual != null) {

            // verifica se encontrou o valor
            if (atual.getInfo().equals(valor)) {

                // se o nó a remover é o primeiro da lista
                if (anterior == null) {

                    // o primeiro passa a ser o próximo
                    primeiro = atual.getProximo();
                } else {

                    // o anterior passa a apontar para o próximo do atual
                    anterior.setProximo(atual.getProximo());
                }

                // encerra o método após remover
                return;
            }

            // avança os nós
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    // g) retorna a quantidade de nós da lista
    public int obterComprimento() {

        int contador = 0;

        // começa no primeiro nó
        NoLista<T> atual = primeiro;

        // percorre toda a lista
        while (atual != null) {

            // conta um nó
            contador++;

            // passa para o próximo
            atual = atual.getProximo();
        }

        // retorna o total de nós
        return contador;
    }

    // h) retorna o nó que está em uma determinada posição
    public NoLista<T> obterNo(int idx) {

        // obtém o tamanho da lista
        int tamanho = obterComprimento();

        // verifica se o índice é inválido
        if (idx < 0 || idx >= tamanho) {

            // lança exceção caso esteja fora do limite
            throw new IndexOutOfBoundsException();
        }

        // começa no primeiro nó
        NoLista<T> atual = primeiro;

        // percorre até chegar na posição desejada
        for (int i = 0; i < idx; i++) {

            atual = atual.getProximo();
        }

        // retorna o nó encontrado
        return atual;
    }

    // i) retorna os valores da lista separados por vírgula
    public String toString() {

        // variável para montar o resultado
        String resultado = "";

        // começa no primeiro nó
        NoLista<T> atual = primeiro;

        // percorre a lista
        while (atual != null) {

            // adiciona o valor no texto
            resultado += atual.getInfo();

            // adiciona vírgula se não for o último nó
            if (atual.getProximo() != null) {
                resultado += ",";
            }

            // passa para o próximo nó
            atual = atual.getProximo();
        }

        // retorna a string final
        return resultado;
    }
}