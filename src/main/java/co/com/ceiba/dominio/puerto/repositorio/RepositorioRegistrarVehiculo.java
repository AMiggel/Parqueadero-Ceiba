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
		
	public int verificarEspacioDisponible(String tipoVehiculo);

}