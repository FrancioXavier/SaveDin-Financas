package dadosPacote;

import bancoPacote.ContaBancaria;

public class GastoParcelado implements Gastos {
	String titulo;
	String data;
	ContaBancaria conta;
	Integer parcelas;
	Double valorParcela;
	Double valor;
	int idUser;
	public GastoParcelado(
		String data, 
		String titulo, 
		ContaBancaria conta, 
		Integer parcelas, 
		Double valorParcelas,
		int idUser
	){
		this.data = data;
		this.titulo = titulo;
		this.conta = conta;
		this.parcelas = parcelas;
		this.valorParcela = valorParcelas;
		this.valor = valorParcelas * parcelas;
		this.idUser = idUser;
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
