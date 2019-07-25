package co.com.ceiba.infraestructura.adaptador.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EntidadParqueadero implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1921676756311356752L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int carrosParqueados;
	private int motosParqueadas;
	
	

	public EntidadParqueadero(int id, int carrosParqueados, int motosParqueadas) {
		this.id = id;
		this.carrosParqueados = carrosParqueados;
		this.motosParqueadas = motosParqueadas;
	}

	public int getCarrosParqueados() {
		return carrosParqueados;
	}

	public int getMotosParqueadas() {
		return motosParqueadas;
	}

	public void setCarrosParqueados(int carrosParqueados) {
		this.carrosParqueados = carrosParqueados;
	}

	public void setMotosParqueadas(int motosParqueadas) {
		this.motosParqueadas = motosParqueadas;
	}

}
