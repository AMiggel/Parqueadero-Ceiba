package co.com.ceiba.dominio.modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Parqueadero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidadVehiculos;
	
	@Temporal(TemporalType.DATE)
	private Date horaSalidaVehiculo;
	
	@Temporal(TemporalType.DATE)
	private Date horaEntradaVehiculo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehiculo_id")
	private List<Vehiculo> vehiculos;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidadVehiculos() {
		return cantidadVehiculos;
	}
	public void setCantidadVehiculos(int cantidadVehiculos) {
		this.cantidadVehiculos = cantidadVehiculos;
	}
	public Date getHoraSalidaVehiculo() {
		return horaSalidaVehiculo;
	}
	public void setHoraSalidaVehiculo(Date horaSalidaVehiculo) {
		this.horaSalidaVehiculo = horaSalidaVehiculo;
	}
	public Date getHoraEntradaVehiculo() {
		return horaEntradaVehiculo;
	}
	public void setHoraEntradaVehiculo(Date horaEntradaVehiculo) {
		this.horaEntradaVehiculo = horaEntradaVehiculo;
	}
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	

	

}
