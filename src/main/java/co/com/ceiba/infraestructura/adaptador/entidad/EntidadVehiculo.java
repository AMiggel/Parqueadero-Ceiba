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

	private long cobroParqueo;

	public EntidadVehiculo() {

	}

	public EntidadVehiculo(int id, long cobroParqueo, String tipoVehiculo, String placa, int cilindraje,
			Date horaEntrada, Date horaSalida) {

		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.cobroParqueo = cobroParqueo;
	}


	public int getId() {
		return id;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public int getCilindraje() {
		return cilindraje;
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

	public long getCobroParqueo() {
		return cobroParqueo;
	}

}
