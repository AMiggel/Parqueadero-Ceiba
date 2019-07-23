package co.com.ceiba.dominio.constante.excepcion;


public class ExcepcionLongitudDeValor extends Exception{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String mensaje;

	public ExcepcionLongitudDeValor (String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		return mensaje;
	}
}



