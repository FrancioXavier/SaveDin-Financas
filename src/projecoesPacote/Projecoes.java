package projecoesPacote;

import java.util.HashMap;
import java.util.Map;

import bancoPacote.ContaPoupanca;
import dadosPacote.Ganho;
import dadosPacote.GastoInteiro;
import dadosPacote.GastoParcelado;
import investimentoPacote.Investimento;
import repositoriosPacote.RepositorioContasBancarias;
import repositoriosPacote.RepositorioGanho;
import repositoriosPacote.RepositorioGastos;
import repositoriosPacote.RepositorioInvestimentos;

public class Projecoes {

	public Map<String, Double> projecao(
		int anos, 
		RepositorioGanho ganhos, 
		RepositorioGastos gastos,
		RepositorioInvestimentos investimentos,
		RepositorioContasBancarias contas
	){
		Double ganhoMensal = 0.0;
		Double ganhoAno = 0.0;
		Double gastoMensal = 0.0;
		Double gastoAno = 0.0;
		Double total = 0.0;

		Map<String, Double> medias = new HashMap<String, Double>();

		for(Ganho ganho : ganhos.getGanhos()){
			if(ganho.getTipo() == "fixo"){
				ganhoMensal += ganho.getValor();
				ganhoAno += ganho.getValor()*(12*anos);
				total += ganho.getValor()*(12*anos);
			}
		}

		for(GastoInteiro gasto : gastos.getGastosInteiros()){
			if(gasto.getFixoOuVariavel() == "fixo"){
				gastoMensal += gasto.getValor();
				gastoAno += (gasto.getValor()*(12*anos))/anos;
				total -= (gasto.getValor()*(12*anos));
			}
		}

		for(GastoParcelado gasto : gastos.getGastosParcelados()){
			gastoAno += gasto.getValor();
			gastoMensal += (gasto.getValor())/anos*12;
			total -= (gasto.getValor()*gasto.getParcelas())/anos*12;
		}

		for(Investimento investimento : investimentos.getInvestimentos()){
			ganhoAno += investimento.rendimento();
			total += investimento.rendimento();
		}

		for(ContaPoupanca conta : contas.getContasPoupanca()){
			ganhoAno += conta.rendimento(conta.getSaldo(), anos*12);
			total += conta.rendimento(conta.getSaldo(), anos*12);
		}

		medias.put("Ganho mensal", ganhoMensal);
		medias.put("Gasto mensal", gastoMensal);
		medias.put("Gastos anuais", gastoAno);
		medias.put("Ganho anual", ganhoAno);
		medias.put("Rendimento total", total);

		return medias;
	}
	public Map<String, Double> projecao(
		Integer meses,
		RepositorioGanho ganhos, 
		RepositorioGastos gastos,
		RepositorioInvestimentos investimentos,
		RepositorioContasBancarias contas
	){
		Map<String, Double> medias = new HashMap<String, Double>();

		Double ganhoMensal = 0.0;
		Double gastoMensal = 0.0;
		Double total = 0.0;

		for(Ganho ganho : ganhos.getGanhos()){
			if(ganho.getTipo() == "fixo"){
				ganhoMensal += ganho.getValor();
				total += ganho.getValor()*meses;
			}
		}

		for(GastoInteiro gasto : gastos.getGastosInteiros()){
			if(gasto.getFixoOuVariavel() == "fixo"){
				gastoMensal += gasto.getValor();
				total -= (gasto.getValor()*meses);
			}
		}

		for(Integer i = 1; i <= meses; i++){
			String mensagem = "Mes " + i.toString();
			Double soma = 0.0; 
			for(ContaPoupanca conta : contas.getContasPoupanca()){
				ganhoMensal += conta.rendimento(conta.getSaldo(), i);
				soma += conta.rendimento(conta.getSaldo(), i);
				
			}

			for(Investimento investimento : investimentos.getInvestimentos()){
				ganhoMensal += investimento.rendimentoMensal(i);
				soma += investimento.rendimentoMensal(i);
			}

			for(GastoParcelado gasto : gastos.getGastosParcelados()){
				gastoMensal += gasto.getValorParcela()*i;
				soma += gasto.getValorParcela()*i;
			}

			medias.put(mensagem, ganhoMensal);
			ganhoMensal -= soma;
		}

		for(GastoParcelado gasto : gastos.getGastosParcelados()){
			gastoMensal += (gasto.getValor());
			total -= (gasto.getValorParcela()*meses);
		}

		for(Investimento investimento : investimentos.getInvestimentos()){
			ganhoMensal += investimento.rendimentoMensal(meses);
			total += investimento.rendimentoMensal(meses);
		}

		for(ContaPoupanca conta : contas.getContasPoupanca()){
			ganhoMensal += conta.rendimento(conta.getSaldo(), meses);
			total += conta.rendimento(conta.getSaldo(), meses);
		}

		medias.put("Total", total);


		return medias;
	}
}
