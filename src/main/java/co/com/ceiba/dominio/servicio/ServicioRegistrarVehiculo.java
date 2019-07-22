package co.com.ceiba.dominio.servicio;


import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.dominio.modelo.entidad.RegistroEnParqueadero;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioRegistrarVehiculo {

	private RepositorioVehiculo repositorioParqueadero;
	
	private RegistroEnParqueadero registroEnParqueadero;
	

	
	public ServicioRegistrarVehiculo(RepositorioVehiculo repositorioParqueadero) {
		this.repositorioParqueadero = repositorioParqueadero;
	}
		
	public void ejecutar(Vehiculo vehiculo) {
		registrarHoraIngreso(vehiculo);
		this.repositorioParqueadero.registrarVehiculo(vehiculo);
	}
	
	
	private Date registrarHoraIngreso(Vehiculo vehiculo) {

		registroEnParqueadero = new RegistroEnParqueadero();
		Calendar calendar = Calendar.getInstance();
		registroEnParqueadero.setHoraEntradaVehiculo(calendar.getTime());
		registroEnParqueadero.setVehiculo(vehiculo);
		return registroEnParqueadero.getHoraEntradaVehiculo();
	}
}
