package dadosPacote;

public class Menus {

	public void loginMenu() {
		System.out.println(""
				+ "\n1 - Login"
				+ "\n2 - Cadastro"
				+ "\n3 - Sair");
	}

	public void userMenu(int permissao) {
		String cabecalho;
		String opcoes;

		opcoes = 
				"\n1 - Ferramentas SaveDin"
				+"\n2 - Perfil"
				+ "\n3 - Editar usuário";

		if (permissao == 1) {
			cabecalho = "------------------------"
					+ "\n| Menu Principal ADMIN |\n"
					+ "------------------------\n\n";
			opcoes += "\n4 - CRUD Usuários"
					+ "\n5 - Logout";
		} else {
			cabecalho = "------------------"
					+ "\n| Menu Principal |\n"
					+ "------------------\n\n";
			opcoes += "\n4 - Logout";
		}

		System.out.println(cabecalho + opcoes);
	}

	public void menuSavedin(){
		System.out.println( 
			"---------------------"
			+ "\n| Menu SaveDin |\n"
			+ "---------------------\n\n"
		);
									
		System.out.println(
			"\n1 - Consultas"
			+"\n3 - Cadastrar"
			+"\n4 - Projeções"
			+"\n5 - Deletar"
			+"\n2 - voltar"
		);
	}

	public void menuConsultas(){
		System.out.println(
			"---------------------"
			+ "\n| Menu de Consultas|\n"
			+ "---------------------\n\n"
			+ "\n1 - Consultar seu saldo"
			+ "\n3 - Consultar seus ganhos"
			+ "\n4 - Consultar contas bancárias"
			+ "\n5 - Consultar investimentos"
			+ "\n6 - Consultar gastos"
			+ "\n2 - sair"
		);
	}

	public void menuDeletar(){
		System.out.println(
			"---------------------"
			+ "\n|   Menu Deletar   |\n"
			+ "---------------------\n\n"
			+ "\n1 - Deletar ganho"
			+ "\n2 - Deletar conta bancária"
			+ "\n3 - Deletar Investimento"
			+ "\n4 - Deletar gasto"
			+ "\n5 - sair"
		);
	}

	public void menuCadastro(){
		System.out.println(
			"---------------------"
			+ "\n| Menu de Cadastros|\n"
			+ "---------------------\n\n"
			+ "\n1 - Cadastrar ganho"
			+ "\n3 - Cadastrar conta bancária"
			+ "\n4 - Cadastrar Investimento"
			+ "\n5 - Cadastrar gasto"
			+ "\n2 - sair"
		);
	}

	public void menuProjecoes(){
		System.out.println(
			"---------------------"
			+ "\n| Menu de Projeções|\n"
			+ "---------------------\n\n"
			+ "\n1 - Projeções mensais"
			+ "\n2 - Projeções anuais"
			+ "\n3 - Sair"
		);
	}


	public void crudUser() {
		System.out.println("----------------------"
				+ "\n| CRUD Usuário ADMIN |\n"
				+ "----------------------\n\n"
				+ "\n1 - Listar Usuários"
				+ "\n2 - Adicionar Usuário"
				+ "\n4 - Remover Usuário"
				+ "\n5 - Voltar");
	}

	public void editUserMenu() {
		System.out.println("------------------"
				+ "\n| Editar Usuário |\n"
				+ "------------------\n\n"
				+ "\n1 - Editar nome"
				+ "\n2 - Editar email"
				+ "\n3 - Editar senha"
				+ "\n4 - Editar tudo"
				+ "\n5 - Voltar");
	}
}