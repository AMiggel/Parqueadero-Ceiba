package co.com.ceiba.dominio.servicio;

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
	
	public ServicioRegistrarVehiculo(RepositorioRegistroVehiculo repositorioVehiculo) {
		this.repositorioRegistroVehiculo = repositorioVehiculo;
	}
		
	public void ejecutar(Vehiculo vehiculo) throws ExcepcionCondicionPrevia {
		validarTipoVehiculo(vehiculo.getTipoVehiculo());
		verificarVehiculoParqueado(vehiculo.getPlaca());
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
	
	public boolean ingresaDomingoOLunes() {
			Calendar calendar= Calendar.getInstance();
			
			if (calendar.DAY_OF_WEEK == calendar.MONDAY ||calendar.DAY_OF_WEEK == calendar.SUNDAY ) {
				
				return true;
			}else {
				return false;
			}
		
		}
	}
	
	
	
	

