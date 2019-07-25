package co.com.ceiba.infraestructura.adaptador.repositorio.parqueadero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.EntidadParqueadero;

@Repository
public interface IRepositorioParqueaderoEnMemoria extends JpaRepository<EntidadParqueadero, Integer> {


}
