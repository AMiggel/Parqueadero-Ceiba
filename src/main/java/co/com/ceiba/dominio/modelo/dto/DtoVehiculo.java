package co.com.ceiba.dominio.modelo.dto;

import java.util.Date;

public class DtoVehiculo {

	private String placa;
	private String tipoVehiculo;
	private Date fechaIngreso;
	private long valorCobro;
	
	public DtoVehiculo(String placa, String tipoVehiculo, Date fechaIngreso, long valorCobro) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.fechaIngreso = fechaIngreso;
		this.valorCobro = valorCobro;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public long getValorCobro() {
		return valorCobro;
	}
	

}
