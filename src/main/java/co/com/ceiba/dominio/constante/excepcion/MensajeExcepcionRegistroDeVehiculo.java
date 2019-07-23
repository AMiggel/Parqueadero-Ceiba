package co.com.ceiba.dominio.constante.excepcion;

public class MensajeExcepcionRegistroDeVehiculo {
	
	private MensajeExcepcionRegistroDeVehiculo() {
		throw new IllegalStateException("MensajeException class");
	}
	
	public static final String PLACA_INICIA_CON_A= "No esta autorizado para ingresar";
	public static final String VEHICULO_PARQUEADO="El vehiculo ya se encuentra parqueado";

}
