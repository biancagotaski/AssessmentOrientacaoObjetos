package domain;

import java.util.Date;

public class Contrato {
	private String aditivo;
	private Date inicio;
	private Date fim;
	private Servico servico;
	private EmpresaCliente cliente;
	private Gestor gestor;
	
	
	public Contrato(EmpresaCliente cliente, Gestor gestor, Servico servico, Date inicio, Date fim, String aditivo) {
		this.cliente = cliente;
		this.gestor = gestor;
		this.servico = servico;
		this.inicio = inicio;
		this.fim = fim;
		this.aditivo = aditivo;
	}
	
	public String getAditivo() {
		return aditivo;
	}
	
	public void setAditivo(String aditivo) {
		this.aditivo = aditivo;
	}
	
	public Date getInicio() {
		return inicio;
	}
	
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public EmpresaCliente getCliente() {
		return cliente;
	}

	public void setCliente(EmpresaCliente cliente) {
		this.cliente = cliente;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}
	
	
}
