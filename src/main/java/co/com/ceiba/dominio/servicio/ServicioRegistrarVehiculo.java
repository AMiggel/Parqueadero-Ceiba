package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioRegistrarVehiculo {

	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	public ServicioRegistrarVehiculo(RepositorioRegistroVehiculo repositorioVehiculo) {
		this.repositorioRegistroVehiculo = repositorioVehiculo;
	}
		
	public void ejecutar(Vehiculo vehiculo) {
		this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
	}
	
	public void verificarVehiculoParqueado(Vehiculo vehiculo) {
		
	}
	
	
	
}
