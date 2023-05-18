package investimentoPacote;

import repositoriosPacote.RepositorioInvestimentos;
import repositoriosPacote.RepositorioContasBancarias;

import java.util.ArrayList;
import java.util.Scanner;

import bancoPacote.ContaInvestimento;
import dadosPacote.Verificacoes;
import dadosPacote.LimparConsole;

public class InvestimentoDAO {
	Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();
	RepositorioInvestimentos investimentos = new RepositorioInvestimentos();
	RepositorioContasBancarias contas = new RepositorioContasBancarias();
	ArrayList<ContaInvestimento> listaContas = contas.getContasInvestimento();
	ArrayList<Investimento> listaInvestimentos = investimentos.getInvestimentos();

	public Investimento cadastro(RepositorioInvestimentos investimentos){
		Double valor;
		Integer dia = 0;
		Integer mes = 0;
		Integer ano = 0;
		int quantMeses;
		float floatTaxaRendimento;
		double taxaRendimento;
		Double taxaAdm = 0.0;
		ContaInvestimento conta;
		int count = 0;
		int escolha;
		int numConta = 1;
		Investimento investimento;
		boolean deuCerto = false;
		int contaEscolhida = 0;

		System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Escolha a conta em que fez o investimento: "
        );

		
		do {
            if (count < 1) {
                for(ContaInvestimento contaUnidade : listaContas){
		
					System.out.println(
						count + " - \n" + 
						"CPF" + contaUnidade.getCpf().toString() +
						"Banco" + contaUnidade.getNomeBanco().toString()
					);
					numConta++;
				}
            } else {
                System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
            }
            do {
                escolha = input.nextInt();
				for(int i = 1; i <= numConta; i++){
					if(i == escolha){
						contaEscolhida = i;
					}
				}
            
            } while (escolha > numConta || escolha < numConta);
            count++;
        } while(escolha == 0);
		conta = listaContas.get(contaEscolhida-1);
        count = 0;
        escolha = 0;

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
		} while (!verificar.validaData(dia, mes, ano));
		String stringDia = dia.toString();
		String stringMes = mes.toString();
		String stringAno = ano.toString();
		String data = stringDia + "/" + stringMes + "/" + stringAno;
		count = 0;

		do{
			if(count < 1){
				System.out.println("Digite o valor que investiu");
			} else{
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
			}

			valor = input.nextDouble();
			count++;
		}while(!verificar.validaValor(valor));
		count = 0;

		do{
			if(count < 1){
				System.out.println("Digite a taxa de rendimento: ");
			} else{
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
			}

			floatTaxaRendimento = input.nextFloat();
			System.out.println("%");
		}while(!verificar.validaTaxa(floatTaxaRendimento));
		taxaRendimento = floatTaxaRendimento / 100;
		Double taxaFinal = taxaRendimento;

		do{
			if(count < 1){
				System.out.println("Digite a quantidade de meses que planeja deixar render: ");
			} else{
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
			}

			quantMeses = input.nextInt();	
		}while(!verificar.validaTaxa(quantMeses));

		do {
            if (count < 1) {
                System.out.println(
                    "\nEscolha o tipo do seu investimento: "
                    + "\n1 - CDB"
                    + "\n2 - Tesouro prefixado"
				);
            } else {
                System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
            }

			do {
				float valorTaxaAdm = 0;
				escolha = input.nextInt();
				int secondCount = 0;

				if(escolha == 1){
					CDB investimentoCDB = new CDB(conta, valor, data, taxaFinal, quantMeses);
					investimentos.addInvestimento(investimentoCDB);
					deuCerto = true;
				} else if(escolha == 2){
					TesouroPrefixado investimentoTesouroPrefixado = new TesouroPrefixado(conta, valor, data, taxaFinal, 0.0, quantMeses);
					investimentos.addInvestimento(investimentoTesouroPrefixado);

					do {
						if(secondCount < 1){
							System.out.println("Digite a taxa de administração do banco");
						} else {
							System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
						}

						valorTaxaAdm = input.nextInt();
						System.out.println("%");
						secondCount++;
					} while (valorTaxaAdm == 0 || valorTaxaAdm < 0);

					double doubleTaxaAdm = valorTaxaAdm / 100;
					taxaAdm = doubleTaxaAdm;
					investimentoTesouroPrefixado.setTaxaAdm(taxaAdm);
					deuCerto = true;
				}
			} while (escolha != 1 || escolha != 2);
		}while(!deuCerto);

		investimento = listaInvestimentos.get(listaInvestimentos.size() - 1);

		return investimento;
	}
}
