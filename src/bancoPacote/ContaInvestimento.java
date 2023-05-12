package bancoPacote;

public class ContaInvestimento extends ContaBancaria{
    public ContaInvestimento(String nomeCompleto, String cpf, String nomeBanco) {
        super(nomeCompleto, cpf, nomeBanco);
    }

    @Override
    public String getTipoConta(){
        return "Conta investimento";
    }
}
