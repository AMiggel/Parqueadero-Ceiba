package co.com.ceiba.dominio.puerto.repositorio;


import co.com.ceiba.dominio.modelo.Vehiculo;


public interface RepositorioRegistrarVehiculo{

	/**
	 * Permite registrar vehiculos en el parqueadero
	 * @param vehiculo
	 */
	public void  registrarVehiculo(Vehiculo vehiculo);
	
	
	/**
	 * Permite definir si el vehiculo esta parqueado o no
	 * @param placa
	 */
	public Vehiculo buscarVehiculoParqueado(String placa);
		
	/**
	 * devuelve el numero de vehiculos cuando la salida es null
	 * para saber cuantos hay en el parqueadero
	 * @param tipoVehiculo
	 */
	public int verificarEspacioDisponible(String tipoVehiculo);

}