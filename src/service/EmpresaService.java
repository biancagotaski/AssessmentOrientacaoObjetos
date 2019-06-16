package service;

import java.util.List;
import java.util.UUID;

import dao.EmpresaDao;
import domain.Empresa;

public class EmpresaService {

	
	public UUID cadastrarEmpresa(String cnpj, String nome, String endereco, String telefone) {
		Empresa empresa = new Empresa(cnpj, nome, endereco, telefone);
		
		EmpresaDao empresaDao = new EmpresaDao();
		empresaDao.create(empresa);
		
		return empresa.getId();
	}
	
	public Empresa obterEmpresao(UUID id) {
		EmpresaDao empresaDao = new EmpresaDao();
		return empresaDao.read(id);
	}
	
	public List<Empresa> listarEmpresas(){
		EmpresaDao empresaDao = new EmpresaDao();
		return empresaDao.readAll();
	}
	
	public void alterarEmpresa(UUID id, String cnpj, String nome, String endereco, String telefone) {
		Empresa empresa = new Empresa(id, cnpj, nome, endereco, telefone);
		
		EmpresaDao empresaDao = new EmpresaDao();
		empresaDao.update(empresa);
	}
	
	public void deletarEmpresa(UUID id) {
		EmpresaDao empresaDao = new EmpresaDao();
		empresaDao.delete(id);
	}
}
