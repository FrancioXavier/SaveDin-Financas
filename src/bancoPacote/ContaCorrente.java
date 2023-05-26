package bancoPacote;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String nomeCompleto, String cpf, String nomeBanco, Integer id) {
        super(nomeCompleto, cpf, nomeBanco, id);
    }

    public void transferencia(Double valor){
        
    }

    @Override
    public String getTipoConta(){
        return "Conta corrente";
    }
    
}
