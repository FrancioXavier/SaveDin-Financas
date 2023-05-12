package bancoPacote;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String nomeCompleto, String cpf, String nomeBanco) {
        super(nomeCompleto, cpf, nomeBanco);
    }

    public void transferencia(Double valor){
        
    }

    @Override
    public String getTipoConta(){
        return "Conta corrente";
    }
    
}
