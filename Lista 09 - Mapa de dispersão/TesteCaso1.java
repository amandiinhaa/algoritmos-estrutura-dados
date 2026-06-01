package L09;

import java.time.LocalDate;

public class TesteCaso1 {

    public static void main(String[] args) {

        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(
                12000,
                "Jean",
                LocalDate.of(2000, 1, 1));

        mapa.inserir(12000, obj1);

        Aluno encontrado = mapa.buscar(12000);

        System.out.println(encontrado);
    }
}
