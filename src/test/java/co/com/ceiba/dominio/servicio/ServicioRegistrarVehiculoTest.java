package co.com.ceiba.dominio.servicio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioRegistrarVehiculoTest {

	ServicioRegistrarVehiculo servicioRegistrarVehiculo;
	
	
	
	@Test
	public void validarSiEstaParqueado() {
		//Arrange
		Vehiculo vehiculo =new  VehiculoTestDataBuilder().build();
		RepositorioRegistroVehiculo repositorioRegistroVehiculo = Mockito.mock(RepositorioRegistroVehiculo.class);
		Mockito.when(repositorioRegistroVehiculo.parqueado(vehiculo.getPlaca())).thenReturn(true);
		
		//act
		servicioRegistrarVehiculo= new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);
		//assert
		try {
			servicioRegistrarVehiculo.verificarVehiculoParqueado(vehiculo.getPlaca());
		} catch (ExcepcionCondicionPrevia e) {
		assertEquals("El vehiculo ya se encuentra parqueado", e.getMessage());
		}
	}
	

	@Test
	public void validarSiEsCarroOMoto() {
		//Arrange
		Vehiculo vehiculo =new  VehiculoTestDataBuilder().build();
		RepositorioRegistroVehiculo repositorioRegistroVehiculo = Mockito.mock(RepositorioRegistroVehiculo.class);
		Mockito.when(repositorioRegistroVehiculo.parqueado(vehiculo.getTipoVehiculo()));
		
		//act
		servicioRegistrarVehiculo= new ServicioRegistrarVehiculo(repositorioRegistroVehiculo);
		//assert
		try {
			servicioRegistrarVehiculo.validarTipoVehiculo(vehiculo.getTipoVehiculo());
		} catch (ExcepcionCondicionPrevia e) {
		assertEquals("Solo se permiten Carros y Motos", e.getMessage());
		}
	}
}
