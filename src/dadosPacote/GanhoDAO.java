package dadosPacote;

import java.util.Scanner;

import repositoriosPacote.RepositorioGanho;

public class GanhoDAO {
    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();
    RepositorioGanho ganhos = new RepositorioGanho();

    public Ganho cadastro(RepositorioGanho ganhos, Saldo saldo){
        Double valor;
        int count = 0;
        int valorTipo;
        String tipo = "";
        String titulo;
        
        System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite o valor do ganho: "
        );

        do {
            valor = input.nextDouble();
        } while(valor == null);
        saldo.setSaldo(valor);

        do {
            if (count < 1) {
                System.out.println("\nDigite um titulo para caracterizar seu ganho: ");
            } else {
                System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
            }
            do {
                titulo = input.nextLine();
            } while (titulo == "");
            count++;
        } while (!verificar.verificaTitulo(titulo));
        count = 0;

        do {
            if (count < 1) {
                System.out.println("\nEscolha o tipo de gasto: " 
                                    + "\n1 - Fixo" + "\n2 - Variavel");
            } else {
                System.out.println("\nNão foi possível cadastrar, tente outra vez: ");
            }
            do {
                valorTipo = input.nextInt();

                if(valorTipo == 1){
                    System.out.println("teste");
                    System.out.println(count);
                    tipo = "fixo";
                    break;
                } else if(valorTipo == 2){
                    tipo = "variavel";
                    break;
                }
            } while (tipo != "fixo" || tipo != "variavel");
            System.out.println(count);
            count++;
        } while (tipo == "");
        count = 0;


        Ganho ganho = new Ganho(valor, tipo, titulo);
        return ganho;
    }
}
