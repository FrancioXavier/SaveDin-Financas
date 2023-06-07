package dadosPacote;

public class Ganho {
    private Double valor;
    private String tipo;
    private String titulo;
    private int idUser;
    private int id;

    public Ganho(Double valor, String tipo, String titulo, int idUser, int id){
        this.valor = valor;
        this.tipo = tipo;
        this.titulo = titulo;
        this.idUser = idUser;
        this.id = id;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValor(){
        return this.valor;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
