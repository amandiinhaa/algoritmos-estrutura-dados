package L05.Q1Q2;

public class TestePilhaVetor {

	public static void main(String[] args) {

        System.out.println("===== TESTE 1 =====");
        // Caso 1: pilha vazia
        PilhaVetor<Integer> p1 = new PilhaVetor<>(5);
        System.out.println("estaVazia(): " + p1.estaVazia()); // true


        System.out.println("\n===== TESTE 2 =====");
        // Caso 2: pilha não vazia
        PilhaVetor<Integer> p2 = new PilhaVetor<>(5);
        p2.push(10);
        System.out.println("estaVazia(): " + p2.estaVazia()); // false


        System.out.println("\n===== TESTE 3 =====");
        // Caso 3: empilhar e desempilhar
        PilhaVetor<Integer> p3 = new PilhaVetor<>(10);
        p3.push(10);
        p3.push(20);
        p3.push(30);

        System.out.println("Pop 1: " + p3.pop()); // 30
        System.out.println("Pop 2: " + p3.pop()); // 20
        System.out.println("Pop 3: " + p3.pop()); // 10


        System.out.println("\n===== TESTE 4 =====");
        // Caso 4: pilha cheia (exception)
        try {
            PilhaVetor<Integer> p4 = new PilhaVetor<>(3);
            p4.push(10);
            p4.push(20);
            p4.push(30);
            p4.push(40); // deve dar erro
        } catch (PilhaCheiaException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }


        System.out.println("\n===== TESTE 5 =====");
        // Caso 5: desempilhar pilha vazia
        try {
            PilhaVetor<Integer> p5 = new PilhaVetor<>(5);
            p5.pop(); // erro esperado
        } catch (PilhaVaziaException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }


        System.out.println("\n===== TESTE 6 =====");
        // Caso 6: peek
        PilhaVetor<Integer> p6 = new PilhaVetor<>(5);
        p6.push(10);
        p6.push(20);
        p6.push(30);

        System.out.println("Peek: " + p6.peek()); // 30
        System.out.println("Pop depois do peek: " + p6.pop()); // 30


        System.out.println("\n===== TESTE 7 =====");
        // Caso 7: liberar
        PilhaVetor<Integer> p7 = new PilhaVetor<>(5);
        p7.push(10);
        p7.push(20);
        p7.push(30);

        p7.liberar();
        System.out.println("estaVazia(): " + p7.estaVazia()); // true


        System.out.println("\n===== TESTE 8 =====");
        // Caso 8: concatenar
        PilhaVetor<Integer> p8a = new PilhaVetor<>(10);
        p8a.push(10);
        p8a.push(20);
        p8a.push(30);

        PilhaVetor<Integer> p8b = new PilhaVetor<>(10);
        p8b.push(40);
        p8b.push(50);

        p8a.concatenar(p8b);

        System.out.println("Resultado: " + p8a.toString());
        // esperado: 50, 40, 30, 20, 10
    }
}