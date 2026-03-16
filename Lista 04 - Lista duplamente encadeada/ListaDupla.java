package L04;

public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    // a) construtor da classe
    // quando a lista é criada ela começa vazia
    public ListaDupla() {
        primeiro = null;
    }

    // b) método que retorna o primeiro nó da lista
    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    // c) método para inserir um novo valor na lista
    public void inserir(T valor) {

        // cria um novo nó
        NoListaDupla<T> novo = new NoListaDupla<>();

        // armazena o valor dentro do nó
        novo.setInfo(valor);

        // se a lista não estiver vazia
        if (primeiro != null) {

            // o novo nó aponta para o antigo primeiro
            novo.setProximo(primeiro);

            // o antigo primeiro passa a apontar para o novo como anterior
            primeiro.setAnterior(novo);
        }

        // o novo nó passa a ser o primeiro da lista
        primeiro = novo;
    }

    // d) método para buscar um valor dentro da lista
    public NoListaDupla<T> buscar(T valor) {

        // começa a busca pelo primeiro nó
        NoListaDupla<T> atual = primeiro;

        // percorre a lista até encontrar o valor ou chegar ao final
        while (atual != null) {

            // compara o valor armazenado com o valor procurado
            if (atual.getInfo().equals(valor)) {

                // se encontrou retorna o nó
                return atual;
            }

            // passa para o próximo nó
            atual = atual.getProximo();
        }

        // se não encontrou retorna null
        return null;
    }

    // e) método para retirar um valor da lista
    public void retirar(T valor) {

        // primeiro procura o nó que contém o valor
        NoListaDupla<T> atual = buscar(valor);

        // se não encontrou não faz nada
        if (atual == null) {
            return;
        }

        // caso o nó seja o primeiro da lista
        if (atual == primeiro) {

            // o primeiro passa a ser o próximo nó
            primeiro = atual.getProximo();

            // se a lista não ficou vazia
            if (primeiro != null) {

                // remove a referência anterior do novo primeiro
                primeiro.setAnterior(null);
            }

        } else {

            // pega o nó anterior e o próximo
            NoListaDupla<T> ant = atual.getAnterior();
            NoListaDupla<T> prox = atual.getProximo();

            // ajusta o ponteiro do nó anterior
            if (ant != null) {
                ant.setProximo(prox);
            }

            // ajusta o ponteiro do nó seguinte
            if (prox != null) {
                prox.setAnterior(ant);
            }
        }
    }

    // f) método para exibir os elementos da lista do início ao fim
    public void exibirOrdem() {

        // começa pelo primeiro nó
        NoListaDupla<T> atual = primeiro;

        // percorre toda a lista
        while (atual != null) {

            // imprime o valor armazenado
            System.out.print(atual.getInfo() + " ");

            // passa para o próximo nó
            atual = atual.getProximo();
        }

        // quebra de linha após exibir todos
        System.out.println();
    }

    // g) método para liberar todos os nós da lista
    public void liberar() {

        // começa pelo primeiro nó
        NoListaDupla<T> atual = primeiro;

        // percorre a lista
        while (atual != null) {

            // guarda o próximo nó antes de limpar
            NoListaDupla<T> prox = atual.getProximo();

            // remove as referências de ligação
            atual.setAnterior(null);
            atual.setProximo(null);

            // passa para o próximo nó
            atual = prox;
        }

        // define que a lista está vazia
        primeiro = null;
    }

    // h) retorna os valores da lista em formato de texto
    public String toString() {

        // variável que armazenará o resultado
        String resultado = "";

        // começa pelo primeiro nó
        NoListaDupla<T> atual = primeiro;

        // percorre a lista
        while (atual != null) {

            // adiciona o valor na string
            resultado += atual.getInfo();

            // adiciona vírgula se não for o último elemento
            if (atual.getProximo() != null) {
                resultado += ",";
            }

            // passa para o próximo nó
            atual = atual.getProximo();
        }

        // retorna o resultado final
        return resultado;
    }
}