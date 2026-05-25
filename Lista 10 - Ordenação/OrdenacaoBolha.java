package L10;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

	public OrdenacaoBolha(T[] info) {
		super(info);
	}

	@Override
	public void ordenar() {

// Obtém o vetor que será ordenado
		T[] info = getInfo();

// Laço externo controla quantas passagens serão feitas
		for (int i = 0; i < info.length - 1; i++) {

			// Laço interno percorre comparando elementos vizinhos
			for (int j = 0; j < info.length - 1 - i; j++) {

				// Se o elemento atual for maior que o próximo
				if (info[j].compareTo(info[j + 1]) > 0) {

					// Troca os elementos de posição
					trocar(j, j + 1);
				}
			}
		}
	}
}
