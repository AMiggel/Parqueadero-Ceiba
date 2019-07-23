package co.com.ceiba.dominio.constante.excepcion;

public class MensajeExcepcionRegistroEnParqueadero {
	
	public MensajeExcepcionRegistroEnParqueadero() {
		throw new IllegalStateException("MensajeException class");
		}
		
	public static final String NO_ES_CARRO_NI_MOTO= "Solo se permiten Carros y Motos";

	}


