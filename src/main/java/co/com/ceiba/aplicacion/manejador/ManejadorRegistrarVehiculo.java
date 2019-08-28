package co.com.ceiba.aplicacion.manejador;

import co.com.ceiba.aplicacion.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarSalidaVehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;

public class ManejadorRegistrarVehiculo {

	private ServicioRegistrarVehiculo servicioRegistrarVehiculo;
	private ServicioRegistrarSalidaVehiculo servicioRegistrarSalidaVehiculo;
	private FabricaVehiculo fabricaVehiculo;

	

	public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo,
			ServicioRegistrarSalidaVehiculo servicioRegistrarSalidaVehiculo, FabricaVehiculo fabricaVehiculo) {
		this.servicioRegistrarVehiculo = servicioRegistrarVehiculo;
		this.servicioRegistrarSalidaVehiculo = servicioRegistrarSalidaVehiculo;
		this.fabricaVehiculo = fabricaVehiculo;
	}

	public void ejecutar(Vehiculo vehiculo) {
		Vehiculo vehiculoCreado = this.fabricaVehiculo.registrar(vehiculo);
		servicioRegistrarVehiculo.ejecutar(vehiculoCreado);
	}


	public Vehiculo actualizarSalida(String placa) {
		return servicioRegistrarSalidaVehiculo.registrarSalidaVehiculos(placa);
	}
}
