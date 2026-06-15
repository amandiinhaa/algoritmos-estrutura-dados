package TrabalhoFinal;

public class GerenciadorAtendimento {
	// Adicionando 'static' para unificar a memória entre o Gerenciador e os Guichês filhos
	protected static Fila<RegistroAtendimento> filaNormal = new Fila<>(50);
	protected static Fila<RegistroAtendimento> filaPrioridade = new Fila<>(50);

	public static AtendimentoGeral geral1;
	public static AtendimentoGeral geral2;
	public static AtendimentoPreferencial preferencial;
    
    protected static Pilha<RegistroAtendimento> historicoGeral1 = new Pilha<>(50);
    protected static Pilha<RegistroAtendimento> historicoGeral2 = new Pilha<>(50);
    protected static Pilha<RegistroAtendimento> historicoPreferencial = new Pilha<>(50);
    
    public void adicionaRegistro(RegistroAtendimento ra) {
		if (ra.getTipo().equals(TipoPrioridade.NORMAL)) {
			filaNormal.inserir(ra);
		}
		if (ra.getTipo().equals(TipoPrioridade.PREFERENCIAL)) {
			filaPrioridade.inserir(ra);
		}
	}
    
    public void trocaAtendimento() {
    	if (preferencial == null || preferencial.getRa() == null || preferencial.getRa().getStatus().equals(StatusAtendimento.FINALIZADO)) {
    		if (!filaPrioridade.estaVazia()) {
    			preferencial = new AtendimentoPreferencial((RegistroAtendimento)filaPrioridade.retirar());
    		}
		}
    	
    	if (geral1 == null || geral1.getRa() == null) {
    		if (preferencial != null && preferencial.getRa() != null && preferencial.getRa().getStatus().equals(StatusAtendimento.ATENDENDO) && !filaPrioridade.estaVazia()) {
    			geral1 = new AtendimentoGeral(filaPrioridade.retirar());
    		} else if (!filaNormal.estaVazia()) {
    			geral1 = new AtendimentoGeral(filaNormal.retirar());
    		}
		}
    	if (geral2 == null || geral2.getRa() == null) {
    		if (preferencial != null && preferencial.getRa() != null && preferencial.getRa().getStatus().equals(StatusAtendimento.ATENDENDO) && !filaPrioridade.estaVazia()) {
    			geral2 = new AtendimentoGeral(filaPrioridade.retirar());
    		} else if (!filaNormal.estaVazia()) {
    			geral2 = new AtendimentoGeral(filaNormal.retirar());
    		}
		}
    	
    	if (geral1 != null && geral1.getRa() != null && geral1.getRa().getStatus().equals(StatusAtendimento.FINALIZADO)) {
    		if (preferencial != null && preferencial.getRa() != null && preferencial.getRa().getStatus().equals(StatusAtendimento.ATENDENDO) && !filaPrioridade.estaVazia() && !TipoPrioridade.PREFERENCIAL.equals(geral1.getTipoUltimoCliente())) {
    			geral1 = new AtendimentoGeral(filaPrioridade.retirar());
    		} else if (!filaNormal.estaVazia()) {
    			geral1 = new AtendimentoGeral(filaNormal.retirar());
    		}
		}
    	if (geral2 != null && geral2.getRa() != null && geral2.getRa().getStatus().equals(StatusAtendimento.FINALIZADO)) {
    		if (preferencial != null && preferencial.getRa() != null && preferencial.getRa().getStatus().equals(StatusAtendimento.ATENDENDO) && !filaPrioridade.estaVazia() && !TipoPrioridade.PREFERENCIAL.equals(geral2.getTipoUltimoCliente())) {
    			geral2 = new AtendimentoGeral(filaPrioridade.retirar());
    		} else if (!filaNormal.estaVazia()) {
    			geral2 = new AtendimentoGeral(filaNormal.retirar());
    		}
		}
    	
    	if (geral1 != null) geral1.setGuiche(GuicheGeral.Geral1);
    	if (geral2 != null) geral2.setGuiche(GuicheGeral.Geral2);
    }
    
    public String relatorioAtendimento() {
        StringBuilder relatorio = new StringBuilder();
        int totalAtendimentos = historicoGeral1.getTamanho() + historicoGeral2.getTamanho() + historicoPreferencial.getTamanho();

        relatorio.append("===== RELATÓRIO =====\n\n");
        relatorio.append("TOTAL DE ATENDIMENTOS: ").append(totalAtendimentos).append("\n\n");
        relatorio.append("Guichê Geral 1: ").append(historicoGeral1.getTamanho()).append("\n");
        relatorio.append("Guichê Geral 2: ").append(historicoGeral2.getTamanho()).append("\n");
        relatorio.append("Guichê Preferencial: ").append(historicoPreferencial.getTamanho()).append("\n\n");

        return relatorio.toString();
    }
}
