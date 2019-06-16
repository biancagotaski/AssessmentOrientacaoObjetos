package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.Funcionario;

public class FuncionarioDao {
	
	
	private static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public void create(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public Funcionario read(UUID id) {
		for(Funcionario funcionario : funcionarios) {
			if(funcionario.getId().equals(id)) {
				return funcionario;
			}
		}
		return null;
	}
	
	public List<Funcionario> readAll(){
		return funcionarios;
	}
	
	public void update(Funcionario funcionario) {
		delete(funcionario.getId());
		funcionarios.add(funcionario);
	}
	
	public boolean delete(UUID id) {
		for(int i=0; i<funcionarios.size(); i++) {
			if(funcionarios.get(i).getId().equals(id)) {
				funcionarios.remove(i);
				return true;
			}
		}
		return false;
	}
}
