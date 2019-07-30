package co.com.ceiba.infraestructura.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.modelo.dto.DtoVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.EntidadVehiculo;

@Component
public class VehiculoMapper {

	public EntidadVehiculo mappearAEntidad(Vehiculo vehiculo) {

		return new EntidadVehiculo(vehiculo.getId(), vehiculo.getValorParqueo(), vehiculo.getTipoVehiculo(),
				vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getHoraIngreso(), vehiculo.getHoraSalida());
	}

	public Vehiculo mappearADominio(EntidadVehiculo entidadVehiculo) {
		
		return new Vehiculo(entidadVehiculo.getId(), entidadVehiculo.getCobroParqueo(),
				entidadVehiculo.getTipoVehiculo(), entidadVehiculo.getPlaca(), entidadVehiculo.getCilindraje(),
				entidadVehiculo.getHoraEntrada(), entidadVehiculo.getHoraSalida());

	}

	public List<DtoVehiculo> mappearListaAEntidad(List<EntidadVehiculo> listaEntidadVehiculo) {
		List<DtoVehiculo> listaVehiculos = new ArrayList<>();

		for (EntidadVehiculo entidadVehiculo : listaEntidadVehiculo) {

			listaVehiculos.add(new DtoVehiculo(entidadVehiculo.getPlaca(), entidadVehiculo.getTipoVehiculo(),
					entidadVehiculo.getHoraEntrada()));
		}

		return listaVehiculos;
	}	
	
}
