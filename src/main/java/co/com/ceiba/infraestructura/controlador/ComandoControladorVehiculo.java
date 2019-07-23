package co.com.ceiba.infraestructura.controlador;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.manejador.ManejadorRegistrarVehiculo;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

@RestController
@RequestMapping("/parqueadero")
public class ComandoControladorVehiculo {
	
	private ManejadorRegistrarVehiculo manejadorRegistrarVehiculo;
	
	
	public ComandoControladorVehiculo(ManejadorRegistrarVehiculo manejadorRegistrarVehiculo) {
		this.manejadorRegistrarVehiculo = manejadorRegistrarVehiculo;
	}

	@PostMapping
	public void registrar(@RequestBody Vehiculo vehiculo) throws ExcepcionCondicionPrevia {
		
		this.manejadorRegistrarVehiculo.ejecutar(vehiculo);
	}
	
	
	
}
