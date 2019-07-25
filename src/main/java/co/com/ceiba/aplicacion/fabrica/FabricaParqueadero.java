package co.com.ceiba.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.Parqueadero;

@Component
public class FabricaParqueadero {

	public Parqueadero registrar(Parqueadero parqueadero) {
		return new Parqueadero(parqueadero.getEspacioDisponibleCarros(),parqueadero.getEspacioDisponibleMotos());
	}
}
