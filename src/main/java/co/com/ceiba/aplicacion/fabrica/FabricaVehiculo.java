package co.com.ceiba.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.Vehiculo;

@Component
public class FabricaVehiculo {
	
	public Vehiculo registrar(Vehiculo vehiculo) throws ExcepcionValorObligatorio, ExcepcionRegistroParqueadero, ExcepcionLongitudDeValor {
		return new Vehiculo(vehiculo.getTipoVehiculo(),vehiculo.getPlaca(),vehiculo.getCilindraje());
	}
}
