package co.com.ceiba.dominio.servicio.vehiculo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.modelo.Parqueadero;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.vehiculo.RepositorioRegistrarVehiculo;
import co.com.ceiba.dominio.servicio.parqueadero.ServicioParqueadero;

public class ServicioRegistrarVehiculo {

	private RepositorioRegistrarVehiculo repositorioRegistroVehiculo;
	

	public static final String PLACA_INICIA_CON_A = "No esta autorizado para ingresar";
	public static final String VEHICULO_PARQUEADO = "El vehiculo ya se encuentra parqueado";

	// constructor
	public ServicioRegistrarVehiculo(RepositorioRegistrarVehiculo repositorioVehiculo) {
		this.repositorioRegistroVehiculo = repositorioVehiculo;
	}

	public void ejecutar(Vehiculo vehiculo) {
		vehiculo.setHoraIngreso(registrarHoraEntrada());
		validarPlacaInicialConA(vehiculo.getPlaca().toUpperCase());
		this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
		
	}

	
	public Vehiculo buscarVehiculoParqueado(String placa) {
		return repositorioRegistroVehiculo.buscarVehiculoParqueado(placa);
	}

	
	public boolean ingresaDomingoOLunes() {

		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		}
		throw new ExcepcionRegistroParqueadero(PLACA_INICIA_CON_A);
	}

	public void validarPlacaInicialConA(String placa) {

		if (placa.charAt(0) == 'A') {
			ingresaDomingoOLunes();
		}
	}
	
	public Date registrarHoraEntrada() {
		Calendar calendar = Calendar.getInstance();
		Date horaEntrada= new Date();
		horaEntrada= calendar.getTime();
		return horaEntrada;
	}
	
	
	
}
