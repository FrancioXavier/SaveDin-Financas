package repositoriosPacote;

import java.util.HashMap;
import java.util.Map;

import dadosPacote.Saldo;

public class RepositorioSaldos {
    Map<Integer, Saldo> saldos = new HashMap<Integer, Saldo>();

    public void addSaldo(int idUser, Saldo saldo){
        saldos.put(idUser, saldo);
    }

    public Saldo getSaldo(int idUser){
        return saldos.get(idUser);
    }
}
