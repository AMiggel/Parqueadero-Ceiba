package co.com.ceiba.dominio.puerto.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;


public interface RepositorioRegistroVehiculo{

	public void  registrarVehiculo(Vehiculo vehiculo);
	public boolean parqueado (Vehiculo vehiculo);
}