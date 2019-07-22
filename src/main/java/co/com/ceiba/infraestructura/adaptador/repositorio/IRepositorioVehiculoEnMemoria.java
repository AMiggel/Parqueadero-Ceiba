package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.infraestructura.adaptador.entidad.EntidadVehiculo;

@Repository
public interface IRepositorioVehiculoEnMemoria extends JpaRepository<EntidadVehiculo, Integer>{

}
