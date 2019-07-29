package co.com.ceiba.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.manejador.ManejadorRegistrarVehiculo;
import co.com.ceiba.aplicacion.manejador.consulta.ManejadorListarVehiculos;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.modelo.dto.DtoVehiculo;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parqueadero")
public class ControladorRegistrarVehiculo {
	
	private ManejadorRegistrarVehiculo manejadorRegistrarVehiculo;
	private ManejadorListarVehiculos manejadorListarVehiculos;
	
	
	public ControladorRegistrarVehiculo(ManejadorRegistrarVehiculo manejadorRegistrarVehiculo,
			ManejadorListarVehiculos manejadorListarVehiculos) {
		this.manejadorRegistrarVehiculo = manejadorRegistrarVehiculo;
		this.manejadorListarVehiculos= manejadorListarVehiculos;
	}

	@PostMapping
	public void registrar(@RequestBody Vehiculo vehiculo) {
		
		this.manejadorRegistrarVehiculo.ejecutar(vehiculo);
	}
	
	@GetMapping(value = "/{placa}")
	public Vehiculo buscarCarroParqueado(@PathVariable(value ="placa")String placa) {
		return this.manejadorRegistrarVehiculo.buscarVehiculosParqueados(placa);
	}
	
	@PutMapping(value="/{placa}")
	public void actualizarSalidaVehiculo(@PathVariable(value="placa")String placa,
			@RequestBody Vehiculo vehiculo) {
		this.manejadorRegistrarVehiculo.actualizarSalida(vehiculo);
		
	}
	
	@GetMapping(value="/vehiculos")
	public List<DtoVehiculo> mostrarListaVehiculos() {
		return this.manejadorListarVehiculos.ejecutar();
	}
	
}
