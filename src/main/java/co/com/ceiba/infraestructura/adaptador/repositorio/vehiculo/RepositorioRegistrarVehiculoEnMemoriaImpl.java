package co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo;



import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.vehiculo.RepositorioRegistrarVehiculo;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;


public class RepositorioRegistrarVehiculoEnMemoriaImpl implements RepositorioRegistrarVehiculo {
	
	
	private IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria;
	
	private VehiculoMapper vehiculoMapper;	
	
	public RepositorioRegistrarVehiculoEnMemoriaImpl(VehiculoMapper vehiculoMapper,
			IRepositorioRegistrarVehiculoEnMemoria repositorioVehiculoEnMemoria) {
		
		this.vehiculoMapper = vehiculoMapper;
		this.repositorioVehiculoEnMemoria= repositorioVehiculoEnMemoria;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		repositorioVehiculoEnMemoria.save(vehiculoMapper.mappearAEntidad(vehiculo));
		}

	@Override
	public Vehiculo buscarVehiculoParqueado(String placa) {
		return vehiculoMapper.mappearADominio(repositorioVehiculoEnMemoria.findByPlacaAndSalida(placa));
		 
	}

	}
	
