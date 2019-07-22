package co.com.ceiba.infraestructura.adaptador.repositorio;


import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;


public class RepositorioVehiculoEnMemoriaImpl implements RepositorioVehiculo {
	
	@Autowired
	private IRepositorioVehiculoEnMemoria repositorioVehiculoEnMemoria;
	
	private VehiculoMapper vehiculoMapper;
	
	

	public RepositorioVehiculoEnMemoriaImpl(VehiculoMapper vehiculoMapper) {
		this.vehiculoMapper = vehiculoMapper;
	}



	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		repositorioVehiculoEnMemoria.save(vehiculoMapper.mapEntidad(vehiculo));
		System.out.println("guardado");

	}

	

}