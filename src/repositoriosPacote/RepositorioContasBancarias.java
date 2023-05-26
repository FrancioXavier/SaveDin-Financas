package repositoriosPacote;

import bancoPacote.*;
import java.util.ArrayList;

public class RepositorioContasBancarias {
    private ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();
    private ArrayList<ContaInvestimento> contasInvestimento = new ArrayList<ContaInvestimento>();

    public void addConta(ContaBancaria conta){
        this.contas.add(conta);
    }

    public void addContaInvestimento(ContaInvestimento conta){
        this.contasInvestimento.add(conta);
    }

    public ArrayList<ContaBancaria> getContas(){
        return this.contas;
    }

    public ArrayList<ContaInvestimento> getContasInvestimento(){
        return this.contasInvestimento;
    }

    public String getStringContas(){
        String mensagem = "";

        for(ContaBancaria conta : this.contas){
            mensagem += "\nNome Completo: " + conta.getNomeCompleto().toString() + 
                        "\nCpf: " + conta.getCpf() + 
                        "\nNome do Banco: " + conta.getNomeBanco().toString() +
                        "\nId: " + conta.getId().toString() +
                        "\nTipo da conta: " + conta.getTipoConta() +
                        "\n \n";
        }

        return mensagem;
    }
}
