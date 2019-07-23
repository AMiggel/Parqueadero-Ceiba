package co.com.ceiba.dominio.servicio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.constante.excepcion.MensajeExcepcionRegistroDeVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioRegistrarVehiculoTest {

	ServicioRegistrarVehiculo servicioRegistrarVehiculo;

	RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	@Before
	public void setUp() {
		servicioRegistrarVehiculo = new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);
	}
	
	
	@Test
	public void validarSiEstaParqueado() {
		//Arrange
		Vehiculo vehiculo =new  VehiculoTestDataBuilder().build();
		RepositorioRegistroVehiculo repositorioRegistroVehiculo = Mockito.mock(RepositorioRegistroVehiculo.class);
		Mockito.when(repositorioRegistroVehiculo.parqueado(vehiculo.getPlaca())).thenReturn(true);
		
		//act
		servicioRegistrarVehiculo = new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);
		try {
			servicioRegistrarVehiculo.verificarVehiculoParqueado(vehiculo.getPlaca());
			fail();
			//assert	
		} catch (ExcepcionCondicionPrevia e) {
		assertEquals("El vehiculo ya se encuentra parqueado", e.getMessage());
		}
	}
	

	@Test
	public void validarSiEsCarroOMoto() {
		//Arrange
		Vehiculo vehiculo =new  VehiculoTestDataBuilder().conTipo("Bicicleta").build();
	
		//act
		try {
			servicioRegistrarVehiculo.validarTipoVehiculo(vehiculo.getTipoVehiculo());
			fail();

		//assert
		} catch (ExcepcionCondicionPrevia e) {
		assertEquals("Solo se permiten Carros y Motos", e.getMessage());
		}
	}
	
	@Test
	public void validarSiEsDomingoOLunes() throws ExcepcionCondicionPrevia {
		//arrange
		Mockito.when(servicioRegistrarVehiculo.ingresaDomingoOLunes()).thenReturn(true);
		
		//act
		
		boolean esDomingoOLunes = servicioRegistrarVehiculo.ingresaDomingoOLunes();
			
		//assert
			assertTrue(esDomingoOLunes);
		}
		
	}

