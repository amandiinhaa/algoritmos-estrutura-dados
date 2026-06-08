package L11.Q1Q2;

public class Main {

    public static void main(String[] args) {

        Integer[] dados = {
                0,10,20,30,40,50,60,70,80,90,100
        };

        BuscaLinear<Integer> linear =
                new BuscaLinear<>();

        linear.setInfo(dados);

        System.out.println(
                "Linear(20): "
                        + linear.buscar(20));

        BuscaLinearVetorOrdenado<Integer> ordenado =
                new BuscaLinearVetorOrdenado<>();

        ordenado.setInfo(dados);

        System.out.println(
                "Linear Ordenado(40): "
                        + ordenado.buscar(40));

        BuscaBinaria<Integer> binaria =
                new BuscaBinaria<>();

        binaria.setInfo(dados);

        System.out.println(
                "Binária(70): "
                        + binaria.buscar(70));

        System.out.println(
                "Binária(75): "
                        + binaria.buscar(75));
    }
}
