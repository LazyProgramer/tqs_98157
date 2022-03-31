package lab3_2.CarService.lab3_2;

import org.springframework.http.MediaType;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

@WebMvcTest(CarController.class)
public class CarControllerTests {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    private Car ford;
    @BeforeEach
    public void setUp() throws Exception {
        ford = new Car("Ford", "2014 Tauros");
        ford.setCarID(111L);
    }

    @Test
    void whenPostCar_thenCreateCar() throws Exception {
        when(service.save(Mockito.any())).thenReturn(ford);

        mvc.perform(
                post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(ford)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("Ford")));

        verify(service,times(1)).save(Mockito.any());

    }

    @Test
    public void whenGetCars_thenReturnJsonArray() throws Exception {
        Car audi = new Car("Audi", "Audi A8");
        Car bmw = new Car("BMW", "BMW M4");

        List<Car> allCars = Arrays.asList(ford, audi, bmw);

        when(service.getAllCars()).thenReturn(allCars);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].maker", is(ford.getMaker()))).andExpect(jsonPath("$[1].maker", is(audi.getMaker())))
            .andExpect(jsonPath("$[2].maker", is(bmw.getMaker())));

        verify(service, VerificationModeFactory.times(1)).getAllCars();

    }
    
    @Test
    public void whenGetCar_thenReturnJson() throws Exception{
        when(service.getCarDetails(111L)).thenReturn(Optional.of(ford));

        mvc.perform(get("/api/cars&carId=111").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(ford)))
            .andExpect(status().isOk()).andExpect(jsonPath("$.maker", is(ford.getMaker())))
            .andExpect(jsonPath("$.model", is(ford.getModel())));
        
        verify(service, times(1)).getCarDetails(111L);
    }
}
