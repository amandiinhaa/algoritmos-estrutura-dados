package L10;

public class Main {

    public static void main(String[] args) {

        Veiculo[] vetor = {
                new Veiculo(70),
                new Veiculo(2),
                new Veiculo(88),
                new Veiculo(15),
                new Veiculo(90),
                new Veiculo(30)
        };

        // TESTE BOLHA
        OrdenacaoBolha<Veiculo> bolha =
                new OrdenacaoBolha<>(vetor);

        bolha.ordenar();

        System.out.println("Bubble Sort:");

        for (Veiculo v : bolha.getInfo()) {
            System.out.print(v + " ");
        }

        System.out.println();

        // TESTE QUICKSORT
        Veiculo[] vetor2 = {
                new Veiculo(70),
                new Veiculo(2),
                new Veiculo(88),
                new Veiculo(15),
                new Veiculo(90),
                new Veiculo(30)
        };

        OrdenacaoQuickSort<Veiculo> quick =
                new OrdenacaoQuickSort<>(vetor2);

        quick.ordenar();

        System.out.println("QuickSort:");

        for (Veiculo v : quick.getInfo()) {
            System.out.print(v + " ");
        }
    }
}
