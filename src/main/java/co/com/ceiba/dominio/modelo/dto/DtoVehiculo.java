package co.com.ceiba.dominio.modelo.dto;

import java.util.Date;

public class DtoVehiculo {

	String placa;
	String tipoVehiculo;
	Date fechaIngreso;
	
	
	public DtoVehiculo(String placa, String tipoVehiculo, Date fechaIngreso) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.fechaIngreso = fechaIngreso;
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
	
	
}
