package bancoPacote;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String nomeCompleto, String cpf, String nomeBanco, Integer id, int idUser) {
        super(nomeCompleto, cpf, nomeBanco, id, idUser);
    }

    public void transferencia(Double valor){
        
    }

    @Override
    public String getTipoConta(){
        return "Conta corrente";
    }
    
}
