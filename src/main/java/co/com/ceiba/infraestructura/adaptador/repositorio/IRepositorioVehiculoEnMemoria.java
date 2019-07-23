package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.infraestructura.adaptador.entidad.EntidadVehiculo;

@Repository
public interface IRepositorioVehiculoEnMemoria extends JpaRepository<EntidadVehiculo, Integer>{
	
	//@Query("select ev from EntidadVehiculo p where p.placa = :placa")
	boolean findByPlaca(@Param("placa") String placa);


}
