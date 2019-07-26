package co.com.ceiba.dominio.servicio;

import java.util.Date;

import co.com.ceiba.dominio.modelo.Vehiculo;

public class ServicioSalidaVehiculo {

	public static final long VALOR_HORA_CARRO = 1000;
	public static final long VALOR_HORA_MOTO = 500;
	public static final long VALOR_DIA_CARRO = 8000;
	public static final long VALOR_DIA_MOTO = 4000;
	public static final int CILINDRAJE_MINIMO_SIN_RECARGO_MOTO = 500;
	public static final long COBRO_POR_CILINDRAJE_MAYOR_QUINIENTOS = 2000;

	public void registrarSalidaVehiculos() {

	}

	public long cobrarTotalMoto(Vehiculo vehiculo) {
		
		long precioACobrar = 0;

		int horas = (int) calcularTotalHorasYDias(vehiculo.getHoraIngreso(), vehiculo.getHoraSalida());

		if (horas < 9 && vehiculo.getTipoVehiculo().equalsIgnoreCase(Vehiculo.MOTO)) {
			precioACobrar = VALOR_HORA_MOTO * horas;
		} else {
			cobrarPorDias(VALOR_DIA_MOTO, VALOR_HORA_MOTO, horas);
		}
		if (vehiculo.getCilindraje() > CILINDRAJE_MINIMO_SIN_RECARGO_MOTO
				&& vehiculo.getTipoVehiculo().equalsIgnoreCase(Vehiculo.MOTO)) {
			precioACobrar = precioACobrar + COBRO_POR_CILINDRAJE_MAYOR_QUINIENTOS;
		}
		return precioACobrar;

	}

	public long cobrarPorDias(long valorDiaTipoVehiculo, long valorHoraTipoVehiculo, int horas) {

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
		
		long totalHoras;
		totalHoras = ((fechaSalida.getTime() - fechaIngreso.getTime()) / 1000 / 3600);
		return totalHoras;

	}
}
