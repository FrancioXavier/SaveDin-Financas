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

        System.out.println("Ganhos: ");
        for(Ganho uniGanho: this.ganho){
            resultado += uniGanho.toString() + "\n";
        }
        return resultado;
    }
}
