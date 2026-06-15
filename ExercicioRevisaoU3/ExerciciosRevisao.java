package ExercicioRevisaoU3;

import java.util.Iterator;
import java.util.LinkedList;

public class ExerciciosRevisao<T extends Comparable<T>> {

    private T[] info;

    // ==========================
    // Exercício 8.1
    // ==========================
    public void ordenar() {

        for (int i = 0; i < info.length - 1; i++) {

            boolean houveTroca = false;

            for (int j = 0; j < info.length - 1 - i; j++) {

                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                    houveTroca = true;
                }
            }

            if (!houveTroca) {
                break;
            }
        }
    }

    private void trocar(int a, int b) {
        T aux = info[a];
        info[a] = info[b];
        info[b] = aux;
    }

    /*
     * Exercício 8.1
     * Foi adicionada a variável houveTroca.
     * Caso uma passagem completa ocorra sem trocas,
     * o algoritmo é encerrado.
     * Melhor caso: O(n)
     */

    // ==========================
    // Exercício 8.2
    // ==========================
    public int buscarPrimeiraOcorrencia(T valor) {

        int inicio = 0;
        int fim = info.length - 1;
        int resultado = -1;

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;
            int comparacao = valor.compareTo(info[meio]);

            if (comparacao == 0) {
                resultado = meio;
                fim = meio - 1;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return resultado;
    }

    /*
     * Exercício 8.2
     * Quando encontra o valor, continua buscando
     * na metade esquerda para encontrar a primeira ocorrência.
     */

    // ==========================
    // Exercício 8.3
    // ==========================
    class Elemento {
        int chave;

        public Elemento(int chave) {
            this.chave = chave;
        }

        public int getChave() {
            return chave;
        }
    }

    LinkedList<Elemento>[] tabela;

    private int hash(int chave) {
        return chave % tabela.length;
    }

    public boolean remover(int chave) {

        int indice = hash(chave);

        if (tabela[indice] == null) {
            return false;
        }

        Iterator<Elemento> it = tabela[indice].iterator();

        while (it.hasNext()) {

            Elemento elemento = it.next();

            if (elemento.getChave() == chave) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    /*
     * Exercício 8.3
     * Calcula o índice hash, procura o elemento
     * na lista encadeada e remove quando encontrado.
     */

    // ==========================
    // Exercício 8.4
    // ==========================
    class NoArvore {

        T info;
        NoArvore esquerda;
        NoArvore direita;

        public NoArvore(T info) {
            this.info = info;
        }
    }

    public void imprimirEmOrdem(NoArvore no) {

        if (no != null) {

            imprimirEmOrdem(no.esquerda);

            System.out.println(no.info);

            imprimirEmOrdem(no.direita);
        }
    }

    /*
     * Exercício 8.4
     * A ordem esquerda -> nó -> direita
     * imprime os valores em ordem crescente.
     */

    // ==========================
    // Exercício 8.5
    // ==========================
    public boolean estaOrdenado(T[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            if (vetor[i].compareTo(vetor[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    /*
     * Exercício 8.5
     * Verifica se o vetor já está ordenado,
     * evitando processamento desnecessário.
     */

    // ==========================
    // Exercício 8.6
    // ==========================
    public NoArvore criarArvoreBalanceada(
            T[] vetor,
            int inicio,
            int fim) {

        if (inicio > fim) {
            return null;
        }

        int meio = (inicio + fim) / 2;

        NoArvore no = new NoArvore(vetor[meio]);

        no.esquerda =
                criarArvoreBalanceada(vetor, inicio, meio - 1);

        no.direita =
                criarArvoreBalanceada(vetor, meio + 1, fim);

        return no;
    }

    /*
     * Exercício 8.6
     * Escolhe o elemento central como raiz,
     * criando uma árvore binária de busca balanceada.
     */
}
