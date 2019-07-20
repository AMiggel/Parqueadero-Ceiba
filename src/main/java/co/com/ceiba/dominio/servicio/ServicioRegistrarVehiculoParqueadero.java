package co.com.ceiba.dominio.servicio;


import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioParqueadero;

public class ServicioRegistrarVehiculoParqueadero {

	private RepositorioParqueadero repositorioParqueadero;
	public ServicioRegistrarVehiculoParqueadero(RepositorioParqueadero repositorioParqueadero) {
		this.repositorioParqueadero = repositorioParqueadero;
	}
	
;
		
	public void ejecutar(Vehiculo vehiculo) {
		this.repositorioParqueadero.registrarVehiculo(vehiculo);
	}
}
