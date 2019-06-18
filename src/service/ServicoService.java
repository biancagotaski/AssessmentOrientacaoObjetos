package service;

import java.util.List;
import java.util.UUID;

import dao.ServicoDao;
import domain.Servico;

public class ServicoService {

	public UUID adicionarServico(String descricao, boolean ofereceGarantia, int duracaoServico, float valor, boolean ofereceManutencao) {
		Servico servico = new Servico(descricao, ofereceGarantia, duracaoServico, valor, ofereceManutencao);
		
		ServicoDao servicoDao = new ServicoDao();
		servicoDao.create(servico);
		
		return servico.getId();
	}
	
	public Servico obterServico(UUID id) {
		ServicoDao servicoDao = new ServicoDao();
		return servicoDao.read(id);
	}
	
	public List<Servico> obterTodosOsServicos(){
		ServicoDao servicoDao = new ServicoDao();
		return servicoDao.readAll();
	}
	
	public void alterarServico(UUID id, String descricao, boolean ofereceGarantia, int duracaoServico, float valor, boolean ofereceManutencao) {
		Servico servico = new Servico(id, descricao, ofereceGarantia, duracaoServico, valor, ofereceManutencao);
		
		ServicoDao servicoDao = new ServicoDao();
		servicoDao.update(servico);
	}
	
	public void deletarServico(UUID id) {
		ServicoDao servicoDao = new ServicoDao();
		servicoDao.delete(id);
	}
}
