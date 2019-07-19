package co.com.ceiba.aplicacion.comando.fabrica;

import co.com.ceiba.aplicacion.comando.ComandoParqueadero;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

public class FabricaParqueadero {
	
	public Vehiculo registrar(ComandoParqueadero comandoParqueadero) {
		return comandoParqueadero.getVehiculo();
	}

}
