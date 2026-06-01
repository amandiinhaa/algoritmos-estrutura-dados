package L09;

import java.time.LocalDate;

public class TesteCaso2 {

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
                12500,
                new Aluno(12500, "Marta",
                        LocalDate.of(2001,2,18)));

        mapa.inserir(
                13000,
                new Aluno(13000, "Lucas",
                        LocalDate.of(1998,11,25)));

        System.out.println(mapa.buscar(12000));
        System.out.println(mapa.buscar(14000));
        System.out.println(mapa.buscar(12500));
        System.out.println(mapa.buscar(13000));
    }
}
