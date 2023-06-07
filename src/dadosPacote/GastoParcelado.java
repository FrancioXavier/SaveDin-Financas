package dadosPacote;

import bancoPacote.ContaBancaria;

public class GastoParcelado implements Gastos {
	private String titulo;
	private String data;
	private ContaBancaria conta;
	private Integer parcelas;
	private Double valorParcela;
	protected Double valor;
	private int idUser;
	private int id;
	public GastoParcelado(
		String data, 
		String titulo, 
		ContaBancaria conta, 
		Integer parcelas, 
		Double valorParcelas,
		int idUser,
		int id
	){
		this.data = data;
		this.titulo = titulo;
		this.conta = conta;
		this.parcelas = parcelas;
		this.valorParcela = valorParcelas;
		this.valor = valorParcelas * parcelas;
		this.idUser = idUser;
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String getData() {
		return this.data;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdUser() {
		return idUser;
	}

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	@Override
	public Double getValor() {
		return this.valorParcela * this.parcelas;
	}

	public ContaBancaria getConta() {
		return conta;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	@Override
	public String getTipoGasto() {
		return "Gasto parcelado";
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
		this.valor = valor * this.parcelas;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

}
