package repositoriosPacote;

import bancoPacote.*;
import java.util.ArrayList;

public class RepositorioContasBancarias {
    ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();

    public void addConta(ContaBancaria conta){
        this.contas.add(conta);
    }

    public ArrayList<ContaBancaria> getContas(){
        return this.contas;
    }

    public String getStringContas(){
        String mensagem = "";

        for(ContaBancaria conta : this.contas){
            mensagem += "\n Nome Completo: " + conta.getNomeCompleto().toString() + 
                        "\n Cpf: " + conta.getCpf() + 
                        "\n Nome do Banco: " + conta.getNomeBanco().toString() +
                        "\n \n";
        }

        return mensagem;
    }
}
