package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.Servico;

public class ServicoDao {
	
	private static List<Servico> servicos = new ArrayList<Servico>();
	
	public void create(Servico servico) {
		servicos.add(servico);
	}
	
	public Servico read(UUID id) {
		for (Servico servico : servicos) {
			if(servico.getId().equals(id)) {
				return servico;
			}
		}
		return null;
	}
	
	public List<Servico> readAll(){
		return servicos;
	}
	
	public void update(Servico servico) {
		delete(servico.getId());
		servicos.add(servico);
	}
	
	public boolean delete(UUID id) {
		for(int i=0; i<servicos.size(); i++) {
			if(servicos.get(i).getId().equals(id)) {
				servicos.remove(i);
				return true;
			}
		}
		return false;
	}
}
