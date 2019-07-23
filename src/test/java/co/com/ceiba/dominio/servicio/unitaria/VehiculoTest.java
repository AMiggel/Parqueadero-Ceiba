package co.com.ceiba.dominio.servicio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.ValidadorArgumento;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarPlacaObligatoria() throws ExcepcionValorObligatorio, ExcepcionRegistroParqueadero, ExcepcionLongitudDeValor {
		//Arrange
		Vehiculo vehiculo =new  VehiculoTestDataBuilder().conPlaca("sad").build();
		
		assertEquals("La placa es un valor obligatorio", "sr" );
		}
		
		
	
}
