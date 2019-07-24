package co.com.ceiba.dominio.puerto.repositorio;

import co.com.ceiba.dominio.modelo.Vehiculo;


public interface RepositorioRegistroVehiculo{

	/**
	 * Permite registrar vehiculos en el parqueadero
	 * @param vehiculo
	 */
	public void  registrarVehiculo(Vehiculo vehiculo);
	
	
	/**
	 * Permite definir si el vehiculo esta parqueado o no
	 * @param placa
	 */
	
	public boolean parqueado (String placa);
}