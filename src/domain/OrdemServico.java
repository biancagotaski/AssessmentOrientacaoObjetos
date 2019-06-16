package domain;

import java.util.Date;

public class OrdemServico extends EntidadeBase {
	private Empresa cliente;
	private Servico servico;
	private String numeroSerie;
	private Date dataEmissao;
	private int numeroOrdem;
	
	public void ordemServico(Empresa cliente, Servico servico) {
		this.cliente = cliente;
		this.servico = servico;
	}	
	
	public Empresa getcliente() {
		return cliente;
	}

	public void setcliente(Empresa cliente) {
		this.cliente = cliente;
	}
	
	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public int getNumeroOrdem() {
		return numeroOrdem;
	}

	public void setNumeroOrdem(int numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}

}
