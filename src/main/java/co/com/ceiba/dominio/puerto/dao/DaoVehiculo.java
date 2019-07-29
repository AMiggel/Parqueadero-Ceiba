package co.com.ceiba.dominio.puerto.dao;


import java.util.List;

import co.com.ceiba.dominio.modelo.dto.DtoVehiculo;

public interface DaoVehiculo {
	/**
	 * permite listar vehiculos;
	 * @return
	 */
	
	List<DtoVehiculo> listar();

}
