package co.com.ceiba.infraestructura.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.dto.DtoVehiculo;
import co.com.ceiba.dominio.puerto.dao.DaoVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo.IRepositorioRegistrarVehiculoEnMemoria;
import co.com.ceiba.infraestructura.mapper.VehiculoMapper;

@Repository
public class daoVehiculoEnMemoria implements DaoVehiculo {
	
	private VehiculoMapper vehiculoMapper;
	private IRepositorioRegistrarVehiculoEnMemoria repositorioRegistrarVehiculoEnMemoria;
	
	

	public daoVehiculoEnMemoria(VehiculoMapper vehiculoMapper,
			IRepositorioRegistrarVehiculoEnMemoria repositorioRegistrarVehiculoEnMemoria) {
		this.vehiculoMapper = vehiculoMapper;
		this.repositorioRegistrarVehiculoEnMemoria= repositorioRegistrarVehiculoEnMemoria;
	}


	@Override
	public List<DtoVehiculo> listar() {
		return vehiculoMapper.mappearListaADominio(repositorioRegistrarVehiculoEnMemoria.findAll());
	}

}
