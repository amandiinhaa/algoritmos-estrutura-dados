package L09;

import java.time.LocalDate;

public class TesteCaso3 {

    public static void main(String[] args) {

        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        mapa.inserir(
                12000,
                new Aluno(12000, "Jean",
                        LocalDate.of(2000,1,1)));

        mapa.inserir(
                14000,
                new Aluno(14000, "Pedro",
                        LocalDate.of(1999,1,20)));

        mapa.inserir(
                14226,
                new Aluno(14226, "Marta",
                        LocalDate.of(2001,2,18)));

        mapa.inserir(
                17180,
                new Aluno(17180, "Lucas",
                        LocalDate.of(1998,11,25)));

        System.out.println("Busca 12000:");
        System.out.println(mapa.buscar(12000));

        System.out.println("\nBusca 14000:");
        System.out.println(mapa.buscar(14000));

        System.out.println("\nBusca 14226:");
        System.out.println(mapa.buscar(14226));

        System.out.println("\nBusca 17180:");
        System.out.println(mapa.buscar(17180));
    }
}
