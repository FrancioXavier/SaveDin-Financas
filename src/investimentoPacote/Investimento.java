package investimentoPacote;

import bancoPacote.ContaInvestimento;

public abstract class Investimento {
    private ContaInvestimento conta;
    protected Double valor;
    protected Double valorMensal;
    private String data;
    private int idUser;
    private int id;

    public Investimento(ContaInvestimento conta, Double valor, String data, Double valorMensal, int idUser, int id){
        this.conta = conta;
        this.valor = valor;
        this.data = data;
        this.valorMensal = valorMensal;
        this.idUser = idUser;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
