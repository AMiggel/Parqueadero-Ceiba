package co.com.ceiba.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;

import co.com.ceiba.dominio.constante.condicion.CondicionesParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.constante.excepcion.MensajeExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioRegistrarVehiculo {

	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;

	public ServicioRegistrarVehiculo() {
	}

	//constructor
	public ServicioRegistrarVehiculo(RepositorioRegistroVehiculo repositorioVehiculo) {
		this.repositorioRegistroVehiculo = repositorioVehiculo;
	}
	

	public void ejecutar(Vehiculo vehiculo) throws ExcepcionCondicionPrevia {
		validarTipoVehiculo(vehiculo.getTipoVehiculo());
		verificarVehiculoParqueado(vehiculo.getPlaca());
		
		if (placaIniciaConA(vehiculo.getPlaca())) {
			ingresaDomingoOLunes();
			this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
		}
		this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
	}

	
	public void verificarVehiculoParqueado(String placa) throws ExcepcionCondicionPrevia {

		boolean parqueado = this.repositorioRegistroVehiculo.parqueado(placa);
		if (parqueado) {
			throw new ExcepcionCondicionPrevia(MensajeExcepcion.VEHICULO_PARQUEADO);
		}
	}

	public void validarTipoVehiculo(String tipoVehiculo) throws ExcepcionCondicionPrevia {

		if (tipoVehiculo != CondicionesParqueadero.MOTO && tipoVehiculo != CondicionesParqueadero.CARRO) {
			throw new ExcepcionCondicionPrevia(MensajeExcepcion.NO_ES_CARRO_NI_MOTO);
		}

	}

	public boolean ingresaDomingoOLunes() throws ExcepcionCondicionPrevia  {

		if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.SUNDAY
				|| LocalDateTime.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return true;
		} 
		throw new ExcepcionCondicionPrevia(MensajeExcepcion.PLACA_INICIA_CON_A);
	}
	

	public boolean placaIniciaConA(String placa)  {
		placa.toUpperCase();
		
		if (placa.charAt(0) == 'A') {
			return true;
		}
		return false;
	}

}
