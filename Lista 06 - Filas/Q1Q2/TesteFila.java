package L06.Q1Q2;

public class TesteFila {

	public static void main(String[] args) {

        // Caso 1
        FilaVetor<Integer> f1 = new FilaVetor<>(5);
        System.out.println(f1.estaVazia()); // true

        // Caso 2
        f1.inserir(10);
        System.out.println(f1.estaVazia()); // false

        // Caso 3
        f1.inserir(20);
        f1.inserir(30);

        System.out.println(f1.retirar()); // 10
        System.out.println(f1.retirar()); // 20
        System.out.println(f1.retirar()); // 30

        // Caso 4 (fila cheia)
        FilaVetor<Integer> f2 = new FilaVetor<>(3);
        f2.inserir(10);
        f2.inserir(20);
        f2.inserir(30);
        // f2.inserir(40); // deve dar erro

        // Caso 5 (fila vazia)
        FilaVetor<Integer> f3 = new FilaVetor<>(3);
        // f3.retirar(); // erro

        // Caso 6 (peek)
        FilaVetor<Integer> f4 = new FilaVetor<>(5);
        f4.inserir(10);
        f4.inserir(20);
        f4.inserir(30);
        System.out.println(f4.peek()); // 10

        // Caso 7 (liberar)
        f4.liberar();
        System.out.println(f4.estaVazia()); // true

        // Caso 8 (concatenação)
        FilaVetor<Integer> a = new FilaVetor<>(5);
        a.inserir(10);
        a.inserir(20);
        a.inserir(30);

        FilaVetor<Integer> b = new FilaVetor<>(3);
        b.inserir(40);
        b.inserir(50);

        FilaVetor<Integer> c = a.criarFilaConcatenada(b);

        System.out.println(c.toString()); // 10,20,30,40,50
        System.out.println(c.getLimite()); // 5
    }
}
