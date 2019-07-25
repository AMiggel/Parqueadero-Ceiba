package co.com.ceiba.infraestructura.adaptador.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name = "vehiculos")
public class EntidadVehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -490731065330814251L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotEmpty
	private String tipoVehiculo;
	@NotEmpty
	private String placa;
	@NotNull
	private int cilindraje;
	@NotNull
	private Date horaEntrada;
	
	private Date horaSalida;

	
	public EntidadVehiculo() {

	}

	public EntidadVehiculo(int id, String tipoVehiculo, String placa, int cilindraje, Date horaEntrada,
			Date horaSalida) {

		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	
}
