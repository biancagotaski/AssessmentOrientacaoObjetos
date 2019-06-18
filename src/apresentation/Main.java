package apresentation;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import domain.Contrato;
import domain.Empresa;
import domain.Funcionario;
import domain.Servico;
import service.ContratoService;
import service.EmpresaService;
import service.FuncionarioService;
import service.ServicoService;

public class Main {
	
	//====== Servi�os =======
	private static FuncionarioService funcionarioService = new FuncionarioService();
	private static EmpresaService empresaService = new EmpresaService();
	private static ServicoService servicoService = new ServicoService();
	private static ContratoService contratoService = new ContratoService();
	//=======================
		
	public static void main(String[] args) {
		int stoppApplication = 22;
		int opcao;
		Scanner scanner = new Scanner(System.in);
		seed(); //Preenche a base de dados com algumas informa��es iniciais.
		
		do{
			System.out.println("========= Gerenciador de Contratos da Empresa XPTO =========");
			System.out.println();
			System.out.println("---- Funcion�rios ----");
			System.out.println("1 - Cadastrar Funcion�rio");
			System.out.println("2 - Alterar Funciono�rio");
			System.out.println("3 - Deletar Funciono�rio");
			System.out.println("4 - Imprimir um Funcion�rio");
			System.out.println("5 - Listar todos os Funcion�rio");
			System.out.println("-----------------------");
			System.out.println();
			System.out.println("---- Empresas (Clientes) ----");
			System.out.println("6 - Cadastrar Empresa");
			System.out.println("7 - Alterar Empresa");
			System.out.println("8 - Deletar Empresa");
			System.out.println("9 - Imprimir uma Empresa");
			System.out.println("10 - Listar Todas as Empresas");
			System.out.println("-----------------------");
			System.out.println();
			System.out.println("---- Servi�os que voc� ir� oferecer ----");
			System.out.println("11 - Cadastrar Tipo de Servi�o");
			System.out.println("12 - Alterar Servi�o");
			System.out.println("13 - Deletar Servi�o");
			System.out.println("14 - Imprimir um Servi�o");
			System.out.println("15 - Listar todos os Servi�os");
			System.out.println("-----------------------");
			System.out.println();
			System.out.println("---- Contratos ----");
			System.out.println("16 - Cadastrar Novo Contrato");
			System.out.println("17 - Alterar Contrato");
			System.out.println("18 - Deletar Contrato");
			System.out.println("19 - Imprimir um Contrato");
			System.out.println("20 - Listar todos os Contratos");
			System.out.println("-----------------------");
			System.out.println("22 - Sair");
			opcao = scanner.nextInt();
			
			System.out.println();
			
			switch(opcao) {
				case 1:
					cadastrarFuncionario();
					break;
				case 2:
					alterarFuncionario();
					break;
				case 3:
					deletarFuncionario();
					break;
				case 4:
					imprimirUmFuncionario();
					break;
				case 5:
					listarFuncionarios();
					break;
				case 6:
					cadastrarEmpresa();
					break;
				case 7:
					alterarEmpresa();
					break;
				case 8:
					deletarEmpresa();
					break;
				case 9:
					imprimirEmpresa();
					break;
				case 10:
					listarEmpresas();
					break;
				case 11:
					cadastrarServico();
					break;
				case 12:
					alterarServico();
					break;
				case 13:
					deletarServico();
					break;
				case 14:
					imprimirServico();
					break;
				case 15:
					listarServicos();
					break;
				case 16:
					cadastrarContrato();
					break;
				case 17:
					alterarContrato();
					break;
				case 18:
					deletarContrato();
					break;
				case 19:
					imprimirContrato();
					break;
				case 20:
					listarContratos();
					break;
			}
			
			System.out.println();
			System.out.println("Pressione ENTER para voltar ao menu principal...");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while(opcao != stoppApplication);
	}
	
	//------------ Seed -------------
	private static void seed() {
		
		//------------- Instanciando objetos (Funcion�rio) -------------
		
		//Funcion�rio 1
		UUID funcId = funcionarioService.adicionarFuncionario("Rodolfo", "Rua S�o Jos� 90", "12345");
		Funcionario funcionario = funcionarioService.obterFuncionario(funcId);
		
		//Funcion�rio 2
		UUID funcId2 = funcionarioService.adicionarFuncionario("Joana", "Rua Chico Boarque, 294", "776291");
		Funcionario func2= funcionarioService.obterFuncionario(funcId2);
		
		//------------- Instanciando objetos (Empresa) -------------
		
		//Empresa1
		UUID empId = empresaService.cadastrarEmpresa("22.234.53534/2342-1", "Couves S.A.", "Rua das Couves s/n", "23482342");
		Empresa empresa = empresaService.obterEmpresao(empId);
		
		//Empresa1
		UUID empId2 = empresaService.cadastrarEmpresa("10.928.57570/1379-2", "Beterraba S.A.", "Rua das Beterrabas, 742", "00192828");
		Empresa emp2 = empresaService.obterEmpresao(empId2);
		
		//------------- Instanciando objetos (Servi�o) -------------
		
		//Servi�o
		UUID servicoId = servicoService.adicionarServico("Plantio de Couve", true, 12, 3500, true);
		Servico servico = servicoService.obterServico(servicoId);
		
		//Servi�o
		UUID servicoId2 = servicoService.adicionarServico("Plantio de Beterrabas", false, 34, 2805, false);
		Servico serv2 = servicoService.obterServico(servicoId2);
		
		//------------- Instanciando objetos (Contrato) -------------
		
		//Contrato
		UUID contrId1 = contratoService.criarContrato(empresa, funcionario, servico, 12, "");
		Contrato contr1 = contratoService.obterContrato(contrId1);
		
		//Contrato
		UUID contrId2 = contratoService.criarContrato(emp2, func2, serv2, 24, "");
		Contrato contr2 = contratoService.obterContrato(contrId2);
		
		//Contrato
		UUID contrId3 = contratoService.criarContrato(empresa, func2, servico, 48, "Esse contrato � pass�vel de mudan�as");
		Contrato contr3 = contratoService.obterContrato(contrId3);
		
		//Contrato
		UUID contrId4 = contratoService.criarContrato(emp2, funcionario, serv2, 6, "O cliente ir� revisar esse contrato");
		Contrato contr4 = contratoService.obterContrato(contrId4);
	}
	//-------------------------------
	
	//------------ Fun��es de Funcion�rio --------------
	private static void cadastrarFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome do funcion�rio:");
		String nome = scanner.nextLine();
		System.out.println("Digite o endere�o do funcion�rio:");
		String endereco = scanner.nextLine();
		System.out.println("Digite o telefone do funcion�rio:");
		String telefone = scanner.nextLine();
		
		UUID id = funcionarioService.adicionarFuncionario(nome, endereco, telefone);
		System.out.println("Id do novo funcion�rio: " + id);
	}
	
	private static void alterarFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do funcion�rio");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);

		System.out.println("Digite o nome do funcion�rio:");
		String nome = scanner.nextLine();
		System.out.println("Digite o endere�o do funcion�rio:");
		String endereco = scanner.nextLine();
		System.out.println("Digite o telefone do funcion�rio:");
		String telefone = scanner.nextLine();
		
		funcionarioService.alterarFuncionario(id, nome, endereco, telefone);
		
	}
	
	private static void deletarFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do funcion�rio");
		String id = scanner.nextLine();
		UUID idConverted = UUID.fromString(id);
		
		funcionarioService.deletarFuncionario(idConverted);
		
		System.out.println("Funcion�rio deletado com sucesso!");
	}
	
	private static void imprimirUmFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do funcion�rio");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		Funcionario funcionario = funcionarioService.obterFuncionario(id);
		

		System.out.println("Id: " + funcionario.getId());
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Endere�o: " + funcionario.getEndereco());
		System.out.println("Telefone: " + funcionario.getTelefone());
	}
	
	private static void listarFuncionarios() {
		System.out.println("Funcion�rios cadastrados:");
		
		List<Funcionario> funcionarios = funcionarioService.obterTodosFuncionarios();
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Endere�o: " + funcionario.getEndereco());
			System.out.println("Telefone: " + funcionario.getTelefone());
			System.out.println("******************************************");
		}
	}

	//--------------------------------------------------
	
	//------------ Fun��es de Empresa --------------
	private static void cadastrarEmpresa() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o CNPJ da empresa:");
		String cnpj = scanner.nextLine();
		System.out.println("Digite o nome da empresa:");
		String nome = scanner.nextLine();
		System.out.println("Digite o endere�o da empresa:");
		String endereco = scanner.nextLine();
		System.out.println("Digite o telefone da empresa:");
		String telefone = scanner.nextLine();
		
		UUID id = empresaService.cadastrarEmpresa(cnpj, nome, endereco, telefone);
		System.out.println("Id da nova empresa: " + id);
	}
	
	private static void alterarEmpresa() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID da empresa:");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);

		System.out.println("Digite o CNPJ da empresa:");
		String cnpj = scanner.nextLine();
		System.out.println("Digite o nome da empresa:");
		String nome = scanner.nextLine();
		System.out.println("Digite o endere�o da empresa:");
		String endereco = scanner.nextLine();
		System.out.println("Digite o telefone da empresa:");
		String telefone = scanner.nextLine();
		
		empresaService.alterarEmpresa(id, cnpj, nome, endereco, telefone);
	}
	
	private static void deletarEmpresa() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID da empresa cadastrada");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		empresaService.deletarEmpresa(id);
		
		System.out.println("Empresa deletada com sucesso!");
	}
	
	private static void imprimirEmpresa() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID da empresa cadastrada");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		Empresa empresa = empresaService.obterEmpresao(id);

		System.out.println("Id: " + empresa.getId());
		System.out.println("CNPJ: " + empresa.getCnpj());
		System.out.println("Nome: " + empresa.getNome());
		System.out.println("Endere�o: " + empresa.getEndereco());
		System.out.println("Telefone: " + empresa.getTelefone());
	}
	
	private static void listarEmpresas() {
		System.out.println("Empresas cadastradas:");
		
		List<Empresa> empresas = empresaService.listarEmpresas();
		for (Empresa empresa : empresas) {
			System.out.println("Id: " + empresa.getId());
			System.out.println("CNPJ: " + empresa.getCnpj());
			System.out.println("Nome: " + empresa.getNome());
			System.out.println("Endere�o: " + empresa.getEndereco());
			System.out.println("Telefone: " + empresa.getTelefone());
			System.out.println("******************************************");
		}
	}
	
	//--------------------------------------------------

	//------------ Fun��es de Servi�o --------------
	private static void cadastrarServico() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a descri��o desse novo servi�o:");
		String descricao = scanner.nextLine();
		
		System.out.println("Esse servi�o ir� oferecer garantia? (Digite s para Sim e n para N�o)");
		String input = scanner.nextLine();
		boolean ofereceGarantia = false;
		if(input.toLowerCase().equals("s")) {
			ofereceGarantia = true;
		} else if(input.toLowerCase().equals("n")){
			ofereceGarantia = false;
		}
		
		System.out.println("Digite a dura��o desse servi�o:");
		String duracao = scanner.nextLine();
		
		System.out.println("Digite o valor do servi�o:");
		String valor = scanner.nextLine();
		
		System.out.println("Esse servi�o ir� oferecer manuten��o? (Digite s para Sim e n para N�o)");
		String inputUser = scanner.nextLine();
		boolean ofereceManutencao = false;
		if(inputUser.toLowerCase().equals("s")) {
			ofereceManutencao = true;
		}
		else if(inputUser.toLowerCase().equals("n")) {
			ofereceManutencao = false;
		}

		UUID id = servicoService.adicionarServico(descricao, ofereceGarantia, Integer.parseInt(duracao), Float.parseFloat(valor), ofereceManutencao);
		System.out.println("Id do novo Servi�o: " + id);
	}
	
	public static void alterarServico() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do Servi�o:");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);

		System.out.println("Digite a descri��o desse novo servi�o:");
		String descricao = scanner.nextLine();
		
		System.out.println("Esse servi�o ir� oferecer garantia? (Digite s para Sim e n para N�o)");
		String input = scanner.nextLine();
		boolean ofereceGarantia = false;
		if(input.toLowerCase().equals("s")) {
			ofereceGarantia = true;
		} else if(input.toLowerCase().equals("n")){
			ofereceGarantia = false;
		}
		
		System.out.println("Digite a dura��o desse servi�o:");
		int duracao = scanner.nextInt();
		
		System.out.println("Digite o valor do servi�o:");
		float valor = scanner.nextFloat();
		
		System.out.println("Esse servi�o ir� oferecer manuten��o? (Digite s para Sim e n para N�o)");
		String inputUser = scanner.nextLine();
		boolean ofereceManutencao = false;
		if(inputUser.toLowerCase().equals("s")) {
			ofereceManutencao = true;
		}
		else if(inputUser.toLowerCase().equals("n")) {
			ofereceManutencao = false;
		}

		servicoService.alterarServico(id, descricao, ofereceGarantia, duracao, valor, ofereceManutencao);
	}
	
	public static void deletarServico() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do Servi�o");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		servicoService.deletarServico(id);
		
		System.out.println("Servi�o deletado com sucesso!");
	}
	
	public static void imprimirServico() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do servi�o");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		Servico servico = servicoService.obterServico(id);
		
		System.out.println("Id: " + servico.getId());
		System.out.println("Descri��o: " + servico.getDescricao());
		System.out.println("Oferece Garantia: " + servico.isOfereceGarantia());
		System.out.println("Dura��o: " + servico.getDuracaoServico());
		System.out.println("Valor: " + servico.getDuracaoServico());
		System.out.println("Oferece Manuten��o: " + servico.isOfereceManutencao());
		System.out.println("******************************************");
	}
	
	public static void listarServicos() {
		System.out.println("Servi�os cadastrados:");
		
		List<Servico> servicos = servicoService.obterTodosOsServicos();
		
		for (Servico servico : servicos) {
			System.out.println("Id: " + servico.getId());
			System.out.println("Descri��o: " + servico.getDescricao());
			System.out.println("Oferece Garantia: " + servico.isOfereceGarantia());
			System.out.println("Dura��o: " + servico.getDuracaoServico());
			System.out.println("Valor: " + servico.getDuracaoServico());
			System.out.println("Oferece Manuten��o: " + servico.isOfereceManutencao());
			System.out.println("******************************************");
		}
	}
		
	//----------------------------------------------
	
	//------------ Fun��es de Contrato --------------
	private static void cadastrarContrato() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID da empresa com a qual deseja criar contrato");
		UUID idEmpresa = UUID.fromString(scanner.nextLine());
		System.out.println("Digite o ID do Gestor do contrato (seu funcion�rio)");
		UUID idGestor = UUID.fromString(scanner.nextLine());
		System.out.println("Digite o ID do tipo de Servi�o que ser� prestado");
		UUID idServico = UUID.fromString(scanner.nextLine());
		Date dataInicio = Date.from(Instant.now());
		System.out.println("Qual o per�odo de dura��o do contrato (n�mero de meses)");
		String duracaoStr = scanner.nextLine();
		System.out.println("Se esse contrato j� possui algum aditivo, detalhe ele:");
		String aditivo = scanner.nextLine();
				
		UUID id = contratoService.criarContrato(empresaService.obterEmpresao(idEmpresa), funcionarioService.obterFuncionario(idGestor) , servicoService.obterServico(idServico), Integer.parseInt(duracaoStr), aditivo);
		System.out.println("Id do contrato cadastrado:" + id);
	}

	public static void alterarContrato() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do Contrato:");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);

		System.out.println("Digite o ID da empresa com a qual deseja criar contrato");
		UUID idEmpresa = UUID.fromString(scanner.nextLine());
		System.out.println("Digite o ID do Gestor do contrato (seu funcion�rio)");
		UUID idGestor = UUID.fromString(scanner.nextLine());
		System.out.println("Digite o ID do tipo de Servi�o que ser� prestado");
		UUID idServico = UUID.fromString(scanner.nextLine());
		Date dataInicio = Date.from(Instant.now());
		System.out.println("Qual o per�odo de dura��o do contrato (n�mero de meses)");
		String duracaoStr = scanner.nextLine();
		System.out.println("Se esse contrato j� possui algum aditivo, detalhe ele:");
		String aditivo = scanner.nextLine();

		contratoService.editarContrato(id, empresaService.obterEmpresao(idEmpresa), funcionarioService.obterFuncionario(idGestor) , servicoService.obterServico(idServico), Integer.parseInt(duracaoStr), aditivo);
	}
	
	public static void deletarContrato() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do contrato a ser deletado");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		contratoService.deletarContrato(id);
		
		System.out.println("Contrato deletado com sucesso!");
	}
	
	public static void imprimirContrato() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do contrato");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		Contrato contrato = contratoService.obterContrato(id);
		
		System.out.println("Id do Contrato: " + contrato.getId());
		System.out.println("Id do Gestor: " + contrato.getGestor().getId());
		System.out.println("Nome do Gestor: " + contrato.getGestor().getNome());
		System.out.println("Id do Servi�o: " + contrato.getServico().getId());
		System.out.println("Descri��o do Servi�o: " + contrato.getServico().getDescricao());
		System.out.println("Id da Empresa para a qual prestar� servi�o: " + contrato.getEmpresa().getId() );
		System.out.println("Dura��o: " + contrato.getServico().getDuracaoServico() + " meses");
		System.out.println("Aditivo: " + contrato.getAditivo());
		System.out.println("******************************************");
	}
	
	public static void listarContratos() {
		System.out.println("Contratos cadastrados:");
		
		List<Contrato> contratos = contratoService.obterTodosContratos();
		for (Contrato contrato : contratos) {
			System.out.println("Id do Contrato: " + contrato.getId());
			System.out.println("Id do Gestor: " + contrato.getGestor().getId());
			System.out.println("Nome do Gestor: " + contrato.getGestor().getNome());
			System.out.println("Id do Servi�o: " + contrato.getServico().getId());
			System.out.println("Descri��o do Servi�o: " + contrato.getServico().getDescricao());
			System.out.println("Id da Empresa para a qual prestar� servi�o: " + contrato.getEmpresa().getId() );
			System.out.println("Dura��o: " + contrato.getServico().getDuracaoServico() + " meses");
			System.out.println("Aditivo: " + contrato.getAditivo());
			System.out.println("******************************************");
		}		
	}
	//--------------------------------------------------
}
