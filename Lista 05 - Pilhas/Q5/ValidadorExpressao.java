package L05.Q5;

import L05.Q1Q2.PilhaVetor;

public class ValidadorExpressao {

	public static boolean validar(String expressao) {

        PilhaVetor<Character> pilha = new PilhaVetor<>(expressao.length());

        for (int i = 0; i < expressao.length(); i++) {

            char c = expressao.charAt(i);

            // Se for delimitador de abertura → empilha
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }

            // Se for delimitador de fechamento
            else if (c == ')' || c == ']' || c == '}') {

                // Se não tem abertura correspondente
                if (pilha.estaVazia()) {
                    return false;
                }

                char topo = pilha.pop();

                // Verifica se combina
                if (!combina(topo, c)) {
                    return false;
                }
            }
        }

        // No final, pilha deve estar vazia
        return pilha.estaVazia();
    }

    // Método auxiliar para verificar pares
    private static boolean combina(char abre, char fecha) {

        if (abre == '(' && fecha == ')') return true;
        if (abre == '[' && fecha == ']') return true;
        if (abre == '{' && fecha == '}') return true;

        return false;
    }
}