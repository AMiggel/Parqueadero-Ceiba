package co.com.ceiba.infraestructura.adaptador.repositorio.parqueadero;


import co.com.ceiba.dominio.modelo.Parqueadero;
import co.com.ceiba.dominio.puerto.repositorio.parqueadero.RepositorioParqueadero;
import co.com.ceiba.infraestructura.mapper.ParqueaderoMapper;

public class RepositorioParqueaderoEnMemoriaImpl implements RepositorioParqueadero {

	IRepositorioParqueaderoEnMemoria repositorioParqueaderoEnMemoria;
	ParqueaderoMapper parqueaderoMapper;
	
	
	public RepositorioParqueaderoEnMemoriaImpl(IRepositorioParqueaderoEnMemoria repositorioParqueaderoEnMemoria,
			ParqueaderoMapper parqueaderoMapper) {
		this.repositorioParqueaderoEnMemoria = repositorioParqueaderoEnMemoria;
		this.parqueaderoMapper= parqueaderoMapper;
	}



	@Override
	public void registrarEspacioOcupadoCarros(Parqueadero parqueadero) {
		repositorioParqueaderoEnMemoria.save(parqueaderoMapper.mappearAEntidad(parqueadero));
		
	}


}
