package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.Contrato;

//Repositório. Persiste a informação. É apenas o CRUD.
public class ContratoDao {
	private static List<Contrato> contratos = new ArrayList<Contrato>();
	
	public void create(Contrato contrato) {
		contratos.add(contrato);
	}
	
	public Contrato read(UUID id) {
		for (Contrato contrato : contratos) {
			if (contrato.getId() == id)
				return contrato;
		}
		return null;
	}

	public List<Contrato> readAll(){
		return contratos;
	}
	
	public void update(Contrato contrato) {
		delete(contrato.getId());
		contratos.add(contrato);
	}
	
	public boolean delete(UUID id) {
		for (int i=0; i<contratos.size(); i++) {
			if (contratos.get(i).getId() == id) {
				contratos.remove(i);
				return true;
			}
		}
		return false;
	}

	
}
