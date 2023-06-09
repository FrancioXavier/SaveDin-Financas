package dadosPacote;

import java.util.ArrayList;
import java.util.InputMismatchException;

import bancoPacote.ContaBancaria;
import bancoPacote.ContaInvestimento;
import investimentoPacote.Investimento;
import repositoriosPacote.*;

public class Verificacoes {
    public boolean isEmail(RepositorioUser usuarios, String email) {

        ArrayList<Usuario> users = usuarios.getArrayUser();

        for (Usuario u : users) {
            if (email.equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarSenha(RepositorioUser usuarios, String senha) {
        ArrayList<Usuario> users = usuarios.getArrayUser();

        for (Usuario u : users) {
            if (senha.equals(u.getSenha())) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaTitulo(String titulo) {
        if (titulo.length() < 3) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return (true);
            else
                return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    public boolean validaData(Integer dia, Integer mes, Integer ano) {
        if (dia < 1 || dia > 31) {
            return false;
        } else if (mes > 12 || mes < 1) {
            return false;
        } else if (ano < 0 || ano > 2023) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaValor(Double valor) throws IllegalArgumentException {
        try {
            if (valor < 0) {
                throw new IllegalArgumentException("Valor inválido");
            } else {
                return true;
            }
        } catch (InputMismatchException e) {
            return false;
        }
    }

    public boolean validaValor(int valor) throws IllegalArgumentException {
        try {
            if (valor < 0) {
                throw new IllegalArgumentException("Valor inválido");
            } else {
                return true;
            }
        } catch (InputMismatchException e) {
            return false;
        }
    }

    public boolean validaValor(float valor) throws IllegalArgumentException {
        try {
            if (valor < 0) {
                throw new IllegalArgumentException("Valor inválido");
            } else {
                return true;
            }
        } catch (InputMismatchException e) {
            return false;
        }
    }

    public boolean validaContaInvestimento(Integer id, ArrayList<ContaInvestimento> contas) throws IllegalArgumentException{
        for(ContaInvestimento conta : contas){
            if(id == conta.getId()){
                return true;
            }
        }
        throw new IllegalArgumentException("Conta não existe, tente novamente: ");
    }

    public boolean validaContaBancaria(Integer id, ArrayList<ContaBancaria> contas){
        for(ContaBancaria conta : contas){
            
            if(id == conta.getId()){
                return true;
            }
        }

        return false;
        
    }

    public boolean validaGanho(Integer id, ArrayList<Ganho> ganhos, int userId) throws IllegalArgumentException{
        for(Ganho ganho : ganhos){
            if(ganho.getIdUser() == userId){
                if(id == ganho.getId()){
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("Ganho não existe, tente novamente: ");
    }

    public boolean validaGasto(Integer id, RepositorioGastos gastos, int userId) throws IllegalArgumentException{
        for(GastoParcelado gasto : gastos.getGastosParcelados()){
            if(gasto.getIdUser() == userId){
                if(id == gasto.getId()){
                    return true;
                }
            }
        }

        for(GastoInteiro gasto : gastos.getGastosInteiros()){
            if(gasto.getIdUser() == userId){
                if(id == gasto.getId()){
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("Gasto não existe, tente novamente: ");
    }

    public boolean validaInvestimento(Integer id, RepositorioInvestimentos investimentos, int userId) throws IllegalArgumentException{
        for(Investimento investimento : investimentos.getInvestimentos()){
            if(investimento.getIdUser() == userId){
                if(id == investimento.getId()){
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("Investimento não existe, tente novamente: ");
    }

}
