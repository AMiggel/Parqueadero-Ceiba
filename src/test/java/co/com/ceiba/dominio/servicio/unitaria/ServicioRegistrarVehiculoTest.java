package co.com.ceiba.dominio.servicio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioRegistrarVehiculoTest {

	ServicioRegistrarVehiculo servicioRegistrarVehiculo;

	RepositorioRegistrarVehiculo repositorioRegistroVehiculo;

	@Before
	public void setUp() {
		repositorioRegistroVehiculo = Mockito.mock(RepositorioRegistrarVehiculo.class);
		servicioRegistrarVehiculo = new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);

	}

	@Test
	public void buscarVehiculoParqueadoRetornaVehiculo() {
		// Arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		Mockito.when(repositorioRegistroVehiculo.buscarVehiculoParqueado(vehiculo.getPlaca())).thenReturn(vehiculo);

		// act
		Vehiculo vehiculoEsperado = servicioRegistrarVehiculo.buscarVehiculoParqueado(vehiculo.getPlaca());
		// assert
		assertEquals(vehiculo, vehiculoEsperado);
	}


	@Test
	public void verificarCupoDisponibleParaCarro() {
		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("carro").build();
		Mockito.when(repositorioRegistroVehiculo.verificarEspacioDisponible(vehiculo.getTipoVehiculo())).thenReturn(20);

		// act
		try {
			servicioRegistrarVehiculo.verificarCupoDisponibleCarro(vehiculo.getTipoVehiculo());
			fail();
		} catch (ExcepcionRegistroParqueadero e) {
			// assert
			assertEquals(ServicioRegistrarVehiculo.LIMITE_DE_CARROS_EXCEDIDO, e.getMessage());
		}

	}

	@Test
	public void verificarCupoDisponibleParaMoto() {

		// arrange
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conTipo("moto").build();
		Mockito.when(repositorioRegistroVehiculo.verificarEspacioDisponible(vehiculo.getTipoVehiculo())).thenReturn(10);
		// act
		try {
			servicioRegistrarVehiculo.verificarCupoDisponibleMoto(vehiculo.getTipoVehiculo());
			fail();
		} catch (ExcepcionRegistroParqueadero e) {
			// assert
			assertEquals(ServicioRegistrarVehiculo.LIMITE_DE_MOTOS_EXCEDIDO, e.getMessage());
		}

	}

	@Test
	public void validarPlacaQueIniciaConARetornaExcepcion() {

		// arrange
		Calendar calendar = Calendar.getInstance();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca("abcdef").conHoraEntrada(calendar.getTime()).build();

		// act
		try {
			servicioRegistrarVehiculo.validarPlacaInicialConA(vehiculo.getPlaca().toUpperCase());
			fail();
			
		//assert	
		} catch (ExcepcionRegistroParqueadero e) {
			assertEquals(ServicioRegistrarVehiculo.PLACA_INICIA_CON_A, e.getMessage());
		}

	}

	

}
