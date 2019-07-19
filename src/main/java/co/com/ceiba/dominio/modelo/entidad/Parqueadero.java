package co.com.ceiba.dominio.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parqueadero implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -842091395624700456L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private int cantidadVehiculos;
	private Date horaSalidaVehiculo;
	private Date horaEntradaVehiculo;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Vehiculo vehiculo;
	
	
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

	

}
