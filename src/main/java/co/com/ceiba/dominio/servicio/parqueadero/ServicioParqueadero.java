package co.com.ceiba.dominio.servicio.parqueadero;


import co.com.ceiba.dominio.modelo.Parqueadero;
import co.com.ceiba.dominio.puerto.repositorio.parqueadero.RepositorioParqueadero;

public class ServicioParqueadero {

	public static final int LIMITE_DE_CARROS_PARQUEADOS= 20;
	public static final int LIMITE_MOTOS_PARQUEADAS=10;
	public static final String LIMITE_DE_CARROS_EXCEDIDO= "No se pueden parquear más carros";
	public static final String MOTO= "MOTO";
	public static final String CARRO= "CARRO";

	RepositorioParqueadero repositorioParqueaderoTipoCarro;


	public ServicioParqueadero(RepositorioParqueadero repositorioParqueaderoTipoCarro) {
		this.repositorioParqueaderoTipoCarro = repositorioParqueaderoTipoCarro;
		
	}
	

	public void ocuparEspacioDisponible( Parqueadero parqueadero) {
		
	}
	
	}
	
	
