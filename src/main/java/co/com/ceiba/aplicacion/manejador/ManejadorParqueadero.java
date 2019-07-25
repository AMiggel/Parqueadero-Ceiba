package co.com.ceiba.aplicacion.manejador;

import co.com.ceiba.aplicacion.fabrica.FabricaParqueadero;
import co.com.ceiba.dominio.modelo.Parqueadero;
import co.com.ceiba.dominio.servicio.parqueadero.ServicioParqueadero;

public class ManejadorParqueadero {
	
	private ServicioParqueadero servicioParqueadero;
	private FabricaParqueadero fabricaParqueadero;
	
	public ManejadorParqueadero(ServicioParqueadero servicioParqueadero, FabricaParqueadero fabricaParqueadero) {
		this.servicioParqueadero = servicioParqueadero;
		this.fabricaParqueadero = fabricaParqueadero;
	}
	
	public void ejecutarParqueadero(Parqueadero parqueadero) {
		Parqueadero parqueaderoCreado = this.fabricaParqueadero.registrar(parqueadero);
		servicioParqueadero.ocuparEspacioDisponible(parqueaderoCreado);
	}

}
 