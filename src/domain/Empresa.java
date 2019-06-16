package domain;

import java.util.UUID;

public class Empresa extends DadosPessoais{
	private String cnpj;
	
	public Empresa(String cnpj, String nome, String endereco, String telefone) {
		this.setId(UUID.randomUUID());
		this.cnpj = cnpj;
		super.setNome(nome);
		super.setEndereco(endereco);
		super.setTelefone(telefone);
	}
	
	public Empresa(UUID id, String cnpj, String nome, String endereco, String telefone) {
		this.setId(id);
		this.cnpj = cnpj;
		super.setNome(nome);
		super.setEndereco(endereco);
		super.setTelefone(telefone);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
