package bancoPacote;

public class ContaPoupanca extends ContaBancaria{
    public ContaPoupanca(String nomeCompleto, String cpf, String nomeBanco, Integer id) {
        super(nomeCompleto, cpf, nomeBanco, id);
    }

    @Override
    public String getTipoConta(){
        return "Conta poupança";
    }
}
