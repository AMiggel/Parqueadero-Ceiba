package co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.impl;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarSalidaVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.IRepositorioRegistrarVehiculoEnMemoria;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;

public class RepositorioRegistrarSalidaImpl implements RepositorioRegistrarSalidaVehiculo {

	private IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria;

	private VehiculoMapper vehiculoMapper;

	public RepositorioRegistrarSalidaImpl(IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria,
			VehiculoMapper vehiculoMapper) {

		this.repositorioVehiculoEnMemoria = repositorioVehiculoEnMemoria;
		this.vehiculoMapper = vehiculoMapper;
	}


	@Override
	public void asignarHoraSalidaVehiculo(Vehiculo vehiculo) {
		 repositorioVehiculoEnMemoria.save(vehiculoMapper.mappearAEntidad(vehiculo));
	}

	
}

