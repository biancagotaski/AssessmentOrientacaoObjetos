package domain;

import java.util.Date;
import java.util.UUID;

public class Contrato extends EntidadeBase {
	private String aditivo;
	private Date inicio;
	private Date fim;
	private Servico servico;
	private Empresa empresa;
	private Gestor gestor;
	
	
	public Contrato(Empresa empresa, Gestor gestor, Servico servico, Date inicio, Date fim, String aditivo) {
		this.setId(UUID.randomUUID());
		this.empresa = empresa;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}
	
}
