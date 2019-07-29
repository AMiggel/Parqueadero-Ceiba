package co.com.ceiba.aplicacion.manejador.consulta;


import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.dto.DtoVehiculo;
import co.com.ceiba.dominio.puerto.dao.DaoVehiculo;

@Component
public class ManejadorListarVehiculos {

	private DaoVehiculo daoVehiculo;
	
	public ManejadorListarVehiculos(DaoVehiculo daoVehiculo) {
		this.daoVehiculo= daoVehiculo;
	}
	
	public List<DtoVehiculo> ejecutar(){
		return this.daoVehiculo.listar();
		
	}
	
}
