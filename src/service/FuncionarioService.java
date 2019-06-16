package service;

import java.util.List;
import java.util.UUID;

import dao.FuncionarioDao;
import domain.Funcionario;

public class FuncionarioService {
	
	
	public UUID adicionarFuncionario(String nome, String endereco, String telefone) {
		Funcionario funcionario = new Funcionario(nome, endereco, telefone);
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.create(funcionario);
		
		return funcionario.getId();
	}
	
	public Funcionario obterFuncionario(UUID id) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		return funcionarioDao.read(id);
	}
	
	public List<Funcionario> obterTodosFuncionarios(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		return funcionarioDao.readAll();
	}
	
	public void alterarFuncionario(UUID id, String nome, String endereco, String telefone) {
		Funcionario funcionario = new Funcionario(id, nome, endereco, telefone);
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.update(funcionario);
	}
	
	public void deletarFuncionario(UUID id) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		funcionarioDao.delete(id);
	}
}