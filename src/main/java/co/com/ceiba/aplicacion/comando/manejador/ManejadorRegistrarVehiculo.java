package co.com.ceiba.aplicacion.comando.manejador;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculoParqueadero;

@Component
public class ManejadorRegistrarVehiculo {
	
	private final ServicioRegistrarVehiculoParqueadero servicioRegistrarVehiculo;
	private final FabricaVehiculo fabricaVehiculo;
	
	public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculoParqueadero servicioRegistrarVehiculo,
			FabricaVehiculo fabricaVehiculo) {
		this.servicioRegistrarVehiculo= servicioRegistrarVehiculo;
		this.fabricaVehiculo= fabricaVehiculo;
	}
	
	public void ejecutar(ComandoVehiculo comandoVehiculo) {
		Vehiculo vehiculo= this.fabricaVehiculo.registrar(comandoVehiculo);
	   servicioRegistrarVehiculo.ejecutar(vehiculo);
	   System.out.println("Ejecutar manejador");
	}
}
