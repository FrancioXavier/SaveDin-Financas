package dadosPacote;

public class Ganho {
    private Double valor;
    private String tipo;
    private String categoria;
    private String titulo;

    public Ganho(Double valor, String tipo, String categoria, String titulo){
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.titulo = titulo;        
    }

    public Double getValor(){
        return this.valor;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getCategoria(){
        return this.categoria;
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

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

}
