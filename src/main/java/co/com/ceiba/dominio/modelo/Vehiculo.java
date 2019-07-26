package co.com.ceiba.dominio.modelo;

import java.util.Date;

import co.com.ceiba.dominio.modelo.validador.ValidadorArgumento;

public class Vehiculo {

	public static final String PLACA_ES_VALOR_OBLIGATORIO = "La placa es un valor obligatorio";
	public static final String TIPO_VEHICULO_ES_VALOR_OBLIGATORIO = "El tipo de vehiculo es un valor obligatorio";
	public static final String CILINDRAJE_ES_VALOR_OBLIGATORIO = "El cilindraje es valor Obligatorio";
	public static final String LA_LONGITUD_DE_PLACA_ES_MAYOR = "La longitud de la placa debe ser mayor";
	public static final int LONGITUD_MINIMA_PLACA = 5;

	private int id;
	private Date horaIngreso;
	private Date horaSalida;
	private String tipoVehiculo;
	private String placa;

	private int cilindraje;

	public Vehiculo() {
	}

	public Vehiculo(String tipoVehiculo, String placa, int cilindraje,Date horaIngreso, Date horaSalida) {
		ValidadorArgumento.validarCampoObligatorio(tipoVehiculo, TIPO_VEHICULO_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(placa, PLACA_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(cilindraje, CILINDRAJE_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarLongitudDeCampo(placa, LONGITUD_MINIMA_PLACA, LA_LONGITUD_DE_PLACA_ES_MAYOR);

		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.horaIngreso= horaIngreso;
		this.horaSalida= horaSalida;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
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

	public Date getHoraIngreso() {
		return horaIngreso;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraIngreso(Date horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

}
