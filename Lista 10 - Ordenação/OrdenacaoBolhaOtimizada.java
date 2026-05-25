package L10;

public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

	public OrdenacaoBolhaOtimizada(T[] info) {
		super(info);
	}

	@Override
	public void ordenar() {

// Obtém o vetor
		T[] info = getInfo();

// Variável usada para verificar se houve troca
		boolean trocou;

// Percorre o vetor
		for (int i = 0; i < info.length - 1; i++) {

			// Assume inicialmente que não houve troca
			trocou = false;

			// Compara elementos vizinhos
			for (int j = 0; j < info.length - 1 - i; j++) {

				// Se estiver fora de ordem
				if (info[j].compareTo(info[j + 1]) > 0) {

					// Troca os elementos
					trocar(j, j + 1);

					// Marca que houve troca
					trocou = true;
				}
			}

			// Se nenhuma troca aconteceu,
			// o vetor já está ordenado
			if (!trocou) {
				break;
			}
		}
	}
}
