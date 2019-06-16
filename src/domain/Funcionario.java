package domain;

import java.util.UUID;

public class Funcionario extends DadosPessoais{
	
	public Funcionario(String nome, String endereco, String telefone) {
		this.setId(UUID.randomUUID());
		super.setNome(nome);
		super.setEndereco(endereco);
		super.setTelefone(telefone);
	}
	
	public Funcionario(UUID id, String nome, String endereco, String telefone) {
		this.setId(id);
		super.setNome(nome);
		super.setEndereco(endereco);
		super.setTelefone(telefone);
	}
}
