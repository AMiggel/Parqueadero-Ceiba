package co.com.ceiba.infraestructura.controlador;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.manejador.ManejadorRegistrarVehiculo;
import co.com.ceiba.dominio.modelo.Vehiculo;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parqueadero")
public class ControladorRegistrarVehiculo {
	
	private ManejadorRegistrarVehiculo manejadorRegistrarVehiculo;
	
	
	public ControladorRegistrarVehiculo(ManejadorRegistrarVehiculo manejadorRegistrarVehiculo) {
		this.manejadorRegistrarVehiculo = manejadorRegistrarVehiculo;
	}

	@PostMapping
	public void registrar(@RequestBody Vehiculo vehiculo) {
		
		this.manejadorRegistrarVehiculo.ejecutar(vehiculo);
	}
	
	@GetMapping(value = "/{placa}")
	@ApiOperation("buscarCarroParqueado")
	public 	Vehiculo buscarCarroParqueado(@PathVariable(value ="placa")String placa) {
		return this.manejadorRegistrarVehiculo.buscarVehiculosParqueados(placa);
	}
	
	
}
