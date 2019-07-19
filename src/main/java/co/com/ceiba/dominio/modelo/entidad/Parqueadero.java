package co.com.ceiba.dominio.modelo.entidad;

import java.util.Date;


public class Parqueadero {

	
	private int id;
	private int cantidadVehiculos;
	private Date horaSalidaVehiculo;
	private Date horaEntradaVehiculo;
	
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
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	

	

}
