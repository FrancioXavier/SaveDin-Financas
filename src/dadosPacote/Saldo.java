package dadosPacote;

public class Saldo {
    private Double valor;

    public Saldo(Double valor){
        this.valor = valor;
    }

    public Double getSaldo(){
        return this.valor;
    }

    public void setSaldo(Double valor){
        this.valor += valor;
    }

    public void subtractSaldo(Double valor){
        this.valor -= valor;
    }
}
