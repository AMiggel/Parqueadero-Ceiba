package co.com.ceiba.aplicacion.manejador;

import co.com.ceiba.aplicacion.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.servicio.vehiculo.ServicioRegistrarVehiculo;

public class ManejadorRegistrarVehiculo {

	private ServicioRegistrarVehiculo servicioRegistrarVehiculo;
	private FabricaVehiculo fabricaVehiculo;

	public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo,
			FabricaVehiculo fabricaVehiculo) {
		this.servicioRegistrarVehiculo = servicioRegistrarVehiculo;
		this.fabricaVehiculo = fabricaVehiculo;
	}

	public void ejecutar(Vehiculo vehiculo) {
		Vehiculo vehiculoCreado = this.fabricaVehiculo.registrar(vehiculo);
		servicioRegistrarVehiculo.ejecutar(vehiculoCreado);
	}

	public Vehiculo buscarVehiculosParqueados(String placa) {
		return servicioRegistrarVehiculo.buscarVehiculoParqueado(placa);
	}

	
}
