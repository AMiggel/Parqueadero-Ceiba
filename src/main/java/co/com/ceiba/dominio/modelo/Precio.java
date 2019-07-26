package co.com.ceiba.dominio.modelo;

public class Precio {

	
	private long valorHora;
	
	private long valorDia;

	public Precio(long valorHora, long valorDia) {
		this.valorHora = valorHora;
		this.valorDia = valorDia;
	}

	public long getValorHora() {
		return valorHora;
	}

	public long getValorDia() {
		return valorDia;
	}

	public void setValorHora(long valorHora) {
		this.valorHora = valorHora;
	}

	public void setValorDia(long valorDia) {
		this.valorDia = valorDia;
	}
	
	
	
	
}
