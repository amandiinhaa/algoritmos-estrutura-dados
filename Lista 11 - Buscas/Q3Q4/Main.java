package L11.Q3Q4;

public class Main {

    public static void main(String[] args) {

        ArvoreBinariaBusca<Integer> arv =
                new ArvoreBinariaBusca<>();

        arv.inserir(50);
        arv.inserir(30);
        arv.inserir(70);
        arv.inserir(40);
        arv.inserir(25);
        arv.inserir(75);
        arv.inserir(65);
        arv.inserir(35);
        arv.inserir(60);

        System.out.println(arv);

        System.out.println(
                "Buscar 65: "
                        + arv.buscar(65).getInfo());

        System.out.println(
                "Pertence 90? "
                        + arv.pertence(90));

        System.out.println(
                "Nós: "
                        + arv.contarNos());
    }
}
