package co.com.ceiba.dominio.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


@Entity
public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -846349415532542655L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String tipoVehiculo;
	@NotEmpty
	private String placa;
	
	private int cilindraje;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy= "parqueadero")
	private Parqueadero parqueadero;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
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
	

}
