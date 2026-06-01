package L09;

import java.util.LinkedList;

public class MapaDispersao<T> {

    /*
     * Vetor de listas encadeadas.
     * Cada posição da tabela é chamada de bucket.
     */
    private LinkedList<NoMapa<T>>[] info;

    /*
     * Construtor
     */
    public MapaDispersao(int tamanho) {

        info = new LinkedList[tamanho];

        /*
         * Inicializa cada posição do vetor com uma lista vazia.
         */
        for (int i = 0; i < tamanho; i++) {
            info[i] = new LinkedList<>();
        }
    }

    /*
     * Função hash
     * Utiliza resto da divisão.
     */
    private int calcularHash(int chave) {
        return chave % info.length;
    }

    /*
     * Insere um novo elemento.
     */
    public void inserir(int chave, T dado) {

        int posicao = calcularHash(chave);

        NoMapa<T> novo = new NoMapa<>(chave, dado);

        /*
         * Verifica se já existe a chave.
         * Se existir, atualiza o valor.
         */
        for (NoMapa<T> no : info[posicao]) {

            if (no.getChave() == chave) {
                no.setValor(dado);
                return;
            }
        }

        /*
         * Caso não exista, adiciona na lista.
         */
        info[posicao].add(novo);
    }

    /*
     * Remove elemento pela chave.
     */
    public void remover(int chave) {

        int posicao = calcularHash(chave);

        /*
         * Percorre a lista da posição.
         */
        for (NoMapa<T> no : info[posicao]) {

            if (no.getChave() == chave) {
                info[posicao].remove(no);
                return;
            }
        }
    }

    /*
     * Busca um elemento pela chave.
     */
    public T buscar(int chave) {

        int posicao = calcularHash(chave);

        for (NoMapa<T> no : info[posicao]) {

            if (no.getChave() == chave) {
                return no.getValor();
            }
        }

        return null;
    }

    /*
     * Fator de carga:
     * quantidade de elementos / tamanho da tabela
     */
    public double calcularFatorCarga() {

        int quantidadeElementos = 0;

        for (LinkedList<NoMapa<T>> lista : info) {
            quantidadeElementos += lista.size();
        }

        return (double) quantidadeElementos / info.length;
    }

    /*
     * Método auxiliar para visualizar a tabela.
     */
    public void exibir() {

        for (int i = 0; i < info.length; i++) {

            System.out.print(i + " -> ");

            for (NoMapa<T> no : info[i]) {
                System.out.print(no + " ");
            }

            System.out.println();
        }
    }
}
