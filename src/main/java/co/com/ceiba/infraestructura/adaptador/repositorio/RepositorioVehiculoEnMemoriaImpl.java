package co.com.ceiba.infraestructura.adaptador.repositorio;


import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;


public class RepositorioVehiculoEnMemoriaImpl implements RepositorioVehiculo {
	
	
	private IRepositorioVehiculoEnMemoria repositorioVehiculoEnMemoria;
	
	private VehiculoMapper vehiculoMapper;	

	public RepositorioVehiculoEnMemoriaImpl(VehiculoMapper vehiculoMapper,IRepositorioVehiculoEnMemoria repositorioVehiculoEnMemoria) {
		this.vehiculoMapper = vehiculoMapper;
		this.repositorioVehiculoEnMemoria= repositorioVehiculoEnMemoria;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		repositorioVehiculoEnMemoria.save(vehiculoMapper.mappearAEntidad(vehiculo));
		}

}