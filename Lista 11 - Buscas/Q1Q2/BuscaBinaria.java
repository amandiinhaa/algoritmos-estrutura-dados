package L11.Q1Q2;

public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract<T> {

	public int buscar(T valor) {

		Object[] vetor = getInfo();

		int inicio = 0;
		int fim = vetor.length - 1;

		while (inicio <= fim) {

			int meio = (inicio + fim) / 2;

			T atual = (T) vetor[meio];

			if (atual.compareTo(valor) == 0)
				return meio;

			if (atual.compareTo(valor) < 0)
				inicio = meio + 1;
			else
				fim = meio - 1;
		}

		return -1;
	}
}
