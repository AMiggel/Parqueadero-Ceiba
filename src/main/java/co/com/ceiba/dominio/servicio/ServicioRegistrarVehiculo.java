package co.com.ceiba.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;
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
	

	public void ejecutar(Vehiculo vehiculo) throws ExcepcionValorObligatorio {
		//verificarVehiculoParqueado(vehiculo.getPlaca());
		
		if (placaIniciaConA(vehiculo.getPlaca())) {
			ingresaDomingoOLunes();
			this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
		}
		this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
	}

	
	public void verificarVehiculoParqueado(String placa) throws ExcepcionValorObligatorio {

		boolean parqueado = this.repositorioRegistroVehiculo.parqueado(placa);
		if (parqueado) {
			throw new ExcepcionValorObligatorio(VEHICULO_PARQUEADO);
		}
	}

 	
	public boolean ingresaDomingoOLunes() throws ExcepcionValorObligatorio  {

		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		} 
		throw new ExcepcionValorObligatorio(PLACA_INICIA_CON_A);
	}
	

	public boolean placaIniciaConA(String placa)  {
		placa.toUpperCase();
		
		if (placa.charAt(0) == 'A') {
			return true;
		}
		return false;
	}

}
