package domain;

public class Funcionario extends DadosPessoais{
	
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
	
	public void setTelefone(int telefone) {
		super.setTelefone(telefone);
	}
	
	public int getMatricula() {
		return super.getMatricula();
	}
	
	public void setMatricula(int matricula) {
		super.setMatricula(matricula);
	}
	
}
