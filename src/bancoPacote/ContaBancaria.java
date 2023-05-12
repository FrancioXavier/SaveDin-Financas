package bancoPacote;

public abstract class ContaBancaria {
    private String nomeCompleto;
    private String cpf;
    private String nomeBanco;

    public ContaBancaria(String nomeCompleto, String cpf, String nomeBanco){
        this.cpf = cpf;
        this.nomeBanco = nomeBanco;
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNomeCompleto(){
        return this.nomeCompleto;
    }

    public String getNomeBanco(){
        return this.nomeBanco;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setNomeBanco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }

    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public abstract String getTipoConta();
}
