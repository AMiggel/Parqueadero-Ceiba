package co.com.ceiba.dominio.servicio.integracion;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.dominio.modelo.Vehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ControladorVehiculoTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void registrarVehiculoEnParqueadero() throws Exception {

		Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
		mockMvc.perform(MockMvcRequestBuilders.post("/parqueadero").contentType(MediaType.APPLICATION_JSON)
				.content(convertirJsonAString(vehiculo))).andExpect(status().isOk());
	}

	@Test
	public void registrarSalidaVehiculo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/parqueadero/" + "CXS123").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listarVehiculosParqueados() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/parqueadero/" + "vehiculos").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void consultarVehiculoParqueado() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/parqueadero/" + "CXS123").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


	private String convertirJsonAString(Vehiculo contenido) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(contenido);
	}

}
