package bancoPacote;

import repositoriosPacote.RepositorioContasBancarias;
import java.util.Scanner;

import dadosPacote.Verificacoes;
import dadosPacote.LimparConsole;
import dadosPacote.Usuario;

public class ContaBancariaDAO {
    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();
    RepositorioContasBancarias contas = new RepositorioContasBancarias();

    private static Integer idConta = 0;

    public ContaBancaria cadastro(RepositorioContasBancarias contas, Usuario user){
        String nomeCompleto;
        String cpf;
        String nomeBanco = "";
        int escolha = 0;
        int count = 0;
        boolean contaExiste;
        ContaBancaria conta;
        int idUser = user.getId();

        System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite o nome completo do titular: "
        );

        do {
            nomeCompleto = input.nextLine();
        } while (nomeCompleto == "");

        do {
            if (count < 1) {
                System.out.println("\nDigite um CPF para a conta: ");
            } else {
                System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
            }
            do {
                cpf = input.nextLine();
            } while (cpf == "");
            count++;
        } while (!verificar.isCPF(cpf));
        count = 0;

        do {
            if (count < 1) {
                System.out.println(
                    "\nEscolha o banco da sua conta: "
                    + "\n1 - Nubank"
                    + "\n2 - Inter"
                    + "\n3 - Santander"
                    + "\n4 - Bradesco"
                    + "\n5 - Banco do Brasil"
                    + "\n6 - Itaú");
            } else {
                System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
            }
            do {
                escolha = input.nextInt();

                switch(escolha){
                    case 1: {
                        nomeBanco = "Nubank";
                        break;
                    } case 2: {
                        nomeBanco = "Inter";
                        break;
                    } case 3: {
                        nomeBanco = "Santander";
                        break;
                    } case 4: {
                        nomeBanco = "Bradesco";
                        break;
                    } case 5: {
                        nomeBanco = "Banco do Brasil";
                        break;
                    } case 6: {
                        nomeBanco = "Itaú";
                        break;
                    }
                }
            } while (nomeBanco == "");
            count++;
        } while(escolha == 0);
        count = 0;
        escolha = 0;

        do {
            if (count < 1) {
                System.out.println(
                    "\nEscolha o tipo da sua conta: "
                    + "\n1 - Corrente"
                    + "\n2 - Investimento"
                    + "\n3 - Poupanca");
            } else {
                System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
            }

            do {
                escolha = input.nextInt();
                if(escolha == 1){
                    contaExiste = true;  
                } else if(escolha == 2){
                    contaExiste = true;
                } else if(escolha == 3){
                    contaExiste = true;
                }else {
                    contaExiste = false;
                }
            } while (!contaExiste);
            count++;
        } while (escolha == 0);
        count = 0;
        
        idConta += 1;
        if(escolha == 1){
            conta = new ContaCorrente(nomeCompleto, cpf, nomeBanco, idConta, idUser);
        } else if(escolha == 2){
            ContaInvestimento contaInvestimento = new ContaInvestimento(nomeCompleto, cpf, nomeBanco, idConta, idUser);
            contas.addContaInvestimento(contaInvestimento);
            return contaInvestimento;
        } else if(escolha == 3){
            Double valor;
            while(true) {
                try {
                    System.out.println("Digite o valor que irá depositar: ");
                    valor = input.nextDouble();
                    if(verificar.validaValor(valor)){
                        break;
                    }
                } catch(Exception e){
                    
                    System.out.println("Valor inválido! tente novamente: ");
                    valor = input.nextDouble();
                    if(verificar.validaValor(valor)){
                        break;
                    }
                }
            }
            conta = new ContaPoupanca(nomeCompleto, cpf, nomeBanco, idConta, valor, idUser);
        }else {
            conta = new ContaCorrente(nomeCompleto, cpf, nomeBanco, idConta, idUser);
        }

        return conta;
    }

    public void deletar(RepositorioContasBancarias contas, Usuario user){
        int escolha;
        System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite o id da conta: "
        );

        while (true) {
			try {
				escolha = input.nextInt();
				if (verificar.validaContaBancaria(escolha, contas.getContas())) {
					break;
				}
			} catch (Exception e) {
				escolha = input.nextInt();
				if (verificar.validaContaBancaria(escolha, contas.getContas())) {
					break;
				}
			}
		}

        for(ContaBancaria conta: contas.getContas()){
            if(conta.getIdUser() == user.getId()){
                if(conta.getId() == escolha){
                    contas.getContas().remove(conta);
                    break;
                }
            }
        }
    }
}
