package co.com.ceiba.dominio.modelo;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;

public class Vehiculo{
	
	private static final String PLACA_ES_VALOR_OBLIGATORIO="La placa es un valor obligatorio";
	private static final String TIPO_VEHICULO_ES_VALOR_OBLIGATORIO ="El tipo de vehiculo es un valor obligatorio";
	private static final String CILINDRAJE_ES_VALOR_OBLIGATORIO="El cilindraje es valor Obligatorio";
	private static final String LA_LONGITUD_DE_PLACA_ES_MAYOR= "La longitud de la placa debe ser mayor";
	private static final int LONGITUD_MINIMA_PLACA =5;
	
	
	
	private int id;
	private String tipoVehiculo;
	private String placa;
	private int cilindraje;
	
	public Vehiculo() {
	}
	public Vehiculo( String tipoVehiculo, String placa, int cilindraje) 
			throws ExcepcionValorObligatorio, ExcepcionRegistroParqueadero, ExcepcionLongitudDeValor {
		ValidadorArgumento.validarCampoObligatorio(tipoVehiculo, TIPO_VEHICULO_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(placa,PLACA_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(cilindraje, CILINDRAJE_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarLongitudDeCampo(placa, LONGITUD_MINIMA_PLACA,LA_LONGITUD_DE_PLACA_ES_MAYOR);
		
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
