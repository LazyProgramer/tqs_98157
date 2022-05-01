package tqs.hw1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tqs.hw1.controler.RestApiController;
import tqs.hw1.service.CovidService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestApiController.class)
class CovidRestControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CovidService covidService;

	@Test
	void whenAskedForAllCountries_ReturnsAllCountries() throws Exception{

		mvc.perform(get("/api/allCountries"))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void whenValidRequest_ReturnsValidResponse() throws Exception {

		mvc.perform(get("/api/data/Portugal/2020-06-06"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}
}
