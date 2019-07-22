package co.com.ceiba.infraestructura.adaptador.repositorio;


import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;


public class RepositorioRegistroVehiculoEnMemoriaImpl implements RepositorioRegistroVehiculo {
	
	
	private IRepositorioVehiculoEnMemoria repositorioVehiculoEnMemoria;
	
	private VehiculoMapper vehiculoMapper;	
	
	public RepositorioRegistroVehiculoEnMemoriaImpl(VehiculoMapper vehiculoMapper,
			IRepositorioVehiculoEnMemoria repositorioVehiculoEnMemoria) {
		
		this.vehiculoMapper = vehiculoMapper;
		this.repositorioVehiculoEnMemoria= repositorioVehiculoEnMemoria;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		repositorioVehiculoEnMemoria.save(vehiculoMapper.mappearAEntidad(vehiculo));
		}

	@Override
	public boolean parqueado(String placa) {
		return repositorioVehiculoEnMemoria.findByPlaca(placa);
		 
	}



	
}