package L10;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

	public OrdenacaoMergeSort(T[] info) {
		super(info);
	}

	@Override
	public void ordenar() {

// Inicia o MergeSort
		mergeSort(0, getInfo().length - 1);
	}

	private void mergeSort(int inicio, int fim) {

// Continua dividindo enquanto existir mais de 1 elemento
		if (inicio < fim) {

			// Calcula o meio do vetor
			int meio = (inicio + fim) / 2;

			// Divide lado esquerdo
			mergeSort(inicio, meio);

			// Divide lado direito
			mergeSort(meio + 1, fim);

			// Junta os lados ordenando
			merge(inicio, meio, fim);
		}
	}

	private void merge(int inicio, int meio, int fim) {

		T[] info = getInfo();

// Vetor auxiliar para armazenar ordenação temporária
		Object[] aux = new Object[info.length];

// Índice do lado esquerdo
		int i = inicio;

// Índice do lado direito
		int j = meio + 1;

// Índice do vetor auxiliar
		int k = inicio;

// Compara os elementos dos dois lados
		while (i <= meio && j <= fim) {

			// Se elemento esquerdo for menor
			if (info[i].compareTo(info[j]) <= 0) {

				// Copia para o auxiliar
				aux[k++] = info[i++];

			} else {

				// Copia elemento direito
				aux[k++] = info[j++];
			}
		}

// Copia elementos restantes da esquerda
		while (i <= meio) {
			aux[k++] = info[i++];
		}

// Copia elementos restantes da direita
		while (j <= fim) {
			aux[k++] = info[j++];
		}

// Copia os dados ordenados
// do vetor auxiliar para o vetor original
		for (int x = inicio; x <= fim; x++) {
			info[x] = (T) aux[x];
		}
	}
}
