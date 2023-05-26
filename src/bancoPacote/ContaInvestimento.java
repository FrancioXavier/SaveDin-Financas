package bancoPacote;

public class ContaInvestimento extends ContaBancaria{
    public ContaInvestimento(String nomeCompleto, String cpf, String nomeBanco, Integer id) {
        super(nomeCompleto, cpf, nomeBanco, id);
    }

    @Override
    public String getTipoConta(){
        return "Conta investimento";
    }
}
