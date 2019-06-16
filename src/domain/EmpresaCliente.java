package domain;

import java.util.List;

public class EmpresaCliente extends DadosPessoais{
	private List<Contrato> contratos;
	private List<OrdemServico> ordemServicos;
	
	private int cnpj;
	
	
	public EmpresaCliente(List<Contrato> contratos, List<OrdemServico> ordemServicos, int cnpj, String nome, String endereco, int telefone) {
		this.contratos = contratos;
		this.ordemServicos = ordemServicos;
		this.cnpj = cnpj;
		super.setNome(nome);
		super.setEndereco(endereco);
		super.setTelefone(telefone);
	}
	
	public EmpresaCliente(int cnpj, String nome, String endereco, int telefone) {
		this.cnpj = cnpj;
		super.setNome(nome);
		super.setEndereco(endereco);
		super.setTelefone(telefone);
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return super.getNome();
	}
	
	public void setNome(String nome) {
		super.setNome(nome);
	}
	
	public String getEndereco() {
		return super.getEndereco();
	}
	
	public void setEndereco(String endereco) {
		super.setNome(endereco);
	}
	
	
	public int getTelefone() {
		return super.getTelefone();
	}
	
	public void setTelefone(String telefone) {
		super.setNome(telefone);
	}
	
}
