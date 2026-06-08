package L11.Q1Q2;

public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract<T> {

	public int buscar(T valor) {

		Object[] vetor = getInfo();

		for (int i = 0; i < vetor.length; i++) {

			T atual = (T) vetor[i];

			if (atual.equals(valor))
				return i;

			/*
			 * Como está ordenado:
			 * se passou do valor,
			 * não precisa continuar.
			 */
			if (atual.compareTo(valor) > 0)
				return -1;
		}

		return -1;
	}
}
