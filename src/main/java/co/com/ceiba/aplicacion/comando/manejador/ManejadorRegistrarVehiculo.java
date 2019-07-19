package co.com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoParqueadero;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculoParqueadero;

@Component
public class ManejadorRegistrarVehiculo {
	
	private final ServicioRegistrarVehiculoParqueadero servicioRegistrarVehiculoParqueadero;
	
	public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculoParqueadero servicioRegistrarVehiculoParqueadero) {
		this.servicioRegistrarVehiculoParqueadero= servicioRegistrarVehiculoParqueadero;
	}
	
	public void ejecutar(ComandoParqueadero comandoParqueadero) {
	   servicioRegistrarVehiculoParqueadero.ejecutar(comandoParqueadero.getVehiculo());
	}
}
