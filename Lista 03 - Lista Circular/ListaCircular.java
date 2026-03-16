package L03_ListaCircular;

public class ListaCircular<T> {

	// referência para o primeiro nó da lista
    private NoLista<T> primeiro;

    // construtor da lista
    public ListaCircular() {
        primeiro = null;
    }

    // método para inserir um novo nó na lista circular
    public void inserir(T valor) {

        // cria um novo nó
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(valor);

        // caso a lista esteja vazia
        if (primeiro == null) {

            // o novo nó passa a ser o primeiro
            primeiro = novo;

            // como é circular, ele aponta para si mesmo
            novo.setProximo(novo);
        } else {

            // percorre até encontrar o último nó
            NoLista<T> atual = primeiro;

            while (atual.getProximo() != primeiro) {
                atual = atual.getProximo();
            }

            // o último passa a apontar para o novo nó
            atual.setProximo(novo);

            // o novo nó aponta para o primeiro
            novo.setProximo(primeiro);
        }
    }

    // método para exibir os elementos da lista
    public void exibir() {

        // verifica se a lista está vazia
        if (primeiro == null) {
            System.out.println("Lista vazia");
            return;
        }

        // começa pelo primeiro nó
        NoLista<T> atual = primeiro;

        do {

            // mostra o valor do nó
            System.out.print(atual.getInfo() + " ");

            // passa para o próximo nó
            atual = atual.getProximo();

        } while (atual != primeiro); // para quando voltar ao início

        System.out.println();
    }
}