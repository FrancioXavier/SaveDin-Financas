package dadosPacote;

import java.util.Scanner;

public class SaldoDAO {
    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();


    public Saldo cadastraGanho(Saldo valor){
        Double ganho;
        System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite o valor do ganho: "
        );

        do {
            ganho = input.nextDouble();
        } while (ganho == null);

        return valor;
    }
}
