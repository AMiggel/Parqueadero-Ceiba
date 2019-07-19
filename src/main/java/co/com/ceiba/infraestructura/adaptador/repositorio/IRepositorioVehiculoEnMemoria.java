package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

public interface IRepositorioVehiculoEnMemoria extends JpaRepository<Vehiculo, Integer>{

}
