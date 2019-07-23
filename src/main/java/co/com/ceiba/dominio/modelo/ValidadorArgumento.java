package co.com.ceiba.dominio.modelo;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {
	
	
	public static void validarCampoObligatorio(Object valor, String mensaje) throws ExcepcionValorObligatorio {
			if (valor == null) {
				throw new ExcepcionValorObligatorio(mensaje);
			}
		
	}
	
	public static void validarLongitudDeCampo(String valor, int longitud,String mensaje) throws ExcepcionLongitudDeValor {
		if (valor.length() < longitud) {
			throw new ExcepcionLongitudDeValor(mensaje);
		}
	}
	
	public static void validarCapacidadParqueadero(int valor,int capacidad, String mensaje) throws ExcepcionRegistroParqueadero {
		if(valor < capacidad) {
			throw new ExcepcionRegistroParqueadero(mensaje);
		}
	}
	
}
