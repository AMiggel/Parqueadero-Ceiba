package co.com.ceiba.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioRegistrarVehiculo {

	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;

	public static final String PLACA_INICIA_CON_A= "No esta autorizado para ingresar";
	public static final String VEHICULO_PARQUEADO="El vehiculo ya se encuentra parqueado";


	//constructor
	public ServicioRegistrarVehiculo(RepositorioRegistroVehiculo repositorioVehiculo) {
		this.repositorioRegistroVehiculo = repositorioVehiculo;
	}
	

	public void ejecutar(Vehiculo vehiculo) throws ExcepcionRegistroParqueadero {
		validarPlacaIniciaConA(vehiculo.getPlaca().toUpperCase());
		
		this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
	}

	
	public void verificarVehiculoParqueado(String placa) throws ExcepcionRegistroParqueadero {

		boolean parqueado = this.repositorioRegistroVehiculo.parqueado(placa);
		if (parqueado) {
			throw new ExcepcionRegistroParqueadero(VEHICULO_PARQUEADO);
		}
	}

 	
	public boolean ingresaDomingoOLunes() throws ExcepcionRegistroParqueadero  {

		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		} 
		throw new ExcepcionRegistroParqueadero(PLACA_INICIA_CON_A);
	}
	

	public boolean validarPlacaIniciaConA(String placa) throws ExcepcionRegistroParqueadero  {
				
		if (placa.charAt(0) == 'A') {
			ingresaDomingoOLunes();	
		}
		return false;
	}

}
