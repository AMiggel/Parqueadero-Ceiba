package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorRegistrarVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.IRepositorioVehiculoEnMemoria;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioRegistroVehiculoEnMemoriaImpl;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioRegistrarVehiculo servicioRegistrarVehiculoParqueadero(
			IRepositorioVehiculoEnMemoria repositorioVehiculoEnMemoria) {
		
		return new ServicioRegistrarVehiculo(new RepositorioRegistroVehiculoEnMemoriaImpl(
				new VehiculoMapper(), repositorioVehiculoEnMemoria));
	}
	
	@Bean
	public ManejadorRegistrarVehiculo manejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo,
			FabricaVehiculo fabricaVehiculo) {
		return new ManejadorRegistrarVehiculo(servicioRegistrarVehiculo, fabricaVehiculo);
	}

}

