package L08;

public class TesteArvore {
    public static void main(String[] args) {

        // =========================
        // CASO 1 - Criar a árvore
        // =========================

        Arvore<Integer> arvore = new Arvore<>();

        NoArvore<Integer> n1 = new NoArvore<>(1);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n10 = new NoArvore<>(10);

        // Montagem da árvore

        // Filhos do 2 → 5,6,7
        n2.inserirFilho(n7);
        n2.inserirFilho(n6);
        n2.inserirFilho(n5);

        // Filho do 3 → 8
        n3.inserirFilho(n8);

        // Filhos do 4 → 9,10
        n4.inserirFilho(n10);
        n4.inserirFilho(n9);

        // Filhos do 1 → 2,3,4
        n1.inserirFilho(n4);
        n1.inserirFilho(n3);
        n1.inserirFilho(n2);

        arvore.setRaiz(n1);

        // Teste 1
        System.out.println("Caso 1 - toString:");
        System.out.println(arvore.toString());
        // Esperado:
        // <1<2<5><6><7>><3<8>><4<9><10>>>

        // =========================
        // CASO 2 - pertence(7)
        // =========================
        System.out.println("\nCaso 2 - pertence(7):");
        System.out.println(arvore.pertence(7)); // true

        // =========================
        // CASO 3 - pertence(55)
        // =========================
        System.out.println("\nCaso 3 - pertence(55):");
        System.out.println(arvore.pertence(55)); // false

        // =========================
        // CASO 4 - contarNos()
        // =========================
        System.out.println("\nCaso 4 - contarNos:");
        System.out.println(arvore.contarNos()); // 10
    }
}
