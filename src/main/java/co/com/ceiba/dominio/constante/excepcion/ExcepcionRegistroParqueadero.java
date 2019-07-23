package co.com.ceiba.dominio.constante.excepcion;

public class ExcepcionRegistroParqueadero extends Exception {
	

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1724638404193708492L;
		private final String mensaje;

		public ExcepcionRegistroParqueadero(String mensaje) {
			super();
			this.mensaje = mensaje;
		}

		@Override
		public String getMessage() {
			return mensaje;
		}

	}


