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
			+"\n2 - voltar"
			+"\n3 - Cadastrar"
		);
	}

	public void menuConsultas(){
		System.out.println(
			"---------------------"
			+ "\n| Menu de Consultas|\n"
			+ "---------------------\n\n"
			+ "\n1 - Consultar seu saldo"
			+ "\n3 - Consultar seus ganhos"
			+ "\n2 - sair"
		);
	}

	public void menuCadastro(){
		System.out.println(
			"---------------------"
			+ "\n| Menu de Cadastros|\n"
			+ "---------------------\n\n"
			+ "\n1 - Cadastrar ganho"
			+ "\n3 - Cadastrar Conta Bancária"
			+ "\n2 - sair"
		);
	}


	public void crudUser() {
		System.out.println("----------------------"
				+ "\n| CRUD Usuário ADMIN |\n"
				+ "----------------------\n\n"
				+ "\n1 - Listar Usuários"
				+ "\n2 - Adicionar Usuário"
				+ "\n3 - Atualizar Usuário"
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