package TrabalhoFinal;

public class AtendimentoGeral extends GerenciadorAtendimento{	
	private RegistroAtendimento ra;
	private TipoPrioridade tipoUltimoCliente;
	private GuicheGeral guiche;
	
	public AtendimentoGeral(RegistroAtendimento Ra) {
		this.ra = new RegistroAtendimento(Ra.getIdCliente(), Ra.getHoraEntrada(), Ra.getTipo());
		this.ra.setHoraAtendimento(this.ra.getHoraEntrada() + this.ra.simularHoraAtendimento());
		this.ra.setTempoEspera(this.ra.getHoraAtendimento() - this.ra.getHoraEntrada());
		this.ra.setStatus(StatusAtendimento.ATENDENDO);
	}
	
	public TipoPrioridade getTipoUltimoCliente() {
		return tipoUltimoCliente;
	}

	public void setTipoUltimoCliente(TipoPrioridade tipo) {
		this.tipoUltimoCliente = tipo;
	}
	
	public RegistroAtendimento getRa() {
		return ra;
	}
	public void setRa(RegistroAtendimento ra) {
		this.ra = ra;
	}
	
	public GuicheGeral getGuiche() {
		return guiche;
	}

	public void setGuiche(GuicheGeral guiche) {
		this.guiche = guiche;
	}

	public void finalizarAtendimento() {
		ra.setStatus(StatusAtendimento.FINALIZADO);
		ra.setTempoAtendimento(ra.getHoraAtendimento() + ra.simularHoraAtendimento());
		if (getGuiche().equals(GuicheGeral.Geral1)) {
			historicoGeral1.push(ra);
		}
		if (getGuiche().equals(GuicheGeral.Geral2)) {
			historicoGeral2.push(ra);
		}
		setTipoUltimoCliente(ra.getTipo());
		trocaAtendimento();
	}
}
