package investimentoPacote;

import bancoPacote.ContaInvestimento;
import java.lang.Math;

public class CDB extends Investimento{
	private Double taxaRendimento;
	int quantMeses;

	public CDB(ContaInvestimento conta, Double valor, String data, Double taxaRendimento, int quantMeses, Double valorMensal) {
		super(conta, valor, data, valorMensal);
		this.taxaRendimento = taxaRendimento;
		this.quantMeses = quantMeses;
	}

	public Double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(Double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public void setQuantMeses(int quantMeses) {
		this.quantMeses = quantMeses;
	}

	public int getQuantMeses() {
		return quantMeses;
	}

	@Override
	public Double rendimento() {
		double taxa = 1 + this.taxaRendimento;
		Double valorRendimento = this.valor * Math.pow(taxa, this.quantMeses);
		Double lucro = valorRendimento - this.valor;

		Double valorFInal = tributacoes(lucro, valorRendimento);

		return valorFInal;
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

	@Override
	public Double rendimentoMensal(int meses) {
		double taxa = 1 + this.taxaRendimento;
		Double valorRendimento = this.valor * Math.pow(taxa, meses);
		Double lucro = valorRendimento - this.valor;

		Double valorFInal = tributacoes(lucro, valorRendimento);

		return valorFInal;
	}

}
