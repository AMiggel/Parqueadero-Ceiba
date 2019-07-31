package co.com.ceiba.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.dominio.constante.excepcion.ExcepcionRegistroParqueadero;
import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarVehiculo;

public class ServicioRegistrarVehiculo {

	private RepositorioRegistrarVehiculo repositorioRegistroVehiculo;

	public static final String PLACA_INICIA_CON_A = "No esta autorizado para ingresar";
	public static final String VEHICULO_PARQUEADO = "El vehiculo ya se encuentra parqueado";
	public static final String LIMITE_DE_CARROS_EXCEDIDO = "No se pueden parquear más carros";
	public static final String LIMITE_DE_MOTOS_EXCEDIDO = "No se pueden parquear más motos";
	public static final char INICIAL_PLACA_CON_RESTRICCION = 'A';
	public static final int ESPACIO_DISPONIBLE_CARROS = 20;
	public static final int ESPACIO_DISPONIBLE_MOTOS = 10;

	// constructor
	public ServicioRegistrarVehiculo(RepositorioRegistrarVehiculo repositorioVehiculo) {
		this.repositorioRegistroVehiculo = repositorioVehiculo;
	}

	public void ejecutar(Vehiculo vehiculo) {
		verificarCupoDisponibleCarro(vehiculo.getTipoVehiculo());
		verificarCupoDisponibleMoto(vehiculo.getTipoVehiculo());
		validarPlacaInicialConA(vehiculo.getPlaca().toUpperCase());
		vehiculo.setHoraIngreso(registrarHoraEntrada());
		this.repositorioRegistroVehiculo.registrarVehiculo(vehiculo);

	}
	
	public void validarPlacaInicialConA(String placa) {
		if (placa.charAt(0) == INICIAL_PLACA_CON_RESTRICCION) {
			if (LocalDateTime.now().getDayOfWeek() != DayOfWeek.SUNDAY
					|| LocalDateTime.now().getDayOfWeek() != DayOfWeek.MONDAY) {
				throw new ExcepcionRegistroParqueadero(PLACA_INICIA_CON_A);
			}
		}
	}

	public Date registrarHoraEntrada() {
		Calendar calendar = Calendar.getInstance();
		Date horaEntrada;
		horaEntrada = calendar.getTime();
		return horaEntrada;
	}

	public void verificarCupoDisponibleCarro(String tipoVehiculo) {
		int numeroCarrosParqueados = repositorioRegistroVehiculo.verificarEspacioDisponible(tipoVehiculo);		
		if (tipoVehiculo.equalsIgnoreCase(Vehiculo.CARRO) && numeroCarrosParqueados >= ESPACIO_DISPONIBLE_CARROS) {
			throw new ExcepcionRegistroParqueadero(LIMITE_DE_CARROS_EXCEDIDO);
		}
	}

	public void verificarCupoDisponibleMoto(String tipoVehiculo) {
		int numeroMotosParqueadas = repositorioRegistroVehiculo.verificarEspacioDisponible(tipoVehiculo);
		if (tipoVehiculo.equalsIgnoreCase(Vehiculo.MOTO) && numeroMotosParqueadas >= ESPACIO_DISPONIBLE_MOTOS) {
			throw new ExcepcionRegistroParqueadero(LIMITE_DE_MOTOS_EXCEDIDO);
		}
	}

}
