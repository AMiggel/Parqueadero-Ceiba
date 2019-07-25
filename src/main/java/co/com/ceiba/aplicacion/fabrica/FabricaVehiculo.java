package co.com.ceiba.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.Vehiculo;

@Component
public class FabricaVehiculo {
	
	public Vehiculo registrar(Vehiculo vehiculo) {
		return new Vehiculo(vehiculo.getTipoVehiculo(),vehiculo.getPlaca(),vehiculo.getCilindraje(),
				vehiculo.getHoraIngreso(),vehiculo.getHoraSalida());
	}
}
