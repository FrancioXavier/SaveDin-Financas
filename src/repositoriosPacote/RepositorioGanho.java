package repositoriosPacote;

import dadosPacote.Ganho;
import java.util.ArrayList;

public class RepositorioGanho {
    private ArrayList<Ganho> ganho = new ArrayList<Ganho>();

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
                resultado += "\nTitulo: " + uniGanho.getTitulo().toString() + 
                         "\nValor: " + uniGanho.getValor().toString() + 
                        "\nTipo: " + uniGanho.getTipo().toString() +
                        "\nId do gasto:" + uniGanho.getId() +
                        "\n \n";
            }
        }
        return resultado;
    }
}
