package L10;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

	public OrdenacaoQuickSort(T[] info) {
		super(info);
	}

	@Override
	public void ordenar() {

// Inicia o QuickSort passando
// posição inicial e final do vetor
		quickSort(0, getInfo().length - 1);
	}

	private void quickSort(int inicio, int fim) {

// Continua apenas se houver mais de 1 elemento
		if (inicio < fim) {

			// Particiona o vetor e obtém a posição do pivô
			int p = particionar(inicio, fim);

			// Ordena a parte esquerda
			quickSort(inicio, p - 1);

			// Ordena a parte direita
			quickSort(p + 1, fim);
		}
	}

	private int particionar(int inicio, int fim) {

		T[] info = getInfo();

// Escolhe o último elemento como pivô
		T pivo = info[fim];

// Índice para controle dos menores elementos
		int i = inicio - 1;

// Percorre o vetor
		for (int j = inicio; j < fim; j++) {

			// Se o elemento atual for menor que o pivô
			if (info[j].compareTo(pivo) < 0) {

				// Avança o índice
				i++;

				// Coloca o menor elemento na esquerda
				trocar(i, j);
			}
		}

// Coloca o pivô na posição correta
		trocar(i + 1, fim);

// Retorna a posição do pivô
		return i + 1;
	}
}
