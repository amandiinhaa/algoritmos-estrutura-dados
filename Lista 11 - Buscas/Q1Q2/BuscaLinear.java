package L11.Q1Q2;

public class BuscaLinear<T> extends BuscaAbstract<T> {

    public int buscar(T valor) {

        Object[] vetor = getInfo();

        for (int i = 0; i < vetor.length; i++) {

            /*
             * Encontrou o valor?
             */
            if (vetor[i].equals(valor)) {
                return i;
            }
        }

        return -1;
    }
}
