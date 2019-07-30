package co.com.ceiba.dominio.modelo;

import java.util.Date;

import co.com.ceiba.dominio.modelo.validador.ValidadorArgumento;

public class Vehiculo {

	public static final String PLACA_ES_VALOR_OBLIGATORIO = "La placa es un valor obligatorio";
	public static final String TIPO_VEHICULO_ES_VALOR_OBLIGATORIO = "El tipo de vehiculo es un valor obligatorio";
	public static final String CILINDRAJE_ES_VALOR_OBLIGATORIO = "El cilindraje es valor Obligatorio";
	public static final String LA_LONGITUD_DE_PLACA_ES_MAYOR = "La longitud de la placa debe ser mayor";
	public static final String TIPO_VEHICULO_DEBE_SER_CARRO_MOTO="El tipo de vehiculo debe ser carro o moto";
	public static final int LONGITUD_MINIMA_PLACA = 5;
	public static final String MOTO = "moto";
	public static final String CARRO = "carro";

	private int id;
	private Date horaIngreso;
	private Date horaSalida;
	private String tipoVehiculo;
	private String placa;
	private long cobroParqueo;

	private int cilindraje;

	public Vehiculo() {
	}
	
	public Vehiculo(int id,long cobroParqueo, String tipoVehiculo, String placa, int cilindraje,Date horaIngreso, Date horaSalida) {
		ValidadorArgumento.validarCampoObligatorio(tipoVehiculo, TIPO_VEHICULO_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(placa, PLACA_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(cilindraje, CILINDRAJE_ES_VALOR_OBLIGATORIO);
		ValidadorArgumento.validarLongitudDeCampo(placa, LONGITUD_MINIMA_PLACA, LA_LONGITUD_DE_PLACA_ES_MAYOR);
		ValidadorArgumento.validarTipoCarro(tipoVehiculo, TIPO_VEHICULO_DEBE_SER_CARRO_MOTO);

		this.id= id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.horaIngreso= horaIngreso;
		this.horaSalida= horaSalida;
		this.cobroParqueo = cobroParqueo;
		
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

	public long getValorParqueo() {
		return cobroParqueo;
	}

	public void setValorParqueo(long cobroParqueo) {
		this.cobroParqueo = cobroParqueo;
	}
}
