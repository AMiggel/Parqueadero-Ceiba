package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculoParqueadero;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioVehiculoEnMemoria;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioRegistrarVehiculoParqueadero servicioRegistrarVehiculoParqueadero() {
		return new ServicioRegistrarVehiculoParqueadero(new RepositorioVehiculoEnMemoria());
	}

}
