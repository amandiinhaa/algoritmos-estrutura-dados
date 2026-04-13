package L05.Q5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma expressão:");
        String exp = sc.nextLine();

        boolean resultado = ValidadorExpressao.validar(exp);

        if (resultado) {
            System.out.println("Delimitadores CORRETOS ✅");
        } else {
            System.out.println("Delimitadores INCORRETOS ❌");
        }

        sc.close();
    }
}
