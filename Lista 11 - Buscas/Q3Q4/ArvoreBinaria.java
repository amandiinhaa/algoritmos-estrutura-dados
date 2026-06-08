package L11.Q3Q4;

public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

	@Override
	public NoArvoreBinaria<T> buscar(T info) {
		return buscar(getRaiz(), info);
	}

	private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {

		if (no == null)
			return null;

		if (no.getInfo().equals(info))
			return no;

		NoArvoreBinaria<T> esq = buscar(no.getEsquerda(), info);

		if (esq != null)
			return esq;

		return buscar(no.getDireita(), info);
	}
}
