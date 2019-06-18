package service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dao.ContratoDao;
import domain.Contrato;
import domain.Empresa;
import domain.Funcionario;
import domain.Servico;

//Casos de Uso - Requisitos Funcionais (Verbo no Infinitivo).
//O que pode ser feito com o sistema.
public class ContratoService {
	
	
	public UUID criarContrato(Empresa empresa, Funcionario gestor, Servico servico, int duracao, String aditivo) {
		Contrato contrato = new Contrato(empresa, gestor, servico, duracao, aditivo);
		
		//--- Persiste ---
		ContratoDao contratoDao = new ContratoDao();
		contratoDao.create(contrato);
		//----------------
		
		return contrato.getId();
	}
	
	public Contrato obterContrato(UUID id) {	
		//--- Obtem da Persistência ---
		ContratoDao contratoDao = new ContratoDao();
		return contratoDao.read(id);
		//-----------------------------
	}
	
	public List<Contrato> obterTodosContratos(){
		//--- Obtem da Persistência ---
		ContratoDao contratoDao = new ContratoDao();
		return contratoDao.readAll();
		//-----------------------------		
	}
	
	public List<Contrato> obterContratosEmpresa(UUID empresaId){
		List<Contrato> contratos = obterTodosContratos();
		return contratos.stream()
				.filter(contrato -> contrato.getEmpresa().getId() == empresaId)
				.collect(Collectors.toList());
	}
	
	public List<Contrato> buscaContratosPorNomeEmpresa(String nomeEmpresa){
		List<Contrato> contratos = obterTodosContratos(); //Possui todos os contratos
		List<Contrato> resultadoBusca = new ArrayList<Contrato>(); //Resultado da Busca com contratos da empresa de nome "nomeEmpresa"
		
		for (Contrato contrato : resultadoBusca) {
			if (contrato.getEmpresa().getNome().toLowerCase().contains(nomeEmpresa.toLowerCase()))
					resultadoBusca.add(contrato);
		}
		
		//ou
		//return contratos.stream()
		//		.filter(contrato -> contrato.getEmpresa().getNome().toLowerCase().contains(nomeEmpresa.toLowerCase()))
		//		.collect(Collectors.toList());
		
		return resultadoBusca;
	}
	
	public void editarContrato(UUID id, Empresa cliente, Funcionario gestor, Servico servico, int duracao, String aditivo) {
		Contrato contrato = new Contrato(id, cliente, gestor, servico, duracao, aditivo);
		
		//--- Persiste ---
		ContratoDao contratoDao = new ContratoDao();
		contratoDao.update(contrato);
		//----------------
	}
	
	public void deletarContrato(UUID id) {
		//--- Persiste ---
		ContratoDao contratoDao = new ContratoDao();
		contratoDao.delete(id);
		//----------------
	}
}
