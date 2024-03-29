package co.com.ceiba.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
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
	
	@PutMapping(value="/{placa}")
	public Vehiculo actualizarSalidaVehiculo(@PathVariable(value="placa")String placa) {
		return this.manejadorRegistrarVehiculo.actualizarSalida(placa);
		
	}
	
	@GetMapping(value="/vehiculos")
	public List<DtoVehiculo> mostrarListaVehiculos() {
		return this.manejadorListarVehiculos.ejecutar();
	}
	
}
