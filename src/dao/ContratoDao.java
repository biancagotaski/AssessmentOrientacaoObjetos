package dao;

import java.util.Date;
import java.util.List;

import domain.Contrato;
import domain.EmpresaCliente;
import domain.Gestor;
import domain.Servico;

public class ContratoDao {
	private List<Contrato> contratos;
	
	public void novoContrato(EmpresaCliente cliente, Gestor gestor, Servico servico, Date inicio, Date fim, String aditivo) {
		Contrato contrato = new Contrato(cliente, gestor, servico, inicio, fim, aditivo);
		contratos.add(contrato);
	}
	
}
