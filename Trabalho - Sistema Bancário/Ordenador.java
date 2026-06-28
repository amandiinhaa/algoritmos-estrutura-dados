package TrabalhoFinal;

public class Ordenador {

	// Método principal para ordenar por Tempo de Espera
    public static void ordenarPorTempoEspera(RegistroAtendimento[] vetor, int esq, int dir) {
        if (esq < dir) {
            int pivo = particionarPorTempoEspera(vetor, esq, dir);
            ordenarPorTempoEspera(vetor, esq, pivo - 1);
            ordenarPorTempoEspera(vetor, pivo + 1, dir);
        }
    }

    private static int particionarPorTempoEspera(RegistroAtendimento[] vetor, int esq, int dir) {
        double pivo = vetor[dir].getTempoEspera();
        int i = esq - 1;
        for (int j = esq; j < dir; j++) {
            if (vetor[j].getTempoEspera() <= pivo) {
                i++;
                RegistroAtendimento temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        RegistroAtendimento temp = vetor[i + 1];
        vetor[i + 1] = vetor[dir];
        vetor[dir] = temp;
        return i + 1;
    }

    // Método principal para ordenar por Horário de Atendimento (Ordem Cronológica)
    public static void ordenarPorHoraAtendimento(RegistroAtendimento[] vetor, int esq, int dir) {
        if (esq < dir) {
            int pivo = particionarPorHoraAtendimento(vetor, esq, dir);
            ordenarPorHoraAtendimento(vetor, esq, pivo - 1);
            ordenarPorHoraAtendimento(vetor, pivo + 1, dir);
        }
    }

    private static int particionarPorHoraAtendimento(RegistroAtendimento[] vetor, int esq, int dir) {
        double pivo = vetor[dir].getHoraAtendimento();
        int i = esq - 1;
        for (int j = esq; j < dir; j++) {
            if (vetor[j].getHoraAtendimento() <= pivo) {
                i++;
                RegistroAtendimento temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        RegistroAtendimento temp = vetor[i + 1];
        vetor[i + 1] = vetor[dir];
        vetor[dir] = temp;
        return i + 1;
    }
}
