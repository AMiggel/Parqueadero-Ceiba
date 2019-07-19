package co.com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculoParqueadero;

@Component
public class ManejadorRegistrarVehiculo {
	
	private final ServicioRegistrarVehiculoParqueadero servicioRegistrarVehiculo;
	private final FabricaVehiculo fabricaParqueadero;
	
	public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculoParqueadero servicioRegistrarVehiculo,
			FabricaVehiculo fabricaParqueadero) {
		this.servicioRegistrarVehiculo= servicioRegistrarVehiculo;
		this.fabricaParqueadero = fabricaParqueadero;
	}
	
	public void ejecutar(ComandoVehiculo comandoParqueadero) {
		Vehiculo vehiculo= this.fabricaParqueadero.registrar(comandoParqueadero);
	   servicioRegistrarVehiculo.ejecutar(vehiculo);
	}
}
