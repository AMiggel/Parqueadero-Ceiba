package co.com.ceiba.dominio.servicio;


import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import co.com.ceiba.dominio.modelo.entidad.RegistroEnParqueadero;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioRegistrarVehiculoParqueadero {

	private RepositorioVehiculo repositorioParqueadero;
	
	private RegistroEnParqueadero registroEnParqueadero;
	
	public ServicioRegistrarVehiculoParqueadero(RepositorioVehiculo repositorioParqueadero) {
		this.repositorioParqueadero = repositorioParqueadero;
	}
		
	public void ejecutar(Vehiculo vehiculo) {
		registrarHoraIngreso(vehiculo);
		repositorioParqueadero.registrarVehiculo(vehiculo);
		System.out.println("Ejecutar Servicio Dominio");
	}

	
	
	private Date registrarHoraIngreso(Vehiculo vehiculo) {
		System.out.println("EjecutarFecha");

		registroEnParqueadero = new RegistroEnParqueadero();
		Calendar calendar = Calendar.getInstance();
		registroEnParqueadero.setHoraEntradaVehiculo(calendar.getTime());
		registroEnParqueadero.setVehiculo(vehiculo);
		return registroEnParqueadero.getHoraEntradaVehiculo();
	}
}
