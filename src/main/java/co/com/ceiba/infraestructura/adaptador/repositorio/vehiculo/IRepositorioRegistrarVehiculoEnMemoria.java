package co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.infraestructura.adaptador.entidad.EntidadVehiculo;

@Repository
public interface IRepositorioRegistrarVehiculoEnMemoria extends JpaRepository<EntidadVehiculo, Integer>{
	
	@Query("select v from vehiculos v where v.placa = :placa")
	EntidadVehiculo buscarPorPlacaAndSalida(@Param("placa")String placa);
	
	@Query("select count(v.id) from vehiculos v where v.tipoVehiculo = :tipoVehiculo and v.horaSalida is null")
	int contarEspacioDisponiblePorTipo(@Param("tipoVehiculo") String tipoVehiculo);
	
	@Query("select v from vehiculos v where v.horaSalida is null")
	List<EntidadVehiculo> listar();

	
}
 