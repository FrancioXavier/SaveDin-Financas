package projecoesPacote;

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
		String mensalOuAnual
	){
		int valor;
		Map<String, Double> dados;
		System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite a quantidade de " + mensalOuAnual + ": "
        );

		while(true) {
            try {
                valor = input.nextInt();
                if(verificar.validaValor(valor)){
                    break;
                }
            } catch(Exception e){
                
                System.out.println("Valor inválido! tente novamente: ");
                valor = input.nextInt();
                if(verificar.validaValor(valor)){
                    break;
                }
            }
        }

		if(mensalOuAnual == "meses"){
			Integer meses = valor;
			dados = projecao.projecao(meses, ganhos, gastos, investimentos, contas);
			for(int i = 1; i <= valor; i++){
				System.out.println(
					"\nMes " + i + ": " + dados.get("Mes " + i) + "\n \n"
				);
			}

			System.out.println("\nTotal: " + dados.get("Total"));
		} else{
			int anos = valor;
			dados = projecao.projecao(anos, ganhos, gastos, investimentos, contas);
			System.out.println(
				"Ganho mensal: " + dados.get("Ganho mensal") +
				"Gasto mensal: " + dados.get("Gasto mensal") +
				"Gastos anuais: " + dados.get("Gastos anuais") +
				"Ganho anual: " + dados.get("Ganho anual") +
				"Rendimento total: " + dados.get("Rendimento total")
			);
		}
	}
}
