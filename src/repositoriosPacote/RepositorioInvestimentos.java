package repositoriosPacote;

import investimentoPacote.*;
import java.util.ArrayList;

public class RepositorioInvestimentos {
	ArrayList<Investimento> investimentos = new ArrayList<Investimento>();

	public void addInvestimento(Investimento investimento){
		this.investimentos.add(investimento);
	}

	public ArrayList<Investimento> getInvestimentos(){
		return this.investimentos;
	}

	public String getStringInvestimetos(){
		String mensagem = "";

		for(Investimento investimento : this.investimentos){
			mensagem =  "Conta: " + investimento.getConta().toString() + 
						"Valor atual: " + investimento.getValor().toString() + 
					    "Data: " + investimento.getData().toString();
		}

		return mensagem;
	}
}
