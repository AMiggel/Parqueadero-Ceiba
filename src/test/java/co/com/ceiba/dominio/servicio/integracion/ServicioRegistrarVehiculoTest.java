package co.com.ceiba.dominio.servicio.integracion;

import org.junit.Test;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioRegistrarVehiculoTest {
	
	
	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	
	@Test
	public void registrarVehiculo() throws ExcepcionCondicionPrevia {
		
		//arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		repositorioRegistroVehiculo.registrarVehiculo(vehiculo);
		ServicioRegistrarVehiculo servicioRegistrarVehiculo= new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);
		//act
		
		servicioRegistrarVehiculo.ejecutar(vehiculo);
		
		//assert
		
		
	}

}
