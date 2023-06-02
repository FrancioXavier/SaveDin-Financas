package repositoriosPacote;

import dadosPacote.Ganho;
import java.util.ArrayList;

public class RepositorioGanho {
    ArrayList<Ganho> ganho = new ArrayList<Ganho>();

    public void addGanho(Ganho ganho){
        this.ganho.add(ganho);
    }

    public ArrayList<Ganho> getGanhos(){
        return this.ganho;
    }

    public String getStringGanhos(int idUser){
        String resultado = "";

        for(Ganho uniGanho: this.ganho){
            if(uniGanho.getIdUser() == idUser){
                resultado += "\n Titulo: " + uniGanho.getTitulo().toString() + 
                         "\n Valor: " + uniGanho.getValor().toString() + 
                        "\n Tipo: " + uniGanho.getTipo().toString() +
                        "\n \n";
            }
        }
        return resultado;
    }
}
