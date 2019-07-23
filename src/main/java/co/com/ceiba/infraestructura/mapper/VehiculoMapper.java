package co.com.ceiba.infraestructura.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.EntidadVehiculo;

@Component
public class VehiculoMapper {
	
	public EntidadVehiculo mappearAEntidad(Vehiculo vehiculo) {
		
		return new EntidadVehiculo(vehiculo.getId(),vehiculo.getTipoVehiculo(),vehiculo.getPlaca(),vehiculo.getCilindraje());
	}
	
	public Vehiculo mappearADominio(EntidadVehiculo entidadVehiculo) 
			throws ExcepcionValorObligatorio, ExcepcionRegistroParqueadero, ExcepcionLongitudDeValor {
		return new Vehiculo(entidadVehiculo.getTipoVehiculo(),entidadVehiculo.getPlaca(), entidadVehiculo.getCilindraje());
		
	}
	
	
	
}
