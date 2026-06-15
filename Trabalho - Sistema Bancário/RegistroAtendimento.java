package TrabalhoFinal;

public class RegistroAtendimento extends GerenciadorAtendimento{
private int idCliente;
private double horaEntrada;
private double horaAtendimento;
private double tempoEspera;
private double tempoAtendimento;
private TipoPrioridade tipo;
private StatusAtendimento status;
	
	public RegistroAtendimento(int idCliente, double horaEntrada, TipoPrioridade tipo) {
		setIdCliente(idCliente);
		setHoraEntrada(horaEntrada);
		setTipo(tipo);
		setStatus(StatusAtendimento.AGUARDANDO);
	}
	
	public int getIdCliente() { 
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(double horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	public double getHoraAtendimento() {
		return horaAtendimento;
	}
	public void setHoraAtendimento(double horaAtendimento) {
		this.horaAtendimento = horaAtendimento;
	}
	public double getTempoAtendimento() {
		return tempoAtendimento;
	}
	public void setTempoAtendimento(double tempoAtendimento) {
		this.tempoAtendimento = tempoAtendimento;
	}
	public double getTempoEspera() {
		return tempoEspera;
	}
	public void setTempoEspera(double tempoEspera) {
		this.tempoEspera = tempoEspera;
	}
	public TipoPrioridade getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrioridade tipo) {
		this.tipo = tipo;
	}

	public StatusAtendimento getStatus() {
		return status;
	}

	public void setStatus(StatusAtendimento status) {
		this.status = status;
	}
	
	public float simularHoraAtendimento() {
	    return (float)(Math.random() * 29) + 2;
    }
}
