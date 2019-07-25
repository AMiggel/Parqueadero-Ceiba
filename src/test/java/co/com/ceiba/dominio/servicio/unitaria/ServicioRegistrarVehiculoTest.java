package co.com.ceiba.dominio.servicio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarVehiculo;
import co.com.ceiba.dominio.servicio.vehiculo.ServicioRegistrarVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioRegistrarVehiculoTest {

	ServicioRegistrarVehiculo servicioRegistrarVehiculo;

	RepositorioRegistrarVehiculo repositorioRegistroVehiculo;
	
	@Before
	public void setUp() {
		servicioRegistrarVehiculo = new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);
	}
	
	
	@Test
	public void buscarVehiculoTest() {
		//Arrange
		Vehiculo vehiculo =new  VehiculoTestDataBuilder().build();
		RepositorioRegistrarVehiculo repositorioRegistroVehiculo = Mockito.mock(RepositorioRegistrarVehiculo.class);
		Mockito.when(repositorioRegistroVehiculo.buscarVehiculoParqueado(vehiculo.getPlaca())).thenReturn(vehiculo);
		
		//act
		servicioRegistrarVehiculo = new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);
		
		Vehiculo vehiculoEsperado= servicioRegistrarVehiculo.buscarVehiculoParqueado(vehiculo.getPlaca());
		//assert	
		assertEquals(vehiculo, vehiculoEsperado);
	}
	



		
	}

