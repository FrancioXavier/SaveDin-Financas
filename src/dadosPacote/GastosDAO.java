package dadosPacote;

import java.util.Scanner;

import bancoPacote.ContaBancaria;
import repositoriosPacote.RepositorioContasBancarias;
import repositoriosPacote.RepositorioGastos;

public class GastosDAO {

	Verificacoes verificar = new Verificacoes();
    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();
	RepositorioGastos gastos = new RepositorioGastos();

	public String cadastro(RepositorioGastos gastos, Saldo saldo, RepositorioContasBancarias contas, Usuario user){
		int escolhaGasto = 0;
		int count = 0;
		boolean valeu = false;
		String titulo;
		Integer dia, mes, ano;
		int parcelas;
		Double valorParcela;
		String tipo = "";
		Double valor;
		int idUser = user.getId();
		int idGasto = 0;

		System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite 1 se for parcelado, 2 para gasto total: "
        );

		do {
			if(count == 0){
				escolhaGasto = input.nextInt();
				if(escolhaGasto == 1 || escolhaGasto == 2){valeu = true;}
			} else{
				System.out.println("Escolheaa inválida! Digite novamente: ");
				escolhaGasto = input.nextInt();
				if(escolhaGasto == 1 || escolhaGasto == 2){valeu = true;}	
			}
			count++;
		} while(!valeu);
		count = 0;

		if(escolhaGasto == 1){
			do {
				if (count < 1) {
					System.out.println("\nDigite um titulo para caracterizar seu gasto: ");
				} else {
					System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				}
				do {
					titulo = input.nextLine();
				} while (titulo == "");
				count++;
			} while (!verificar.verificaTitulo(titulo));
			count = 0;

			do {
				if(count < 1){
					System.out.println("Digite a data em que iniciou o investimento: ");
				} else {
					System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				}
	
				do{
	
					System.out.println("Dia: ");
					dia = input.nextInt();
	
					System.out.println("Mes: ");
					mes = input.nextInt();
	
					System.out.println("Ano: ");
					ano = input.nextInt();
	
				} while(dia == 0 && mes == 0 && ano == 0);
				count++;
			} while(!verificar.validaData(dia, mes, ano));
			String stringDia = dia.toString();
			String stringMes = mes.toString();
			String stringAno = ano.toString();
			String data = stringDia + "/" + stringMes + "/" + stringAno;
			count = 0;
			int escolha = 0;

			do {
				if(count == 0){
					System.out.println("Digite o ID da conta bancária cadastrada");
					escolha = input.nextInt();
					if(verificar.validaContaBancaria(escolha, contas.getContas())){
						if(contas.getContas().get(escolha - 1).getTipoConta() == "Conta investimento"){
							valeu = false;
							return "";
						} else {
							valeu = true;
						}	
					} else {
						valeu = false;
					}
				} else{
					System.out.println("Escolha inválida! Digite novamente: ");
					escolha = input.nextInt();
					if(verificar.validaContaBancaria(escolha, contas.getContas())){
						if(contas.getContas().get(escolha).getTipoConta() == "Conta investimento"){
							valeu = false;
							System.out.println("Conta investimento é inválida");
							return "";
						} else {
							valeu = true;
						}	
					} else {
						valeu = false;
					}
				}
				count++;
			} while (!valeu);
			ContaBancaria conta = contas.getContas().get(escolha - 1);
			count = 0;
			escolha = 0;
			valeu = false;

			while(true){
				try {
					System.out.println("Digite a quantidade de parcelas: ");
					parcelas = input.nextInt();
					if(!verificar.validaValor(parcelas)){
						break;
					}
				} catch (Exception e) {
					System.out.println("Não foi possível cadastrar, tente outra vez: ");
					parcelas = input.nextInt();
					if(!verificar.validaValor(parcelas)){
						break;
					}
				}
			}
			
			do{
				if(count < 1){
					System.out.println("Digite o valor da parcela: ");
				} else{
					System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				}
	
				valorParcela = input.nextDouble();
				count++;	
			}while(!verificar.validaValor(valorParcela));
			count = 0;
			idGasto += 1;
			
			GastoParcelado novoGasto = new GastoParcelado(data, titulo, conta, parcelas, valorParcela, idUser, idGasto);
			gastos.addGastoParcelado(novoGasto);
			saldo.subtractSaldo(valorParcela);
			return novoGasto.getTipoGasto();

		} else{
			do {
				if (count < 1) {
					System.out.println("\nDigite um titulo para caracterizar seu gasto: ");
				} else {
					System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				}
				do {
					titulo = input.nextLine();
				} while (titulo == "");
				count++;
			} while (!verificar.verificaTitulo(titulo));
			count = 0;

			do {
				if(count < 1){
					System.out.println("Digite a data em que iniciou o investimento: ");
				} else {
					System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				}
	
				do{
	
					System.out.println("Dia: ");
					dia = input.nextInt();
	
					System.out.println("Mes: ");
					mes = input.nextInt();
	
					System.out.println("Ano: ");
					ano = input.nextInt();
	
				} while(dia == 0 && mes == 0 && ano == 0);
				count++;
			} while(!verificar.validaData(dia, mes, ano));
			String stringDia = dia.toString();
			String stringMes = mes.toString();
			String stringAno = ano.toString();
			String data = stringDia + "/" + stringMes + "/" + stringAno;
			count = 0;

			do {
				if (count < 1) {
					System.out.println("\nEscolha o tipo de gasto: " 
										+ "\n1 - Fixo" + "\n2 - Variavel");
				} else {
					System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				}
				do {
					int valorTipo = input.nextInt();
	
					if(valorTipo == 1){
						tipo = "fixo";
						break;
					} else if(valorTipo == 2){
						tipo = "variavel";
						break;
					}
				} while (tipo != "fixo" || tipo != "variavel");
				count++;
			} while (tipo == "");
			count = 0;

			do{
				if(count < 1){
					System.out.println("Digite o valor do gasto: ");
				} else{
					System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				}
	
				valor = input.nextDouble();
				count++;	
			}while(!verificar.validaValor(valor));
			count = 0;
			idGasto += 1;

			GastoInteiro novoGasto = new GastoInteiro(tipo, titulo, valor, data, idUser, idGasto);
			gastos.addGastoInteiro(novoGasto);
			saldo.subtractSaldo(valor);
			return novoGasto.getTipoGasto();
		}
	}

	public void deletar(RepositorioGastos gastos, Usuario user){
		int escolha;
        System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite o id do gasto: "
        );

        while (true) {
			try {
				escolha = input.nextInt();
				if (verificar.validaGasto(escolha, gastos, user.getId())) {
					break;
				}
			} catch (Exception e) {
				escolha = input.nextInt();
				if (verificar.validaGasto(escolha, gastos, user.getId())) {
					break;
				}
			}
		}
        
        for(GastoInteiro gasto: gastos.getGastosInteiros()){
            if(gasto.getIdUser() == user.getId()){
                if(gasto.getId() == escolha){
                    gastos.getGastosInteiros().remove(gasto);
					break;
                }
            }
        }

		for(GastoParcelado gasto: gastos.getGastosParcelados()){
            if(gasto.getIdUser() == user.getId()){
                if(gasto.getId() == escolha){
                    gastos.getGastosParcelados ().remove(gasto);
					break;
                }
            }
        }
	}

}
