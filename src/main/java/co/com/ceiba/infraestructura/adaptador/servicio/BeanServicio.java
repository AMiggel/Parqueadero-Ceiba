package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.aplicacion.fabrica.FabricaVehiculo;
import co.com.ceiba.aplicacion.manejador.ManejadorRegistrarVehiculo;
import co.com.ceiba.dominio.servicio.parqueadero.ServicioParqueadero;
import co.com.ceiba.dominio.servicio.vehiculo.ServicioRegistrarVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.parqueadero.IRepositorioParqueaderoEnMemoria;
import co.com.ceiba.infraestructura.adaptador.repositorio.parqueadero.RepositorioParqueaderoEnMemoriaImpl;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.IRepositorioRegistrarVehiculoEnMemoria;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.RepositorioRegistrarVehiculoEnMemoriaImpl;
import co.com.ceiba.infraestructura.mapper.ParqueaderoMapper;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioRegistrarVehiculo servicioRegistrarVehiculoParqueadero(IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria) {
		
		return new ServicioRegistrarVehiculo(new RepositorioRegistrarVehiculoEnMemoriaImpl(
				new VehiculoMapper(), repositorioVehiculoEnMemoria));
	}
	@Bean 
	public ServicioParqueadero servicioParqueadero (IRepositorioParqueaderoEnMemoria repositorioParqueaderoEnMemoria) {
		return new ServicioParqueadero(new RepositorioParqueaderoEnMemoriaImpl(repositorioParqueaderoEnMemoria, new ParqueaderoMapper()));
		
	}
	
	@Bean
	public ManejadorRegistrarVehiculo manejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo,
			FabricaVehiculo fabricaVehiculo) {
		return new ManejadorRegistrarVehiculo(servicioRegistrarVehiculo, fabricaVehiculo);
	}

}

