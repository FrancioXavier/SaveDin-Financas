package bancoPacote;

public class ContaPoupanca extends ContaBancaria{
    public ContaPoupanca(String nomeCompleto, String cpf, String nomeBanco) {
        super(nomeCompleto, cpf, nomeBanco);
    }

    @Override
    public String getTipoConta(){
        return "Conta poupança";
    }
}
