package domain;

public class Servico {
	private String descricao;
	private boolean ofereceGarantia;
	private int duracaoServico;
	private float valor;
	private boolean ofereceManutencao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isOfereceGarantia() {
		return ofereceGarantia;
	}

	public void setOfereceGarantia(boolean ofereceGarantia) {
		this.ofereceGarantia = ofereceGarantia;
	}

	public int getDuracaoServico() {
		return duracaoServico;
	}

	public void setDuracaoServico(int duracaoServico) {
		this.duracaoServico = duracaoServico;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isOfereceManutencao() {
		return ofereceManutencao;
	}

	public void setOfereceManutencao(boolean ofereceManutencao) {
		this.ofereceManutencao = ofereceManutencao;
	}
	
}
