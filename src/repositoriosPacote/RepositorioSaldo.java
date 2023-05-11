package repositoriosPacote;

import dadosPacote.Saldo;

public class RepositorioSaldo {
    Saldo saldo = new Saldo(null);

    public void adicionaGanho(Double valor){
        this.saldo.setSaldo(valor);
    }
}
