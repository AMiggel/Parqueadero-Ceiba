package co.com.ceiba.dominio.servicio.unitaria;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarSalidaVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarSalidaVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioRegistrarSalidaVehiculoTest {

	ServicioRegistrarSalidaVehiculo servicioRegistrarSalidaVehiculo;
	RepositorioRegistrarVehiculo repositorioRegistrarVehiculo;
	RepositorioRegistrarSalidaVehiculo repositorioRegistarSalidaVehiculo;

	@Before
	public void setUp() {
		repositorioRegistrarVehiculo = Mockito.mock(RepositorioRegistrarVehiculo.class);
		servicioRegistrarSalidaVehiculo = new ServicioRegistrarSalidaVehiculo(repositorioRegistarSalidaVehiculo,
				repositorioRegistrarVehiculo);

	}

	@Test
	public void generarCobroSiSonNueveHorasCobraPorDia() {

		// arrange
		long valorDia = 2000;
		long valorHora = 500;
		int horas = 9;

		// act
		long resultado = servicioRegistrarSalidaVehiculo.cobrar(valorDia, valorHora, horas);

		// assert
		assertEquals(2000, resultado);
	}

	@Test
	public void generarCobroSiSonDosHorasCobraMil() {

		// arrange
		long valorDia = 2000;
		long valorHora = 500;
		int horas = 2;

		// act
		long resultado = servicioRegistrarSalidaVehiculo.cobrar(valorDia, valorHora, horas);

		// assert
		assertEquals(1000, resultado);

	}

	@Test
	public void generarCobroSiSonSonVentiCincoHorasCobraUnDiaYUnaHora() {

		// arrange
		long valorDia = 2000;
		long valorHora = 500;
		int horas = 25;

		// act
		long resultado = servicioRegistrarSalidaVehiculo.cobrar(valorDia, valorHora, horas);

		// assert
		assertEquals(2500, resultado);

	}

	@Test
	public void generarCobroSiEsUnDiaMasNueveHorasCobraDosDias() {

		// arrange
		long valorDia = 2000;
		long valorHora = 500;
		int horas = 33;

		// act
		long resultado = servicioRegistrarSalidaVehiculo.cobrar(valorDia, valorHora, horas);

		// assert
		assertEquals(4000, resultado);

	}

	@Test
	public void generarCobroPorTresHorasCarro() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 6, 28, 15, 45);
		Date fechaIngreso = calendar.getTime();
		calendar.set(2019, 6, 28, 18, 45);
		Date fechaSalida = calendar.getTime();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conHoraEntrada(fechaIngreso).conHoraSalida(fechaSalida)
				.conTipo(Vehiculo.CARRO).build();

		// act
		servicioRegistrarSalidaVehiculo.cobrarPorTipoVehiculo(vehiculo);
		long cobro = vehiculo.getValorParqueo();

		// assert
		assertEquals(3000, cobro);

	}

	@Test
	public void generarCobroPorTresHorasMoto() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 6, 28, 15, 45);
		Date fechaIngreso = calendar.getTime();
		calendar.set(2019, 6, 28, 18, 45);
		Date fechaSalida = calendar.getTime();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conHoraEntrada(fechaIngreso).conHoraSalida(fechaSalida)
				.conTipo(Vehiculo.MOTO).build();

		// act
		servicioRegistrarSalidaVehiculo.cobrarPorTipoVehiculo(vehiculo);
		long cobro = vehiculo.getValorParqueo();

		// assert
		assertEquals(1500, cobro);

	}

	@Test
	public void generarCobroPorUnDiaCarro() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 6, 28, 15, 45);
		Date fechaIngreso = calendar.getTime();
		calendar.set(2019, 6, 29, 15, 45);
		Date fechaSalida = calendar.getTime();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conHoraEntrada(fechaIngreso).conHoraSalida(fechaSalida)
				.conTipo(Vehiculo.CARRO).build();

		// act
		servicioRegistrarSalidaVehiculo.cobrarPorTipoVehiculo(vehiculo);
		long cobro = vehiculo.getValorParqueo();

		// assert
		assertEquals(8000, cobro);

	}

	@Test
	public void generarCobroPorUnDiaMoto() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 6, 28, 15, 45);
		Date fechaIngreso = calendar.getTime();
		calendar.set(2019, 6, 29, 15, 45);
		Date fechaSalida = calendar.getTime();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conHoraEntrada(fechaIngreso).conHoraSalida(fechaSalida)
				.conTipo(Vehiculo.MOTO).build();

		// act
		servicioRegistrarSalidaVehiculo.cobrarPorTipoVehiculo(vehiculo);
		long cobro = vehiculo.getValorParqueo();

		// assert
		assertEquals(4000, cobro);
	}
	
	@Test
	public void generarCobroPorUnDiayCilindrajeMayorAQuinientosMoto() {
		// arrange
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 6, 28, 15, 45);
		Date fechaIngreso = calendar.getTime();
		calendar.set(2019, 6, 29, 15, 45);
		Date fechaSalida = calendar.getTime();
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conHoraEntrada(fechaIngreso).conHoraSalida(fechaSalida)
				.conTipo(Vehiculo.MOTO).conCilindraje(501).build();

		// act
		servicioRegistrarSalidaVehiculo.cobrarPorTipoVehiculo(vehiculo);
		long cobro = vehiculo.getValorParqueo();

		// assert
		assertEquals(6000, cobro);
	}

}
