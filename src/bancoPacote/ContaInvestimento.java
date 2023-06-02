package bancoPacote;

public class ContaInvestimento extends ContaBancaria{
    public ContaInvestimento(String nomeCompleto, String cpf, String nomeBanco, Integer id, int idUser) {
        super(nomeCompleto, cpf, nomeBanco, id, idUser);
    }

    @Override
    public String getTipoConta(){
        return "Conta investimento";
    }
}
