package testePacote;

import dadosPacote.*;
import investimentoPacote.Investimento;
import investimentoPacote.InvestimentoDAO;
import repositoriosPacote.*;

import java.util.Scanner;

import bancoPacote.ContaBancaria;
import bancoPacote.ContaBancariaDAO;

public class SistemaTeste {
	public static void main(String[] args) {

		// Classes
		Saldo saldo = new Saldo(0.0);
		Menus menu = new Menus();
		Login login = new Login();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		LimparConsole console = new LimparConsole();
		GanhoDAO ganhoDAO = new GanhoDAO();
		ContaBancariaDAO contaBancariaDAO = new ContaBancariaDAO();
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		GastosDAO gastosDAO = new GastosDAO();

		// Repositorios
		RepositorioUser usuario = new RepositorioUser();
		RepositorioGanho ganhos = new RepositorioGanho();
		RepositorioContasBancarias contas = new RepositorioContasBancarias();
		RepositorioInvestimentos investimentos = new RepositorioInvestimentos();
		RepositorioGastos gastos = new RepositorioGastos();

		// Libs
		Scanner input = new Scanner(System.in);

		boolean run = true;
		int number;

		// Index

		Usuario userLogado = null;
		Usuario user = new Usuario(0, "Francio Xavier", "teste@gmail.com", "123");
		Admin admin = new Admin(100, "Admin", "admin@gmail.com", "123");
		usuario.addUser(user);
		usuario.addUser(admin);

		console.limpar();
		do {

			do {
				System.out.println("-----------------------------------"
						+ "\n| Bem-vindo(a) ao SaveDin Finanças |\n"
						+ "-----------------------------------");

				menu.loginMenu();
				number = input.nextInt();

				switch (number) {
					case 1: {
						userLogado = login.acessar(usuario);
						break;
					}
					case 2: {

						usuario.addUser(login.cadastro(usuario));
						break;
					}
					case 3: {
						run = false;
						break;
					}
					default:
						System.out.println("Opção invalida");
						break;
				}

			} while (!login.isLogado() && run);

			if (login.isLogado()) {
				if (userLogado.getPermissao() == 0) {
					do {

						console.limpar();
						menu.userMenu(userLogado.getPermissao());
						number = input.nextInt();

						switch (number) {
							case 1: {
								boolean sairConsulta = false;
								boolean sair = false;

								do{
									console.limpar();
									menu.menuSavedin();
									number = input.nextInt();

									switch(number){	
										case 1: {	
																				
											do {
												console.limpar();
												menu.menuConsultas();
												number = input.nextInt();
												switch(number){
													case 1: {
														do {
															console.limpar();
															System.out.println(
																"\nSeu saldo é: "+ "R$" + saldo.getSaldo() 
																+ "\n 1 - voltar");
															number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																}
																default: {
																	System.out.println("Opção invalida");
																	break;
																}
															}
														} while (!sairConsulta);
														break;
													}
													case 2: {
														sairConsulta = true;
														break;
													}
													case 3: {
														do {
															System.out.println(
															"Ganhos: " + "\n" +
															ganhos.getStringGanhos() +
															"\n 1 - voltar");
															number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																}
																default: {
																	System.out.println("Opção invalida");
																	break;
																}
															}
														} while (!sairConsulta);
														sairConsulta = false;
														break; 
													}
													case 4: {
														do {
															console.limpar();
															System.out.println(
															"Contas: " + "\n" +
															contas.getStringContas() + 
															"\n 1 - voltar");
															number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																}
																default: {
																	System.out.println("Opção invalida");
																	break;
																}
															}
														} while (!sairConsulta);
														sairConsulta = false;
														break;
													}
													case 5:{
														do {
															console.limpar();
															System.out.println(
															"Investimentos: " + "\n" +
															investimentos.getStringInvestimetos() + 
															"\n 1 - voltar");
															number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																}
																default: {
																	System.out.println("Opção invalida");
																	break;
																}
															}
														} while (!sairConsulta);
														sairConsulta=false;
														break;
													}
													case 6: {
														do {
															console.limpar();
															System.out.println(
																"Gastos: \n" +
																gastos.getGastos() +
																"\n 1 - voltar"
															);
															number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																}
																default: {
																	System.out.println("Opção invalida");
																	break;
																}
															}
														} while (!sairConsulta);
														break;
													}
													default: {
														System.out.println("Opção invalida");
														break;
													}
												}
											
											} while (!sairConsulta);
											sairConsulta = false;
											break;
										}

										case 2:{
											sair = true;
										}

										case 3:{
											console.limpar();
											menu.menuCadastro();
											number = input.nextInt();

											switch(number){
												case 1: {
													console.limpar();
													Ganho ganho = ganhoDAO.cadastro(ganhos, saldo);
													ganhos.addGanho(ganho);
													do {
														System.out.println("----------------------"
																		+ "\n| Ganho Adicionado |\n"
																		+ "----------------------"
																		+ "\n Ganho: "
																		+ "\n titulo: " 
																		+ ganho.getTitulo()
																		+ "\n Tipo: "
																		+ ganho.getTipo()
																		+ "\n Valor: "
																		+ ganho.getValor()
																		+ "\n 1-voltar");
														
														number = input.nextInt();
														switch(number){
															case 1: {
																sairConsulta = true;
																break;
															}default: {
																System.out.println("Opção invalida");
																break;
															}
														}
														
													} while (!sairConsulta);
													break;
												} case 2: {
													sair = true;
													break;
												} case 3: {
													console.limpar();
													ContaBancaria novaContaBancaria = contaBancariaDAO.cadastro(contas);
													contas.addConta(novaContaBancaria);

													do {
														System.out.println(
															"----------------------"
															+ "\n| Conta Adicionada |\n"
															+ "----------------------"
															+ "\nNome do banco: "
															+ novaContaBancaria.getNomeBanco()
															+ "\nNome do titular: "
															+ novaContaBancaria.getNomeCompleto()
															+ "\nTipo da conta: "
															+ novaContaBancaria.getTipoConta()
															+ contas.getContasInvestimento().size()
															+ "\n1-voltar");
														
														number = input.nextInt();
														switch(number){
															case 1: {
																sair = true;
																break;
															}default: {
																System.out.println("Opção invalida");
																break;
															}
														}

													} while (!sair);
													sairConsulta = false;
													break;
												} case 4: {
													if(contas.getContasInvestimento().size() == 0){
														console.limpar();
														do {
															System.out.println(
																"Nenhuma conta de investimentos cadastrada!" +
																"\n1 - voltar"
															);
															
															number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																} default:{}
															}
														} while (!sairConsulta);
														break;
													} else{
														console.limpar();
														Investimento investimento = investimentoDAO.cadastro(investimentos, contas);
														do {
															System.out.println(
																"----------------------"
																+ "\n| Investimento adicionado |\n"
																+ "----------------------"
																+ "\nConta: " 
																+ investimento.getConta().toString() 
																+"\nValor atual: " 
																+ investimento.getValor().toString() 
																+"\nData: " 
																+ investimento.getData().toString()
																+ "\n1-voltar"
															);
															
															number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																}default: {
																	System.out.println("Opção invalida");
																	break;
																}
															}
													} while (!sairConsulta);
													sairConsulta = false;
													break;
													}
												}
												case 5: {
													console.limpar();
													String parceladoOuInteiro = gastosDAO.cadastro(gastos, saldo, contas);
													
													do {
														if(parceladoOuInteiro == "Gasto inteiro"){
															GastoInteiro gasto = gastos.getGastosInteiros().get(
																gastos.getGastosInteiros().size() - 1
															);
	
															System.out.println(
																	"----------------------"
																	+ "\n| Gasto adicionado |\n"
																	+ "----------------------" +
																	"\nTitulo: " + gasto.getTitulo() +
																	"\nData: " + gasto.getData() +
																	"\nValor: " + gasto.getValor().toString() +
																	"\nFixo ou variável: " + gasto.getFixoOuVariavel()
																	+ "\n1-voltar"
															);
														} else if(parceladoOuInteiro == "Gasto parcelado"){
															GastoParcelado gasto = gastos.getGastosParcelados().get(
																gastos.getGastosParcelados().size() - 1
															);
	
															System.out.println(
																	"----------------------"
																	+ "\n| Gasto adicionado |\n"
																	+ "----------------------" +
																	"\nTitulo: " + gasto.getTitulo() +
																	"\nData: " + gasto.getData() +
																	"\nValor da parcela: " + gasto.getValorParcela().toString() +
																	"\nQuantidade de parcelas: " + gasto.getParcelas().toString() +
																	"\nValor total: " + gasto.getValor().toString() +
																	"\nTitular da Conta: " + gasto.getConta().getNomeCompleto() +
																	"\nNome do banco: " + gasto.getConta().getNomeBanco()
																	+ "\n1-voltar"
															);
														} else{
															System.out.println("Conta investimento é inválida" + "\n1-voltar");
														}

														number = input.nextInt();
															switch(number){
																case 1: {
																	sairConsulta = true;
																	break;
																}default: {
																	System.out.println("Opção invalida");
																	break;
																}
															}
													} while (!sairConsulta);
													sairConsulta = false;
												}
											}
										} case 4: {
											console.limpar();
											menu.menuProjecoes();
											number = input.nextInt();

											do {
												switch (number) {
													case 1:{
														
														break;
													} case 2: {
														
														break;
													} case 3: {
														sairConsulta = true;
														break;
													}
												
													default:{
														
														break;
													}
												}
											} while (!sairConsulta);
										}
										default: {
											System.out.println("Opção invalida");
											break;
										}
									}
								}while(!sair);
								break;
							}
							case 2: {
								boolean sairPerfil = false;
								do {
									console.limpar();
									System.out.println("---------------------"
											+ "\n| Perfil do Usuário |\n"
											+ "---------------------\n\n");

									System.out.println(""
											+ "Nome: " + userLogado.getNome()
											+ "\nEmail: " + userLogado.getEmail()
											+ "\nSenha: " + userLogado.getSenha());

									System.out.println("\n1 - Voltar");
									number = input.nextInt();

									if (number == 1) {
										sairPerfil = true;
									}
								} while (!sairPerfil);
								break;
							}
							case 3: {
								boolean sair = false;
								String mensagem = "";
								do {
									console.limpar();

									if (mensagem != "") {
										System.out.println(mensagem + "\n\n");
									}

									menu.editUserMenu();

									number = input.nextInt();

									mensagem = usuarioDAO.opcoesEditarUser(number, userLogado, usuario);

									if (mensagem == "sair")
										sair = true;

								} while (!sair);

								break;
							}
							case 4: {
								login.logout();
								console.limpar();
								break;
							}
							default: {
								System.out.println("Opção invalida");
								break;
							}
						}

					} while (login.isLogado());
				} else if (userLogado.getPermissao() == 1) {
					do {
						console.limpar();
						menu.userMenu(userLogado.getPermissao());
						number = input.nextInt();

						switch (number) {
							case 2: {
								boolean sairPerfil = false;
								do {
									console.limpar();
									System.out.println("---------------------"
											+ "\n| Perfil do Usuário |\n"
											+ "---------------------\n\n");

									System.out.println(""
											+ "Nome: " + userLogado.getNome()
											+ "\nEmail: " + userLogado.getEmail()
											+ "\nSenha: " + userLogado.getSenha());

									System.out.println("\n1 - Voltar");
									number = input.nextInt();

									if (number == 1) {
										sairPerfil = true;
									}
								} while (!sairPerfil);
								break;
							}
							case 3: {
								boolean sair = false;
								String mensagem = "";
								do {
									console.limpar();

									if (mensagem != "") {
										System.out.println(mensagem + "\n\n");
									}

									menu.editUserMenu();

									number = input.nextInt();

									mensagem = usuarioDAO.opcoesEditarUser(number, userLogado, usuario);

									if (mensagem == "sair") {
										mensagem = "";
										sair = true;
									}

								} while (!sair);

								break;
							}
							case 4: {
								boolean sair = false;
								String mensagem = "";
								do {
									console.limpar();

									if (mensagem != "") {
										System.out.println(mensagem + "\n\n");
									}

									menu.crudUser();

									number = input.nextInt();

									switch (number) {
										case 1: {
											boolean sairListaUsers = false;
											do {
												console.limpar();
												System.out.println(usuario.getAllUsers());

												System.out.println("\n1 - Voltar");
												number = input.nextInt();

												if (number == 1) {
													sairListaUsers = true;
												}
											} while (!sairListaUsers);
											break;
										}
										case 2: {
											console.limpar();
											usuario.addUser(usuarioDAO.addUser(usuario));
											mensagem = "----------------------"
													+ "\n| Usuário Adicionado |\n"
													+ "----------------------";
											break;
										}
										case 3: {
											int opcao;
											int idUser;
											String emailUser;
											Usuario userAtualizar = null;
											boolean sairAtualizarUser = false;

											do {
												do {
													console.limpar();
													System.out.println("Deseja pesquisar por email ou id?"
															+ "\n1 - Id"
															+ "\n2 - Email");
													opcao = input.nextInt();
													if (opcao == 1) {
														console.limpar();
														System.out.println("Digite o id do usuário: ");

														do {
															idUser = input.nextInt();
														} while (idUser < 0);

														if (usuario.getUserById(idUser) != null) {
															userAtualizar = usuario.getUserById(idUser);
														} else {
															console.limpar();
															System.out.println("--------------------------"
																	+ "\n| Usuário não encontrado |\n"
																	+ "--------------------------\n\n");
														}

													} else if (opcao == 2) {
														console.limpar();
														System.out.println("Digite o email do usuário: ");
														do {
															emailUser = input.nextLine();
														} while (emailUser == "");

														if (usuario.getUserByEmail(emailUser) != null) {
															userAtualizar = usuario.getUserByEmail(emailUser);
														} else {
															console.limpar();
															System.out.println("--------------------------"
																	+ "\n| Usuário não encontrado |\n"
																	+ "--------------------------\n\n");
														}
													}
												} while (opcao < 1 || opcao > 2);

												if (userAtualizar != null) {
													console.limpar();
													menu.editUserMenu();

													number = input.nextInt();

													mensagem = usuarioDAO.opcoesEditarUser(number, userAtualizar,
															usuario);

													sairAtualizarUser = true;
												} else {
													mensagem = "";

													System.out.println("Deseja tentar novamente ou sair?"
															+ "\n1 - Tentar Novamente"
															+ "\n2 - Sair");
													opcao = input.nextInt();

													if (opcao == 2)
														sairAtualizarUser = true;
												}
											} while (!sairAtualizarUser);

											break;
										}
										case 4: {
											int opcao;
											int idUser;
											String emailUser;
											Usuario userAtualizar = null;
											boolean sairRemoverUser = false;

											do {
												console.limpar();

												System.out.println("Deseja pesquisar por email ou id?"
														+ "\n1 - Id"
														+ "\n2 - Email");

												opcao = input.nextInt();

												if (opcao == 1) {
													console.limpar();
													System.out.println("Digite o id do usuário: ");

													do {
														idUser = input.nextInt();
													} while (idUser < 0);

													if (usuario.getUserById(idUser) != null) {
														userAtualizar = usuario.getUserById(idUser);
													} else {
														console.limpar();
														System.out.println("--------------------------"
																+ "\n| Usuário não encontrado |\n"
																+ "--------------------------\n\n");
													}

												} else if (opcao == 2) {
													console.limpar();
													System.out.println("Digite o email do usuário: ");
													do {
														emailUser = input.nextLine();
													} while (emailUser == "");

													if (usuario.getUserByEmail(emailUser) != null) {
														userAtualizar = usuario.getUserByEmail(emailUser);
													} else {
														console.limpar();
														System.out.println("--------------------------"
																+ "\n| Usuário não encontrado |\n"
																+ "--------------------------\n\n");
													}
												}

												if (userAtualizar != null) {
													usuario.deleteUser(userAtualizar);

													mensagem = "--------------------"
															+ "\n| Usuário Removido |\n"
															+ "--------------------";

													sairRemoverUser = true;
												} else {
													mensagem = "";

													System.out.println("Deseja tentar novamente ou sair?"
															+ "\n1 - Tentar Novamente"
															+ "\n2 - Sair");
													opcao = input.nextInt();

													if (opcao == 2)
														sairRemoverUser = true;
												}

											} while (!sairRemoverUser);
											break;
										}
										case 5: {
											sair = true;
											console.limpar();
											break;
										}
										default: {
											System.out.println("Opção invalida");
											break;
										}
									}
								} while (!sair);
								break;
							}
							case 5: {
								login.logout();
								console.limpar();
								break;
							}
						}

					} while (login.isLogado());
				}
			}

			// Finish System
			if (!run) {
				console.limpar();
				System.out.println("\n\n"
						+ "Obrigado por usar nosso sistema, volte sempre!"
						+ "");
			}

		} while (run);

		input.close();
	}
}