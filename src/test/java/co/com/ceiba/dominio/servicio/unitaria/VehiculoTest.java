package co.com.ceiba.dominio.servicio.unitaria;



import org.junit.Test;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarPlacaDebeSerObligatoria() {
		//Arrange
		VehiculoTestDataBuilder  vehiculoTestDataBuilder =new  VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conPlaca(null).build();
		
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validartipoVehiculoDebeSerObligatorio() {
		//Arrange
		VehiculoTestDataBuilder  vehiculoTestDataBuilder =new  VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conTipo(null).build();
		
	}
	
	@Test(expected = ExcepcionLongitudDeValor.class)
	public void validarLongitudPlacaDebeSerMinimoCincoCaracteres() {
		//Arrange
		VehiculoTestDataBuilder  vehiculoTestDataBuilder =new  VehiculoTestDataBuilder();
		vehiculoTestDataBuilder.conPlaca("ABC").build();
		
	}
	
}
