package repositoriosPacote;

import java.util.ArrayList;

import dadosPacote.GastoInteiro;
import dadosPacote.GastoParcelado;

public class RepositorioGastos {

	ArrayList<GastoInteiro> listaGastosInteiros = new ArrayList<GastoInteiro>();
	ArrayList<GastoParcelado> listaGastosParcelados = new ArrayList<GastoParcelado>();

	public void addGastoInteiro(GastoInteiro gasto){
		listaGastosInteiros.add(gasto);
	}

	public void addGastoParcelado(GastoParcelado gasto){
		listaGastosParcelados.add(gasto);
	}

	public ArrayList<GastoInteiro> getGastosInteiros(){
		return this.listaGastosInteiros;
	}

	public ArrayList<GastoParcelado> getGastosParcelados(){
		return this.listaGastosParcelados;
	}

	public String getGastos(){
		String mensagem = "";

		mensagem += "\nGastos parcelados \n \n";

		for(GastoParcelado gasto : this.listaGastosParcelados){
			mensagem += "\nTitulo: " + gasto.getTitulo() +
						"\nData: " + gasto.getData() +
						"\nValor da parcela: " + gasto.getValorParcela().toString() +
						"\nQuantidade de parcelas: " + gasto.getParcelas().toString() +
						"\nValor total: " + gasto.getValor().toString() +
						"\nTitular da Conta: " + gasto.getConta().getNomeCompleto() +
						"\nNome do banco: " + gasto.getConta().getNomeBanco()+
						"\n \n";
		}
		mensagem += "\n \n";
		for(GastoInteiro gasto : this.listaGastosInteiros){
			mensagem += "\nTitulo: " + gasto.getTitulo() +
						"\nData: " + gasto.getData() +
						"\nValor: " + gasto.getValor().toString() +
						"\nFixo ou variável: " + gasto.getFixoOuVariavel() +
						"\n \n";
		}

		return mensagem;
	}
}