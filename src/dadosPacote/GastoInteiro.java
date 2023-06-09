package dadosPacote;

public class GastoInteiro implements Gastos{
	private String fixoOuVariavel;
	private String titulo;
	private Double valor;
	private String data;
	private int idUser;
	private int id;
	public GastoInteiro(String fixoOuVariavel, String titulo, Double valor, String data, int idUser, int id) {
		this.fixoOuVariavel = fixoOuVariavel;
		this.titulo = titulo;
		this.valor = valor;
		this.data = data;
		this.idUser = idUser;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getData() {
		return this.data;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	@Override
	public Double getValor() {
		return this.valor;
	}

	public String getFixoOuVariavel() {
		return fixoOuVariavel;
	}

	@Override
	public String getTipoGasto() {
		return "Gasto inteiro";
	}

	@Override
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setFixoOuVariavel(String fixoOuVariavel) {
		this.fixoOuVariavel = fixoOuVariavel;
	}

}
