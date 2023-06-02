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

	public String getStringInvestimetos(int idUser){
		String mensagem = "";

		for(Investimento investimento : this.investimentos){
			if(investimento.getIdUser() == idUser){
				mensagem =  "\nTitular da conta: " + investimento.getConta().getNomeCompleto().toString() +
							"\nBanco: " + investimento.getConta().getNomeBanco() +  
							"\nValor atual: " + investimento.getValor().toString() + 
							"\nData: " + investimento.getData();
			}
		}

		return mensagem;
	}
}
