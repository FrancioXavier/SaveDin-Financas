package repositoriosPacote;

import bancoPacote.*;
import java.util.ArrayList;

public class RepositorioContasBancarias {
    private ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();
    private ArrayList<ContaInvestimento> contasInvestimento = new ArrayList<ContaInvestimento>();
    private ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<ContaPoupanca>();

    public void addConta(ContaBancaria conta){
        this.contas.add(conta);
    }

    public void addContaInvestimento(ContaInvestimento conta){
        this.contasInvestimento.add(conta);
    }

    public void addContaPoupanca(ContaPoupanca conta){
        this.contasPoupanca.add(conta);
    }

    public ArrayList<ContaBancaria> getContas(){
        return this.contas;
    }

    public ArrayList<ContaPoupanca> getContasPoupanca(){
        return this.contasPoupanca;
    }

    public ArrayList<ContaInvestimento> getContasInvestimento(){
        return this.contasInvestimento;
    }

    public String getStringContas(int idUser){
        String mensagem = "";

        for(ContaBancaria conta : this.contas){
            if(conta.getIdUser() == idUser){
                mensagem += "\nNome Completo: " + conta.getNomeCompleto().toString() + 
                        "\nCpf: " + conta.getCpf() + 
                        "\nNome do Banco: " + conta.getNomeBanco().toString() +
                        "\nId: " + conta.getId().toString() +
                        "\nTipo da conta: " + conta.getTipoConta() +
                        "\n \n";
            }
        }

        return mensagem;
    }
}
