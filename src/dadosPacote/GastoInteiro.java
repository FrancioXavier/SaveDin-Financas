package dadosPacote;

public class GastoInteiro implements Gastos{
	String fixoOuVariavel;
	String titulo;
	Double valor;
	String data;
	public GastoInteiro(String fixoOuVariavel, String titulo, Double valor, String data) {
		this.fixoOuVariavel = fixoOuVariavel;
		this.titulo = titulo;
		this.valor = valor;
		this.data = data;
	}

	@Override
	public String getData() {
		return this.data;
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
