package L05.Q3Q4;

public class TestePilhaLista {

	public static void main(String[] args) {

        System.out.println("===== TESTE 1 =====");
        PilhaLista<Integer> p1 = new PilhaLista<>();
        System.out.println(p1.estaVazia()); // true


        System.out.println("\n===== TESTE 2 =====");
        PilhaLista<Integer> p2 = new PilhaLista<>();
        p2.push(10);
        System.out.println(p2.estaVazia()); // false


        System.out.println("\n===== TESTE 3 =====");
        PilhaLista<Integer> p3 = new PilhaLista<>();
        p3.push(10);
        p3.push(20);
        p3.push(30);

        System.out.println(p3.pop()); // 30
        System.out.println(p3.pop()); // 20
        System.out.println(p3.pop()); // 10
        System.out.println(p3.estaVazia()); // true


        System.out.println("\n===== TESTE 4 =====");
        PilhaLista<Integer> p4 = new PilhaLista<>();
        p4.push(10);
        p4.push(20);
        p4.push(30);

        System.out.println(p4.peek()); // 30
        System.out.println(p4.pop());  // 30


        System.out.println("\n===== TESTE 5 =====");
        PilhaLista<Integer> p5 = new PilhaLista<>();
        p5.push(10);
        p5.push(20);
        p5.push(30);

        p5.liberar();
        System.out.println(p5.estaVazia()); // true
    }
}