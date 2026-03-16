package L04;

public class Main {

	public static void main(String[] args) {

        // cria uma lista duplamente encadeada
        ListaDupla<Integer> lista = new ListaDupla<>();

        // insere alguns valores
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        // exibe os elementos da lista
        System.out.println("Lista atual:");
        lista.exibirOrdem();

        // busca um valor
        System.out.println("Buscando o valor 10:");
        System.out.println(lista.buscar(10).getInfo());

        // remove um valor
        lista.retirar(10);

        System.out.println("Lista após remover 10:");
        lista.exibirOrdem();

        // exibe a lista usando toString
        System.out.println("Lista em formato texto:");
        System.out.println(lista.toString());
    }
}