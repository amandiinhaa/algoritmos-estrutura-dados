package TrabalhoFinal;

public class AtendimentoPreferencial extends GerenciadorAtendimento{
	private RegistroAtendimento ra;
	
	public AtendimentoPreferencial(RegistroAtendimento Ra) {
		this.ra = new RegistroAtendimento(Ra.getIdCliente(), Ra.getHoraEntrada(), Ra.getTipo());
		this.ra.setHoraAtendimento(this.ra.getHoraEntrada() + this.ra.simularHoraAtendimento());
		this.ra.setTempoEspera(this.ra.getHoraAtendimento() - this.ra.getHoraEntrada());
		this.ra.setStatus(StatusAtendimento.ATENDENDO);
	}
	
	public RegistroAtendimento getRa() {
		return ra;
	}
	
	public void setRa(RegistroAtendimento ra) {
		this.ra = ra;
	}
	
	public void finalizarAtendimento() {
		ra.setStatus(StatusAtendimento.FINALIZADO);
		ra.setTempoAtendimento(ra.getHoraAtendimento() + ra.simularHoraAtendimento());
		historicoPreferencial.push(ra);
		trocaAtendimento();
	}
}
