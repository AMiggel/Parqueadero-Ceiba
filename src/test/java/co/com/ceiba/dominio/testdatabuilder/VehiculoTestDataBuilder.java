package co.com.ceiba.dominio.testdatabuilder;


import java.util.Date;

import co.com.ceiba.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {
	

	private int id;
	private String tipoVehiculo;
	
	private String placa;
	
	private int cilindraje;
	
	private Date horaEntrada;
	
	private Date horaSalida;
	
	private long cobroParqueo;
	
	public VehiculoTestDataBuilder() {
		this.tipoVehiculo="Carro";
		this.placa="FBC123";
		this.cilindraje= 500;
		
		
	}
	
	public VehiculoTestDataBuilder conTipo(String tipoVehiculo) {
		this.tipoVehiculo= tipoVehiculo;
		return this;
	}
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa= placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
		return this;
	}
	public VehiculoTestDataBuilder conHoraSalida(Date horaSalida) {
		this.horaSalida=horaSalida;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje= cilindraje;
		return this;
	}

	public Vehiculo build(){
		return new Vehiculo(id,cobroParqueo,tipoVehiculo,placa,cilindraje,horaEntrada,horaSalida);
	}

}
