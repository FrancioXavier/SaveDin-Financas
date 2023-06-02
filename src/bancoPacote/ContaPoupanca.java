package bancoPacote;

public class ContaPoupanca extends ContaBancaria{
    private Double saldo;
    public ContaPoupanca(String nomeCompleto, String cpf, String nomeBanco, Integer id, Double saldo, int idUser) {
        super(nomeCompleto, cpf, nomeBanco, id, idUser);
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double rendimento(Double saldo, int meses){
        Double valor;
        valor = this.getSaldo()*Math.pow((1+0.58), meses);
        Double lucro = valor - saldo;

        if(valor >= 40000){
            valor -= this.tributacoes(lucro, valor, meses);
        }

        return valor;
    }

    public Double tributacoes(Double lucro, Double valor, int meses){
		if(meses <= 6){
			valor -= lucro * 0.225;
		} else if(meses <= 12){
			valor -= lucro * 0.20;
		} else if(meses <= 24){
			valor -= lucro * 0.175;
		} else if(meses > 24){
			valor -= lucro * 0.15;
		}

		return valor;
	}

    @Override
    public String getTipoConta(){
        return "Conta poupança";
    }
}
