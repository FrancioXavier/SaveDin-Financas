package dadosPacote;

import java.util.Scanner;

import repositoriosPacote.RepositorioGanho;

public class GanhoDAO {
    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();

    public Ganho cadastro(RepositorioGanho ganhos, Saldo saldo, Usuario user){
        Double valor = -1.0;
        int count = 0;
        int valorTipo;
        String tipo = "";
        String titulo;
        int idUser = user.getId();
        int idGanho = 0;
        
        System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite o valor do ganho: "
        );

        
        while(true) {
            try {
                valor = input.nextDouble();
                if(verificar.validaValor(valor)){
                    break;
                }
            } catch(Exception e){
                
                System.out.println("Valor inválido! tente novamente: ");
                valor = input.nextDouble();
                if(verificar.validaValor(valor)){
                    break;
                }
            }
        }
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
                System.out.println("\nEscolha o tipo de ganho: " 
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
        idGanho += 1;

        Ganho ganho = new Ganho(valor, tipo, titulo, idUser, idGanho);
        return ganho;
    }

    public void deletar(RepositorioGanho ganhos, Usuario user, Saldo saldo){
        int escolha;
        System.out.println(
            "------------"
            + "\n| Cadastro |\n"
            + "------------\n\n"
            + "Digite o id do ganho: "
        );

        while (true) {
			try {
				escolha = input.nextInt();
				if (verificar.validaGanho(escolha, ganhos.getGanhos(), user.getId())) {
					break;
				}
			} catch (Exception e) {
				escolha = input.nextInt();
				if (verificar.validaGanho(escolha, ganhos.getGanhos(), user.getId())) {
					break;
				}
			}
		}
        
        for(Ganho ganho: ganhos.getGanhos()){
            if(ganho.getIdUser() == user.getId()){
                if(ganho.getId() == escolha){
                    saldo.subtractSaldo(ganho.getValor());
                    ganhos.getGanhos().remove(ganho);
                    break;
                }
            }
        }
    }
}
