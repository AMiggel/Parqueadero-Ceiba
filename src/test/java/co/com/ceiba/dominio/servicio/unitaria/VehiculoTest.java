package co.com.ceiba.dominio.servicio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	@Test
	public void validarPlacaDebeSerObligatoria() {
		// Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();

		// act
		try {
			vehiculoTestDataBuilder.conPlaca(null).build();
			fail();
			// assert
		} catch (ExcepcionValorObligatorio e) {
			assertEquals(Vehiculo.PLACA_ES_VALOR_OBLIGATORIO, e.getMessage());
		}

	}

	@Test
	public void validartipoVehiculoDebeSerObligatorio() {
		// Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();

		// act
		try {
			vehiculoTestDataBuilder.conTipo(null).build();
			fail();
			// assert
		} catch (ExcepcionValorObligatorio e) {
			assertEquals(Vehiculo.TIPO_VEHICULO_ES_VALOR_OBLIGATORIO, e.getMessage());
		}

	}

	@Test
	public void validarLongitudPlacaDebeSerMinimoCincoCaracteres() {
		// Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();

		// act
		try {
			vehiculoTestDataBuilder.conPlaca("ABC").build();
			fail();
		// assert
		} catch (ExcepcionLongitudDeValor e) {
			assertEquals(Vehiculo.LA_LONGITUD_DE_PLACA_ES_MAYOR, e.getMessage());
		}

	}

}
