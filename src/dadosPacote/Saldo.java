package dadosPacote;

public class Saldo {
    private Double valor;
    private int idUser;

    public Saldo(Double valor){
        this.valor = valor;
    }

    public Double getSaldo(){
        return this.valor;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setSaldo(Double valor){
        this.valor += valor;
    }

    public void subtractSaldo(Double valor){
        this.valor -= valor;
    }
}
