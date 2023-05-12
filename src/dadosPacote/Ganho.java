package dadosPacote;

public class Ganho {
    private Double valor;
    private String tipo;
    private String titulo;

    public Ganho(Double valor, String tipo, String titulo){
        this.valor = valor;
        this.tipo = tipo;
        this.titulo = titulo;        
    }

    public Double getValor(){
        return this.valor;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

}
