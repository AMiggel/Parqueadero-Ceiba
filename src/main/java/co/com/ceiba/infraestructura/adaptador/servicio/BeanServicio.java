package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.aplicacion.fabrica.FabricaVehiculo;
import co.com.ceiba.aplicacion.manejador.ManejadorRegistrarVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarSalidaVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.IRepositorioRegistrarVehiculoEnMemoria;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.impl.RepositorioRegistrarSalidaImpl;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.impl.RepositorioRegistrarVehiculoEnMemoriaImpl;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioRegistrarVehiculo servicioRegistrarVehiculoParqueadero(
			IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria) {

		return new ServicioRegistrarVehiculo(
				new RepositorioRegistrarVehiculoEnMemoriaImpl(new VehiculoMapper(), repositorioVehiculoEnMemoria));
	}

	@Bean
	public ServicioRegistrarSalidaVehiculo servicioRegistrarSalidaVehiculo(
			IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria) {
		return new ServicioRegistrarSalidaVehiculo(
				new RepositorioRegistrarSalidaImpl(repositorioVehiculoEnMemoria, new VehiculoMapper()),
				new RepositorioRegistrarVehiculoEnMemoriaImpl(new VehiculoMapper(), repositorioVehiculoEnMemoria));

	}

	@Bean
	public ManejadorRegistrarVehiculo manejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo,
			FabricaVehiculo fabricaVehiculo, ServicioRegistrarSalidaVehiculo servicioRegistrarSalidaVehiculo) {
		return new ManejadorRegistrarVehiculo(servicioRegistrarVehiculo, servicioRegistrarSalidaVehiculo,fabricaVehiculo);
	}

}
