package co.com.ceiba.infraestructura.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.EntidadVehiculo;

@Component
public class VehiculoMapper {
	
	public EntidadVehiculo mapEntidad(Vehiculo vehiculo) {
		
		return new EntidadVehiculo(vehiculo.getPlaca(),vehiculo.getTipoVehiculo(),vehiculo.getCilindraje());
	}
	
	public Vehiculo mapDominio(EntidadVehiculo entidadVehiculo) {
		return new Vehiculo(entidadVehiculo.getTipoVehiculo(),entidadVehiculo.getPlaca(), entidadVehiculo.getCilindraje());
		
	}
	
}
