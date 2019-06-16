package domain;

import java.util.Date;

public class Fiscal extends Funcionario{

	public Fiscal(String nome, String endereco, String telefone) {
		super(nome, endereco, telefone);
		// TODO Auto-generated constructor stub
	}
	
	
	//verifica condições da máquina
	//verifica se o contrato já expirou
	//envia os status das fiscalizações para o gestor
}
