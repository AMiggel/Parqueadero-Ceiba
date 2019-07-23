package co.com.ceiba.aplicacion.manejador;



import co.com.ceiba.dominio.constante.excepcion.ExcepcionCondicionPrevia;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioRegistrarVehiculo;

public class ManejadorRegistrarVehiculo  {
	
	private ServicioRegistrarVehiculo servicioRegistrarVehiculo;

	
	public ManejadorRegistrarVehiculo(ServicioRegistrarVehiculo servicioRegistrarVehiculo) {
		this.servicioRegistrarVehiculo= servicioRegistrarVehiculo;
		
	}
	
	public void ejecutar(Vehiculo vehiculo) throws ExcepcionCondicionPrevia {
		
	   servicioRegistrarVehiculo.ejecutar(vehiculo);
	}
	
}
