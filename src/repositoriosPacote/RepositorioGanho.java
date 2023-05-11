package repositoriosPacote;

import dadosPacote.Ganho;
import java.util.ArrayList;

public class RepositorioGanho {
    ArrayList<Ganho> ganho = new ArrayList<Ganho>();

    public void addGanho(Ganho ganho){
        this.ganho.add(ganho);
    }

    public void updateGanho(){

    }

    public ArrayList<Ganho> getGanhos(){
        return this.ganho;
    }

    public String getStringGanhos(){
        String resultado = "";

        for(Ganho uniGanho: this.ganho){
            resultado += "\n Titulo: " + uniGanho.getTitulo().toString() + 
                         "\n Valor: " + uniGanho.getValor().toString() + 
                        "\n Tipo: " + uniGanho.getTipo().toString() +
                        "\n \n";
        }
        return resultado;
    }
}
