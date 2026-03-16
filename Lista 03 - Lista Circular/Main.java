package L03_ListaCircular;

public class Main {

	public static void main(String[] args) {

        ListaCircular<Integer> lista = new ListaCircular<>();

        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);

        lista.exibir();
    }
}