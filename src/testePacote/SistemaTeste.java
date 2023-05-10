package testePacote;

import dadosPacote.*;
import repositoriosPacote.*;

import java.util.Scanner;

public class SistemaTeste {
	public static void main(String[] args) {

		// Classes
		Saldo saldo = new Saldo(0.0);
		Menus menu = new Menus();
		Login login = new Login();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		LimparConsole console = new LimparConsole();

		// Repositorios
		RepositorioUser usuario = new RepositorioUser();

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
								boolean sair = false;

								do{
									console.limpar();
									menu.menuSavedin();
									number = input.nextInt();

									switch(number){	
										case 1: {	
											boolean sairConsulta = false;									
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
													default: {
														System.out.println("Opção invalida");
														break;
													}
												}
											
											} while (!sairConsulta);
											break;
										}

										case 2:{
											sair = true;
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