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
    	int totalAtendimentos = historicoGeral1.getTamanho() + historicoGeral2.getTamanho() + historicoPreferencial.getTamanho();

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=========================================\n");
        relatorio.append("            RELATÓRIO FINAL              \n");
        relatorio.append("=========================================\n\n");
        relatorio.append("TOTAL DE ATENDIMENTOS REAIS: ").append(totalAtendimentos).append("\n");
        relatorio.append("  - Guichê Geral 1: ").append(historicoGeral1.getTamanho()).append("\n");
        relatorio.append("  - Guichê Geral 2: ").append(historicoGeral2.getTamanho()).append("\n");
        relatorio.append("  - Guichê Preferencial: ").append(historicoPreferencial.getTamanho()).append("\n\n");

        if (totalAtendimentos == 0) {
            relatorio.append("Nenhum atendimento registrado para ordenação.\n");
            return relatorio.toString();
        }

        // Criando a base de dados unificada em um array fixo para ordenação
        RegistroAtendimento[] baseDados1 = new RegistroAtendimento[totalAtendimentos];
        RegistroAtendimento[] baseDados2 = new RegistroAtendimento[totalAtendimentos];
        int index = 0;

        // Descarrega Historico Geral 1 temporariamente sem destruir a pilha original
        Pilha<RegistroAtendimento> tempG1 = new Pilha<>(50);
        while (!historicoGeral1.estaVazia()) {
            RegistroAtendimento r = historicoGeral1.pop();
            baseDados1[index] = r;
            baseDados2[index] = r;
            index++;
            tempG1.push(r);
        }
        while (!tempG1.estaVazia()) { historicoGeral1.push(tempG1.pop()); }

        // Descarrega Historico Geral 2
        Pilha<RegistroAtendimento> tempG2 = new Pilha<>(50);
        while (!historicoGeral2.estaVazia()) {
            RegistroAtendimento r = historicoGeral2.pop();
            baseDados1[index] = r;
            baseDados2[index] = r;
            index++;
            tempG2.push(r);
        }
        while (!tempG2.estaVazia()) { historicoGeral2.push(tempG2.pop()); }

        // Descarrega Historico Preferencial
        Pilha<RegistroAtendimento> tempP = new Pilha<>(50);
        while (!historicoPreferencial.estaVazia()) {
            RegistroAtendimento r = historicoPreferencial.pop();
            baseDados1[index] = r;
            baseDados2[index] = r;
            index++;
            tempP.push(r);
        }
        while (!tempP.estaVazia()) { historicoPreferencial.push(tempP.pop()); }

        // --- ORDENAÇÃO 1: CRESCENTE POR TEMPO DE ESPERA ---
        Ordenador.ordenarPorTempoEspera(baseDados1, 0, totalAtendimentos - 1);
        relatorio.append("-----------------------------------------\n");
        relatorio.append(" LISTA: ORDEM CRESCENTE DE TEMPO DE ESPERA \n");
        relatorio.append("-----------------------------------------\n");
        for (RegistroAtendimento r : baseDados1) {
            relatorio.append(String.format("ID: %d | Tipo: %s | Espera: %.2f min\n", 
                    r.getIdCliente(), r.getTipo(), r.getTempoEspera()));
        }

        // --- ORDENAÇÃO 2: ORDEM CRONOLÓGICA (HORA ATENDIMENTO) ---
        Ordenador.ordenarPorHoraAtendimento(baseDados2, 0, totalAtendimentos - 1);
        relatorio.append("\n-----------------------------------------\n");
        relatorio.append(" LISTA: ORDEM CRONOLÓGICA DE ATENDIMENTO \n");
        relatorio.append("-----------------------------------------\n");
        for (RegistroAtendimento r : baseDados2) {
            relatorio.append(String.format("ID: %d | Tipo: %s | Horário Inicial: %.2f h\n", 
                    r.getIdCliente(), r.getTipo(), r.getHoraAtendimento()));
        }

        return relatorio.toString();
    }
}
