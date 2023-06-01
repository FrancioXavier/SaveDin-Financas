package investimentoPacote;

import bancoPacote.ContaInvestimento;

public class CDB extends Investimento {
	private Double taxaRendimento;
	int quantMeses;

	public CDB(ContaInvestimento conta, Double valor, String data, Double taxaRendimento, int quantMeses,
			Double valorMensal) {
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
		double investimentoInicial = this.valor; // Investimento inicial
        double aporteMensal = this.valorMensal; // Aporte mensal
        double taxaDeJuros = this.taxaRendimento; // Taxa de juros anual (5%)
        int meses = this.quantMeses; // Período de investimento em meses

        double saldo = investimentoInicial;
        double aporteTotal = 0.0;
        System.out.println("Mês\tSaldo");

        for (int i = 1; i <= meses; i++) {
            saldo += aporteMensal;
            aporteTotal += aporteMensal;
            saldo *= (1 + taxaDeJuros / 12);
        }
		Double lucro = saldo - (investimentoInicial+aporteTotal);

		if (meses <= 6) {
			saldo -= lucro * 0.225;
		} else if (meses <= 12) {
			saldo -= lucro * 0.20;
		} else if (meses <= 24) {
			saldo -= lucro * 0.175;
		} else if (meses > 24) {
			saldo -= lucro * 0.15;
		}

		return saldo;
	}

	@Override
	public Double tributacoes(Double lucro, Double valor) {
		if (this.quantMeses <= 6) {
			valor -= lucro * 0.225;
		} else if (this.quantMeses <= 12) {
			valor -= lucro * 0.20;
		} else if (this.quantMeses <= 24) {
			valor -= lucro * 0.175;
		} else if (this.quantMeses > 24) {
			valor -= lucro * 0.15;
		}

		return valor;
	}

	@Override
	public Double rendimentoMensal(int meses) {
		double investimentoInicial = this.valor; // Investimento inicial
        double aporteMensal = this.valorMensal; // Aporte mensal
        double taxaDeJuros = this.taxaRendimento; // Taxa de juros anual (5%)

        double saldo = investimentoInicial;
        double aporteTotal = 0.0;

        for (int i = 1; i <= meses; i++) {
            saldo += aporteMensal;
            aporteTotal += aporteMensal;
            saldo *= (1 + taxaDeJuros / 12);
        }
		Double lucro = saldo - (investimentoInicial+aporteTotal);

		if (meses <= 6) {
			saldo -= lucro * 0.225;
		} else if (meses <= 12) {
			saldo -= lucro * 0.20;
		} else if (meses <= 24) {
			saldo -= lucro * 0.175;
		} else if (meses > 24) {
			saldo -= lucro * 0.15;
		}

		return saldo;
	}

}
