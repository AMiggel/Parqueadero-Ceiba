package co.com.ceiba.dominio.modelo;

public class Parqueadero {
	

	private int id;
	private int espacioDisponibleCarros;
	private int espacioDisponibleMotos;
	
	
	public Parqueadero() {
		
	}
	
	public Parqueadero(int espacioDisponibleCarros, int espacioDisponibleMotos) {
		this.espacioDisponibleCarros = espacioDisponibleCarros;
		this.espacioDisponibleMotos = espacioDisponibleMotos;
	}
	
	public int getEspacioDisponibleCarros() {
		return espacioDisponibleCarros;
	}
	public int getEspacioDisponibleMotos() {
		return espacioDisponibleMotos;
	}
	public void setEspacioDisponibleCarros(int espacioDisponibleCarros) {
		this.espacioDisponibleCarros = espacioDisponibleCarros;
	}
	public void setEspacioDisponibleMotos(int espacioDisponibleMotos) {
		this.espacioDisponibleMotos = espacioDisponibleMotos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
