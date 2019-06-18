package apresentation;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import domain.Empresa;
import domain.Funcionario;
import domain.Servico;
import service.ContratoService;
import service.EmpresaService;
import service.FuncionarioService;
import service.ServicoService;

public class Main {
	
	//====== Serviços =======
	private static FuncionarioService funcionarioService = new FuncionarioService();
	private static EmpresaService empresaService = new EmpresaService();
	private static ServicoService servicoService = new ServicoService();
	private static ContratoService contratoService = new ContratoService();
	//=======================
		
	public static void main(String[] args) {
		int stoppApplication = 20;
		int opcao;
		Scanner scanner = new Scanner(System.in);
		
		do{
			System.out.println("========= Gerenciador de Contratos da Empresa XPTO =========");
			System.out.println();
			System.out.println("---- Funcionários ----");
			System.out.println("1 - Cadastrar Funcionário");
			System.out.println("2 - Alterar Funcionoário");
			System.out.println("3 - Deletar Funcionoário");
			System.out.println("4 - Imprimir um Funcionário");
			System.out.println("5 - Listar todos os Funcionário");
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
			System.out.println("---- Serviços que você irá oferecer ----");
			System.out.println("11 - Cadastrar Tipo de Serviço");
			System.out.println("12 - Alterar Serviço");
			System.out.println("13 - Deletar Serviço");
			System.out.println("14 - Imprimir um Serviço");
			System.out.println("15 - Listar todos os Serviços");
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
				
			}
			
			System.out.println();
			
		} while(opcao != stoppApplication);
	}
	
	//------------ Funções de Funcionário --------------
	private static void cadastrarFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome do funcionário:");
		String nome = scanner.nextLine();
		System.out.println("Digite o endereço do funcionário:");
		String endereco = scanner.nextLine();
		System.out.println("Digite o telefone do funcionário:");
		String telefone = scanner.nextLine();
		
		UUID id = funcionarioService.adicionarFuncionario(nome, endereco, telefone);
		System.out.println("Id do novo funcionário: " + id);
	}
	
	private static void alterarFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do funcionário");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);

		System.out.println("Digite o nome do funcionário:");
		String nome = scanner.nextLine();
		System.out.println("Digite o endereço do funcionário:");
		String endereco = scanner.nextLine();
		System.out.println("Digite o telefone do funcionário:");
		String telefone = scanner.nextLine();
		
		funcionarioService.alterarFuncionario(id, nome, endereco, telefone);
		
	}
	
	private static void deletarFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do funcionário");
		String id = scanner.nextLine();
		UUID idConverted = UUID.fromString(id);
		
		funcionarioService.deletarFuncionario(idConverted);
		
		System.out.println("Funcionário deletado com sucesso!");
	}
	
	private static void imprimirUmFuncionario() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do funcionário");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		Funcionario funcionario = funcionarioService.obterFuncionario(id);
		

		System.out.println("Id: " + funcionario.getId());
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Endereço: " + funcionario.getEndereco());
		System.out.println("Telefone: " + funcionario.getTelefone());
	}
	
	private static void listarFuncionarios() {
		List<Funcionario> funcionarios = funcionarioService.obterTodosFuncionarios();
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Endereço: " + funcionario.getEndereco());
			System.out.println("Telefone: " + funcionario.getTelefone());
			System.out.println("******************************************");
		}
	}

	//--------------------------------------------------
	
	//------------ Funções de Empresa --------------
	private static void cadastrarEmpresa() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o CNPJ da empresa:");
		String cnpj = scanner.nextLine();
		System.out.println("Digite o nome da empresa:");
		String nome = scanner.nextLine();
		System.out.println("Digite o endereço da empresa:");
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
		System.out.println("Digite o endereço da empresa:");
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
		System.out.println("Endereço: " + empresa.getEndereco());
		System.out.println("Telefone: " + empresa.getTelefone());
	}
	
	private static void listarEmpresas() {
		List<Empresa> empresas = empresaService.listarEmpresas();
		for (Empresa empresa : empresas) {
			System.out.println("Id: " + empresa.getId());
			System.out.println("CNPJ: " + empresa.getCnpj());
			System.out.println("Nome: " + empresa.getNome());
			System.out.println("Endereço: " + empresa.getEndereco());
			System.out.println("Telefone: " + empresa.getTelefone());
			System.out.println("******************************************");
		}
	}
	
	//--------------------------------------------------

	//------------ Funções de Serviço --------------
	private static void cadastrarServico() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a descrição desse novo serviço:");
		String descricao = scanner.nextLine();
		
		System.out.println("Esse serviço irá oferecer garantia? (Digite s para Sim e n para Não)");
		String input = scanner.nextLine();
		boolean ofereceGarantia = false;
		if(input.toLowerCase().equals("s")) {
			ofereceGarantia = true;
		} else if(input.toLowerCase().equals("n")){
			ofereceGarantia = false;
		}
		
		System.out.println("Digite a duração desse serviço:");
		String duracao = scanner.nextLine();
		
		System.out.println("Digite o valor do serviço:");
		String valor = scanner.nextLine();
		
		System.out.println("Esse serviço irá oferecer manutenção? (Digite s para Sim e n para Não)");
		String inputUser = scanner.nextLine();
		boolean ofereceManutencao = false;
		if(inputUser.toLowerCase().equals("s")) {
			ofereceManutencao = true;
		}
		else if(inputUser.toLowerCase().equals("n")) {
			ofereceManutencao = false;
		}

		UUID id = servicoService.adicionarServico(descricao, ofereceGarantia, Integer.parseInt(duracao), Float.parseFloat(valor), ofereceManutencao);
		System.out.println("Id do novo Serviço: " + id);
	}
	
	public static void alterarServico() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do Serviço:");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);

		System.out.println("Digite a descrição desse novo serviço:");
		String descricao = scanner.nextLine();
		
		System.out.println("Esse serviço irá oferecer garantia? (Digite s para Sim e n para Não)");
		String input = scanner.nextLine();
		boolean ofereceGarantia = false;
		if(input.toLowerCase().equals("s")) {
			ofereceGarantia = true;
		} else if(input.toLowerCase().equals("n")){
			ofereceGarantia = false;
		}
		
		System.out.println("Digite a duração desse serviço:");
		int duracao = scanner.nextInt();
		
		System.out.println("Digite o valor do serviço:");
		float valor = scanner.nextFloat();
		
		System.out.println("Esse serviço irá oferecer manutenção? (Digite s para Sim e n para Não)");
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
		
		System.out.println("Digite o ID do Serviço");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		servicoService.deletarServico(id);
		
		System.out.println("Serviço deletado com sucesso!");
	}
	
	public static void imprimirServico() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID do serviço");
		String idStr = scanner.nextLine();
		UUID id = UUID.fromString(idStr);
		
		Servico servico = servicoService.obterServico(id);
		
		System.out.println("Id: " + servico.getId());
		System.out.println("Descrição: " + servico.getDescricao());
		System.out.println("Oferece Garantia: " + servico.isOfereceGarantia());
		System.out.println("Duração: " + servico.getDuracaoServico());
		System.out.println("Valor: " + servico.getDuracaoServico());
		System.out.println("Oferece Manutenção: " + servico.isOfereceManutencao());
		System.out.println("******************************************");
	}
	
	public static void listarServicos() {
		List<Servico> servicos = servicoService.obterTodosOsServicos();
		
		for (Servico servico : servicos) {
			System.out.println("Id: " + servico.getId());
			System.out.println("Descrição: " + servico.getDescricao());
			System.out.println("Oferece Garantia: " + servico.isOfereceGarantia());
			System.out.println("Duração: " + servico.getDuracaoServico());
			System.out.println("Valor: " + servico.getDuracaoServico());
			System.out.println("Oferece Manutenção: " + servico.isOfereceManutencao());
			System.out.println("******************************************");
		}
	}
		
	//----------------------------------------------
	
	//------------ Funções de Contrato --------------
	private static void cadastrarContrato() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o ID da empresa com a qual deseja criar contrato");
		UUID idEmpresa = UUID.fromString(scanner.nextLine());
		System.out.println("Digite o ID do Gestor do contrato (seu funcionário)");
		UUID idGestor = UUID.fromString(scanner.nextLine());
		System.out.println("Digite o ID do tipo de Serviço que será prestado");
		UUID idServico = UUID.fromString(scanner.nextLine());
		Date dataInicio = Date.from(Instant.now());
		System.out.println("Qual o período de duração do contrato (número de meses)");
		int meses = scanner.nextInt();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInicio);
		calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH)+meses));
		Date dataFim = calendar.getTime();
		
		System.out.println("Informe o aditivo deste contrato:");
		String aditivo = scanner.nextLine();
				
//		contratoService.criarContrato(empresaService.obterEmpresao(idEmpresa), funcionarioService.obterFuncionario(idGestor) , servicoService.obterServico(idServico), dataInicio, dataFim, aditivo);			
	}
	//--------------------------------------------------
}
