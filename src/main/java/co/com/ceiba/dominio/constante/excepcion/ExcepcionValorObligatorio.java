package co.com.ceiba.dominio.constante.excepcion;

public class ExcepcionValorObligatorio extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -468436968100507057L;
	private final String mensaje;

	public ExcepcionValorObligatorio (String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		return mensaje;
	}
}
