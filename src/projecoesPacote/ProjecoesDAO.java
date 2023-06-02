package projecoesPacote;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import dadosPacote.LimparConsole;
import dadosPacote.Verificacoes;
import repositoriosPacote.RepositorioContasBancarias;
import repositoriosPacote.RepositorioGanho;
import repositoriosPacote.RepositorioGastos;
import repositoriosPacote.RepositorioInvestimentos;


public class ProjecoesDAO {

	Verificacoes verificar = new Verificacoes();

	Scanner input = new Scanner(System.in);
	LimparConsole console = new LimparConsole();
	Projecoes projecao = new Projecoes(); 

	public void cadastro(
		RepositorioContasBancarias contas,
		RepositorioGanho ganhos,
		RepositorioGastos gastos,
		RepositorioInvestimentos investimentos,
		String mensalOuAnual,
		int idUser
	){
		int valor;
		Map<String, Double> dados;
		System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite a quantidade de " + mensalOuAnual + ": "
        );

		while(true){
			try {
				System.out.print("Digite um número inteiro: ");
				valor = input.nextInt();
				if(verificar.validaValor(valor)){
					break;
				}
				System.out.println("O número digitado foi: " + valor);
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
				valor = input.nextInt();
				if(verificar.validaValor(valor)){
					break;
				}
			}
		};
		

		if(mensalOuAnual == "meses"){
			Integer meses = valor;
			dados = projecao.projecao(meses, ganhos, gastos, investimentos, contas, idUser);
			for(int i = 1; i <= valor; i++){
				System.out.println(
					"\nMes " + i + ": " + dados.get("Mes " + i) + "\n"
				);
			}

			System.out.println("\nTotal: " + dados.get("Total"));
		} else{
			int anos = valor;
			dados = projecao.projecao(anos, ganhos, gastos, investimentos, contas, idUser);
			System.out.println(
				"\nGanho mensal: " + dados.get("Ganho mensal") +
				"\nGasto mensal: " + dados.get("Gasto mensal") +
				"\nRendimento mensal" + dados.get("Rendimento mensal") +
				"\nGastos anuais: " + dados.get("Gastos anuais") +
				"\nGanho anual: " + dados.get("Ganho anual") +
				"\nRendimento total: " + dados.get("Rendimento total")+
				"\n\n"
			);
		}
	}
}
