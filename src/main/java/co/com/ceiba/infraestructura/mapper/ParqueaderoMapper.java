package co.com.ceiba.infraestructura.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.Parqueadero;
import co.com.ceiba.infraestructura.adaptador.entidad.EntidadParqueadero;

@Component
public class ParqueaderoMapper {

	public EntidadParqueadero mappearAEntidad(Parqueadero parqueadero) {
		
		return new EntidadParqueadero(parqueadero.getId(),
				parqueadero.getEspacioDisponibleCarros(),parqueadero.getEspacioDisponibleMotos());
		}
		
		public Parqueadero mappearADominio(EntidadParqueadero entidadParqueadero) {
			return new Parqueadero (entidadParqueadero.getCarrosParqueados(),entidadParqueadero.getMotosParqueadas());
			
		}
}
