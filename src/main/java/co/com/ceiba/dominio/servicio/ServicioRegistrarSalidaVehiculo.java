package co.com.ceiba.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarSalidaVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistrarVehiculo;

public class ServicioRegistrarSalidaVehiculo {

	public static final String VEHICULO_SALIO = "El vehiculo ya salio";
	public static final long VALOR_HORA_CARRO = 1000;
	public static final long VALOR_HORA_MOTO = 500;
	public static final long VALOR_DIA_CARRO = 8000;
	public static final long VALOR_DIA_MOTO = 4000;
	public static final int CILINDRAJE_MINIMO_SIN_RECARGO_MOTO = 500;
	public static final long COBRO_POR_CILINDRAJE_MAYOR_QUINIENTOS = 2000;

	private RepositorioRegistrarSalidaVehiculo repositorioRegistrarSalidaVehiculo;
	private RepositorioRegistrarVehiculo repositorioRegistrarVehiculo;

	public ServicioRegistrarSalidaVehiculo(RepositorioRegistrarSalidaVehiculo repositorioRegistrarSalidaVehiculo,
			RepositorioRegistrarVehiculo repositorioRegistrarVehiculo) {
		this.repositorioRegistrarSalidaVehiculo = repositorioRegistrarSalidaVehiculo;
		this.repositorioRegistrarVehiculo = repositorioRegistrarVehiculo;
	}

	public void registrarSalidaVehiculos(String vehiculoActual) {
		Calendar calendar = Calendar.getInstance();
		Vehiculo vehiculo = repositorioRegistrarVehiculo.buscarVehiculoParqueado(vehiculoActual);
		vehiculo.setHoraSalida(calendar.getTime());
		cobrarPorTipoVehiculo(vehiculo);
		repositorioRegistrarSalidaVehiculo.asignarHoraSalidaVehiculo(vehiculo);
	}
	

	public void cobrarPorTipoVehiculo(Vehiculo vehiculo) {
		int horas = (int) calcularTotalHorasYDias(vehiculo.getHoraIngreso(), vehiculo.getHoraSalida());

		if (vehiculo.getTipoVehiculo().equalsIgnoreCase(Vehiculo.CARRO)) {
			vehiculo.setValorParqueo(cobrar(VALOR_DIA_CARRO, VALOR_HORA_CARRO, horas));
		} else if (vehiculo.getTipoVehiculo().equalsIgnoreCase(Vehiculo.MOTO) && vehiculo.getCilindraje() > 500) {
			vehiculo.setValorParqueo(
					cobrar(VALOR_DIA_MOTO, VALOR_HORA_MOTO, horas) + COBRO_POR_CILINDRAJE_MAYOR_QUINIENTOS);
		} else {
			vehiculo.setValorParqueo(cobrar(VALOR_DIA_MOTO, VALOR_HORA_MOTO, horas));
		}

	}

	public long cobrar(long valorDiaTipoVehiculo, long valorHoraTipoVehiculo, int horas) {

		int dias = horas / 24;
		long horaRestantePorDia = horas % 24;
		long precioACobrar = 0;

		if (horaRestantePorDia == 0) {
			precioACobrar = valorDiaTipoVehiculo * dias;
		} else {
			precioACobrar = valorDiaTipoVehiculo * dias;
			if (horaRestantePorDia < 9) {
				precioACobrar = precioACobrar + ((horaRestantePorDia) * valorHoraTipoVehiculo);
			} else {
				precioACobrar = precioACobrar + valorDiaTipoVehiculo;
			}
		}

		return precioACobrar;
	}

	public long calcularTotalHorasYDias(Date fechaIngreso, Date fechaSalida) {

		long horas;
		horas = ((fechaSalida.getTime() - fechaIngreso.getTime()) / 1000 / 3600);
		if (horas <= 1) {
			horas = 1;
		} else if (horas <= 9) {
			horas = (long) Math.floor(horas);
		}
		return horas;
	}
}
