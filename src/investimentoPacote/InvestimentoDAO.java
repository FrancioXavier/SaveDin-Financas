package investimentoPacote;

import repositoriosPacote.RepositorioInvestimentos;
import repositoriosPacote.RepositorioContasBancarias;

import java.util.ArrayList;
import java.util.Scanner;

import bancoPacote.ContaInvestimento;
import dadosPacote.Verificacoes;
import dadosPacote.LimparConsole;
import dadosPacote.Usuario;

public class InvestimentoDAO {
	Verificacoes verificar = new Verificacoes();

	Scanner input = new Scanner(System.in);
	LimparConsole console = new LimparConsole();
	RepositorioInvestimentos investimentos = new RepositorioInvestimentos();

	ArrayList<Investimento> listaInvestimentos = investimentos.getInvestimentos();

	public Investimento cadastro(RepositorioInvestimentos investimentos, RepositorioContasBancarias contas, Usuario user) {
		ArrayList<ContaInvestimento> listaContas = contas.getContasInvestimento();

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
		Investimento investimento;
		boolean deuCerto = false;
		Double valorMensal;
		int idUser = user.getId();

		System.out.println(
				"------------"
						+ "\n| Cadastro |\n"
						+ "------------\n\n"
						+ "Digite o Id da conta em que fez o investimento: ");

		while (true) {
			try {
				escolha = input.nextInt();
				if (verificar.validaContaInvestimento(escolha, listaContas)) {
					break;
				}
			} catch (Exception e) {
				escolha = input.nextInt();
				if (verificar.validaContaInvestimento(escolha, listaContas)) {
					break;
				}
			}
		}

		conta = listaContas.get(escolha - 1);
		count = 0;
		escolha = 0;

		do {
			if (count < 1) {
				System.out.println("Digite a data em que iniciou o investimento: ");
			} else {
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
			}

			do {

				System.out.println("Dia: ");
				dia = input.nextInt();

				System.out.println("Mes: ");
				mes = input.nextInt();

				System.out.println("Ano: ");
				ano = input.nextInt();

			} while (dia == 0 && mes == 0 && ano == 0);
			count++;
		} while (!verificar.validaData(dia, mes, ano));
		String stringDia = dia.toString();
		String stringMes = mes.toString();
		String stringAno = ano.toString();
		String data = stringDia + "/" + stringMes + "/" + stringAno;
		count = 0;

		do {
			if (count < 1) {
				System.out.println("Digite o valor que investiu");
			} else {
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
			}

			valor = input.nextDouble();
			count++;
		} while (!verificar.validaValor(valor));
		count = 0;

		do {
			if (count < 1) {
				System.out.println("Digite o valor que planeja investir todo mes");
			} else {
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
			}

			valorMensal = input.nextDouble();
			count++;
		} while (!verificar.validaValor(valorMensal));
		count = 0;

		while (true) {
			try {
				System.out.println("Digite a taxa de rendimento: ");
				floatTaxaRendimento = input.nextFloat();
				if (verificar.validaValor(floatTaxaRendimento)) {
					break;
				}
			} catch (Exception e) {
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				floatTaxaRendimento = input.nextFloat();
				if (verificar.validaValor(floatTaxaRendimento)) {
					break;
				}
			}
		}

		taxaRendimento = floatTaxaRendimento / 100;
		Double taxaFinal = taxaRendimento;

		while (true) {
			try {
				System.out.println("Digite a quantidade de meses que planeja deixar render: ");
				quantMeses = input.nextInt();
				if (verificar.validaValor(quantMeses)) {
					break;
				}
			} catch (Exception e) {
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
				quantMeses = input.nextInt();
				if (verificar.validaValor(quantMeses)) {
					break;
				}
			}
		}

		do {
			if (count < 1) {
				System.out.println(
						"\nEscolha o tipo do seu investimento: "
								+ "\n1 - CDB"
								+ "\n2 - Tesouro prefixado");
			} else {
				System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
			}

			do {
				float valorTaxaAdm = 0;
				escolha = input.nextInt();
				int secondCount = 0;

				if (escolha == 1) {
					CDB investimentoCDB = new CDB(conta, valor, data, taxaFinal, quantMeses, valorMensal, idUser);
					investimentos.addInvestimento(investimentoCDB);
					deuCerto = true;
				} else if (escolha == 2) {
					TesouroPrefixado investimentoTesouroPrefixado = new TesouroPrefixado(conta, valor, data, taxaFinal,
							0.0, quantMeses, valorMensal, idUser);
					investimentos.addInvestimento(investimentoTesouroPrefixado);

					do {
						if (secondCount < 1) {
							System.out.println("Digite a taxa de administração do banco");
						} else {
							System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
						}

						valorTaxaAdm = input.nextInt();
						secondCount++;
					} while (valorTaxaAdm == 0 || valorTaxaAdm < 0);

					double doubleTaxaAdm = valorTaxaAdm / 100;
					taxaAdm = doubleTaxaAdm;
					investimentoTesouroPrefixado.setTaxaAdm(taxaAdm);
					deuCerto = true;
				}
			} while (escolha == 0);
		} while (!deuCerto);

		investimento = investimentos.getInvestimentos().get(investimentos.getInvestimentos().size() - 1);

		return investimento;
	}
}
