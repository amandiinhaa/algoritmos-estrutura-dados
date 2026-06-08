package L11.Q3Q4;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public void inserir(T info) {

		NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info);

		if (estaVazia()) {
			setRaiz(novo);
			return;
		}

		NoArvoreBinaria<T> atual = getRaiz();

		while (true) {

			if (info.compareTo(atual.getInfo()) < 0) {

				if (atual.getEsquerda() == null) {
					atual.setEsquerda(novo);
					return;
				}

				atual = atual.getEsquerda();
			} else {

				if (atual.getDireita() == null) {
					atual.setDireita(novo);
					return;
				}

				atual = atual.getDireita();
			}
		}
	}

	@Override
	public NoArvoreBinaria<T> buscar(T info) {

		NoArvoreBinaria<T> atual = getRaiz();

		while (atual != null) {

			int comp = info.compareTo(atual.getInfo());

			if (comp == 0)
				return atual;

			if (comp < 0)
				atual = atual.getEsquerda();
			else
				atual = atual.getDireita();
		}

		return null;
	}
}
