package co.com.ceiba.dominio.testdatabuilder;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

public class VehiculoTestDataBuilder {
	

	private String tipoVehiculo;
	
	private String placa;
	
	private int cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.tipoVehiculo="Carro";
		this.placa="ABC123";
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
	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje= cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(tipoVehiculo,placa,cilindraje);
	}

}
