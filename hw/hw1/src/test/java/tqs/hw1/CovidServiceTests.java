package tqs.hw1;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tqs.hw1.controler.RestApiController;
import tqs.hw1.entities.CovidResponse;
import tqs.hw1.service.CovidService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CovidServiceTests {

    @InjectMocks
    private CovidService covidService;

    @Test
    public void whenValidRequestMade_ReturnCorrectResult(){
        CovidResponse portugalInfo = covidService.getCovidInfoFromCountry("Portugal", "2020-06-06");
        assertThat("Portugal").isEqualTo(portugalInfo.getCountry());
        assertThat("2020-06-06").isEqualTo(portugalInfo.getDay());
    }

    @Test
    public void whenInvalidRequestMade_ReturnNoResult(){
        CovidResponse fromService = covidService.getCovidInfoFromCountry("Madrid", "2020-02-13");
        assertThat(fromService).isEqualTo(null);
    }
}
