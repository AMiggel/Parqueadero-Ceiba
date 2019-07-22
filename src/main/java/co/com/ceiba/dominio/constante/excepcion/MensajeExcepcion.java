package co.com.ceiba.dominio.constante.excepcion;

public class MensajeExcepcion {
	
	private MensajeExcepcion() {
		throw new IllegalStateException("MensajeException class");
	}
	
	public static final String PLACA_INICIA_CON_A= "No esta autorizado para ingresar";
	public static final String NO_PUEDE_PARQUEAR_MAS_CARROS="Parqueadero para carros lleno";
	public static final String NO_PUEDE_PARQUEAR_MAS_MOTOS="Parqueadero para motos lleno";
	public static final String VEHICULO_NO_ENCONTRADO_EN_PARQUEADERO= "El vehiculo no se encuentra parqueado";
	public static final String VEHICULO_PARQUEADO="El vehiculo ya se encuentra parqueado";
	public static final String NO_ES_CARRO_NI_MOTO= "Solo se permiten Carros y Motos";


}
