package co.com.ceiba.aplicacion.comando.manejador;


import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;

public class ManejadorRegistrarVehiculo  {
	
	private ServicioRegistrarVehiculo servicioRegistrarVehiculo;
	private FabricaVehiculo fabricaVehiculo;
	
	public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo,
			FabricaVehiculo fabricaVehiculo) {
		this.servicioRegistrarVehiculo= servicioRegistrarVehiculo;
		this.fabricaVehiculo= fabricaVehiculo;
	}
	
	public void ejecutar(ComandoVehiculo comandoVehiculo) throws ExcepcionCondicionPrevia {
		Vehiculo vehiculo= this.fabricaVehiculo.registrar(comandoVehiculo);
	   servicioRegistrarVehiculo.ejecutar(vehiculo);
	}
}
