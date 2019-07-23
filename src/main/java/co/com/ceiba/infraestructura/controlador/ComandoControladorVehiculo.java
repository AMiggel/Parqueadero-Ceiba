package co.com.ceiba.infraestructura.controlador;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.manejador.ManejadorRegistrarVehiculo;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionLongitudDeValor;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.Vehiculo;

@RestController
@RequestMapping("/parqueadero")
public class ComandoControladorVehiculo {
	
	private ManejadorRegistrarVehiculo manejadorRegistrarVehiculo;
	
	
	public ComandoControladorVehiculo(ManejadorRegistrarVehiculo manejadorRegistrarVehiculo) {
		this.manejadorRegistrarVehiculo = manejadorRegistrarVehiculo;
	}

	@PostMapping
	public void registrar(@RequestBody Vehiculo vehiculo) throws ExcepcionValorObligatorio,
	ExcepcionRegistroParqueadero, ExcepcionLongitudDeValor {
		
		this.manejadorRegistrarVehiculo.ejecutar(vehiculo);
	}
	
	
	
}
