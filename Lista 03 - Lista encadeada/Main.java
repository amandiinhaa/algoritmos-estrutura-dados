package L03;

public class Main {

	public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);

        System.out.println(lista.toString());

        System.out.println("Comprimento: " + lista.obterComprimento());

        NoLista<Integer> no = lista.buscar(20);

        if (no != null) {
            System.out.println("Encontrado: " + no.getInfo());
        }

        lista.retirar(20);

        System.out.println(lista.toString());
    }
}