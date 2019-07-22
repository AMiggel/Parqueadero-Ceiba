package co.com.ceiba.infraestructura.controlador;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorRegistrarVehiculo;

@RestController
@RequestMapping("/parqueadero")
public class ComandoControladorVehiculo {
	
	private ManejadorRegistrarVehiculo manejadorRegistrarVehiculo;
	
	
	public ComandoControladorVehiculo(ManejadorRegistrarVehiculo manejadorRegistrarVehiculo) {
		this.manejadorRegistrarVehiculo = manejadorRegistrarVehiculo;
	}

	@PostMapping
	public void registrar(@RequestBody ComandoVehiculo comandoVehiculo) {
		
		this.manejadorRegistrarVehiculo.ejecutar(comandoVehiculo);
	}
	
	
}
