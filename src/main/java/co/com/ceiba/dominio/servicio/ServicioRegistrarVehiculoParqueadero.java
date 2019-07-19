package co.com.ceiba.dominio.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioParqueadero;

public class ServicioRegistrarVehiculoParqueadero {

	@Autowired
	private RepositorioParqueadero repositorioParqueadero;
		
	public void ejecutar(Vehiculo vehiculo) {
		this.repositorioParqueadero.registrarVehiculo(vehiculo);
	}
}
