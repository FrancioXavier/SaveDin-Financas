package bancoPacote;

public abstract class ContaBancaria {
    private String nomeCompleto;
    private String cpf;
    private String nomeBanco;
    private Integer id;
    private int idUser;

    public ContaBancaria(String nomeCompleto, String cpf, String nomeBanco, Integer id, int idUser){
        this.cpf = cpf;
        this.nomeBanco = nomeBanco;
        this.nomeCompleto = nomeCompleto;
        this.id = id;
        this.idUser = idUser;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Integer getId() {
        return this.id;
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
