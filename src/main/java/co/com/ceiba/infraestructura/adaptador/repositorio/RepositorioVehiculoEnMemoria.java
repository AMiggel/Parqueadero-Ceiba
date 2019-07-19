package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioParqueadero;

public class RepositorioVehiculoEnMemoria implements RepositorioParqueadero {
	
	@Autowired
	private IRepositorioVehiculoEnMemoria repositorioVehiculoEnMemoria;
	
	public void registrarVehiculo(Vehiculo vehiculo) {
		repositorioVehiculoEnMemoria.save(vehiculo);
		
		
	}

}