package co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.impl;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.IRepositorioRegistrarVehiculoEnMemoria;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;

public class RepositorioRegistrarVehiculoEnMemoriaImpl implements RepositorioRegistrarVehiculo {

	private IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria;

	private VehiculoMapper vehiculoMapper;

	public RepositorioRegistrarVehiculoEnMemoriaImpl(VehiculoMapper vehiculoMapper,
			IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria) {

		this.vehiculoMapper = vehiculoMapper;
		this.repositorioVehiculoEnMemoria = repositorioVehiculoEnMemoria;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		repositorioVehiculoEnMemoria.save(vehiculoMapper.mappearAEntidad(vehiculo));
	}

	@Override
	public Vehiculo buscarVehiculoParqueado(String placa) {
		return vehiculoMapper.mappearADominio(repositorioVehiculoEnMemoria.buscarPorPlacaAndSalida(placa));

	}

	@Override
	public int verificarEspacioDisponible(String tipoVehiculo) {
		return this.repositorioVehiculoEnMemoria.contarEspacioDisponiblePorTipo(tipoVehiculo);
	}

	
}
