package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.Empresa;

public class EmpresaDao {

	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	public void create(Empresa empresa) {
		empresas.add(empresa);
	}
	
	public Empresa read(UUID id) {
		for(Empresa empresa : empresas) {
			if(empresa.getId().equals(id)) {
				return empresa;
			}
		}
		return null;
	}
	
	public List<Empresa> readAll(){
		return empresas;
	}
	
	public void update(Empresa empresa) {
		delete(empresa.getId());
		empresas.add(empresa);
	}
	
	public boolean delete(UUID id) {
		for(int i=0; i<empresas.size(); i++) {
			if(empresas.get(i).getId().equals(id)){
				empresas.remove(i);
				return true;
			}
		}
		return false;
	}
}