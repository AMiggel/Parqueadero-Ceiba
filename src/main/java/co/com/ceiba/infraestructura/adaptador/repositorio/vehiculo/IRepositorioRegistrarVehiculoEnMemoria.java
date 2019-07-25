package co.com.ceiba.infraestructura.adaptador.repositorio.vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.EntidadVehiculo;

@Repository
public interface IRepositorioRegistrarVehiculoEnMemoria extends JpaRepository<EntidadVehiculo, Integer>{
	
	@Query("select p from vehiculos p where p.placa = :placa and p.horaSalida = null")
	EntidadVehiculo findByPlacaAndSalida(@Param("placa")String placa);
}
 