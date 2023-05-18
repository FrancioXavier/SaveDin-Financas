package investimentoPacote;

import bancoPacote.ContaInvestimento;
import java.lang.Math;

public class CDB extends Investimento{
	private Double taxaRendimento;
	int quantMeses;

	public CDB(ContaInvestimento conta, Double valor, String data, Double taxaRendimento, int quantMeses) {
		super(conta, valor, data);
		this.taxaRendimento = taxaRendimento;
		this.quantMeses = quantMeses;
	}

	public Double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(Double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	@Override
	public Double rendimento() {
		Double montante;
		double taxa = 1 + this.taxaRendimento;

		montante = this.valor * Math.pow(taxa, quantMeses);

		return montante;
	}

	@Override
	public Double tributacoes(Double lucro, Double valor){
		if(this.quantMeses <= 6){
			valor -= lucro * 0.225;
		} else if(this.quantMeses <= 12){
			valor -= lucro * 0.20;
		} else if(this.quantMeses <= 24){
			valor -= lucro * 0.175;
		} else if(this.quantMeses > 24){
			valor -= lucro * 0.15;
		}

		return valor;
	}

}
