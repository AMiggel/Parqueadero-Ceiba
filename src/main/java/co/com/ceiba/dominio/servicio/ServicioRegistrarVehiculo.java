package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.constante.excepcion.MensajeExcepcion;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioRegistrarVehiculo {

	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	public ServicioRegistrarVehiculo(RepositorioRegistroVehiculo repositorioVehiculo) {
		this.repositorioRegistroVehiculo = repositorioVehiculo;
	}
		
	public void ejecutar(Vehiculo vehiculo) throws ExcepcionCondicionPrevia {
		verificarVehiculoParqueado(vehiculo.getPlaca());
		this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
	}
	
	public void verificarVehiculoParqueado(String placa) throws ExcepcionCondicionPrevia {
	
		boolean parqueado = this.repositorioRegistroVehiculo.parqueado(placa);
		if (parqueado) {
			throw new ExcepcionCondicionPrevia(MensajeExcepcion.VEHICULO_PARQUEADO);
		}
	}
	
	
	
}
