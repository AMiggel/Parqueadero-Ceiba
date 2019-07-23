package co.com.ceiba.infraestructura.adaptador.entidad;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class EntidadRegistroEnParqueadero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int cantidadVehiculos;
	
	@Temporal(TemporalType.DATE)
	private Date horaSalidaVehiculo;
	
	@Temporal(TemporalType.DATE)
	private Date horaEntradaVehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehiculo_id")
	EntidadVehiculo vehiculo;

	public EntidadRegistroEnParqueadero() {
	}
	
	
	public EntidadRegistroEnParqueadero( int cantidadVehiculos, Date horaSalidaVehiculo,
			Date horaEntradaVehiculo, EntidadVehiculo vehiculo) {
		this.cantidadVehiculos = cantidadVehiculos;
		this.horaSalidaVehiculo = horaSalidaVehiculo;
		this.horaEntradaVehiculo = horaEntradaVehiculo;
		this.vehiculo = vehiculo;
	}
	
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
	public EntidadVehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(EntidadVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	

	

}
