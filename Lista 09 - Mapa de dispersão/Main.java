package L09;

public class Main {

    public static void main(String[] args) {

        MapaDispersao<String> mapa = new MapaDispersao<>(5);

        mapa.inserir(10, "Amanda");
        mapa.inserir(15, "Carlos");
        mapa.inserir(20, "Maria");
        mapa.inserir(7, "Pedro");

        System.out.println("Tabela:");
        mapa.exibir();

        System.out.println("\nBusca chave 15:");
        System.out.println(mapa.buscar(15));

        System.out.println("\nRemovendo chave 15");
        mapa.remover(15);

        mapa.exibir();

        System.out.println("\nFator de carga:");
        System.out.println(mapa.calcularFatorCarga());
    }
}
