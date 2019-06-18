package domain;

import java.util.Date;
import java.util.UUID;

public class Contrato extends EntidadeBase {
	private String aditivo;
	private int duracao;
	private Servico servico;
	private Empresa empresa;
	private Funcionario gestor;
	
	
	public Contrato(Empresa empresa, Funcionario gestor, Servico servico, int duracao, String aditivo) {
		this.setId(UUID.randomUUID());
		this.empresa = empresa;
		this.gestor = gestor;
		this.servico = servico;
		this.duracao = duracao;
		this.aditivo = aditivo;
	}
	
	public Contrato(UUID id, Empresa empresa, Funcionario gestor, Servico servico, int duracao, String aditivo) {
		this.setId(id);
		this.empresa = empresa;
		this.gestor = gestor;
		this.servico = servico;
		this.duracao = duracao;
		this.aditivo = aditivo;
	}
	
	public String getAditivo() {
		return aditivo;
	}
	
	public void setAditivo(String aditivo) {
		this.aditivo = aditivo;
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

	public Funcionario getGestor() {
		return gestor;
	}

	public void setGestor(Funcionario gestor) {
		this.gestor = gestor;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
}
