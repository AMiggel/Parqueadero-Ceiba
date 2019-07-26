package co.com.ceiba.dominio.modelo.validador;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {
	
	
	public static void validarCampoObligatorio(Object valor, String mensaje){
			if (valor == null) {
				throw new ExcepcionValorObligatorio(mensaje);
			}
		
	}
	
	public static void validarLongitudDeCampo(String valor, int longitud,String mensaje) {
		if (valor.length() < longitud) {
			throw new ExcepcionLongitudDeValor(mensaje);
		}
	}
	
	
}
