package investimentoPacote;

import bancoPacote.ContaInvestimento;

public abstract class Investimento {
    private ContaInvestimento conta;
    Double valor;
    Double valorMensal;
    private String data;

    public Investimento(ContaInvestimento conta, Double valor, String data, Double valorMensal){
        this.conta = conta;
        this.valor = valor;
        this.data = data;
        this.valorMensal = valorMensal;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public ContaInvestimento getConta(){
        return this.conta;
    }

    public Double getValor(){
        return this.valor;
    }

    public String getData(){
        return this.data;
    }

    public void setConta(ContaInvestimento conta){
        this.conta = conta;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public void setData(String dia, String mes, String ano){
        String data = dia + "/" + mes + "/" + ano;

        this.data = data;
    }

    public abstract Double rendimento();
    public abstract Double tributacoes(Double lucro, Double valor);
    public abstract Double rendimentoMensal(int meses);
}
