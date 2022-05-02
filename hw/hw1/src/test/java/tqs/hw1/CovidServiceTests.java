package tqs.hw1;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import tqs.hw1.cache.Cache;
import tqs.hw1.entities.CovidResponse;
import tqs.hw1.service.CovidService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CovidServiceTests {

    @Mock
    private Cache cache;

    @InjectMocks
    private CovidService covidService;

    @Test
    void whenValidRequestMade_ReturnCorrectResult(){
        CovidResponse portugalInfo = covidService.getCovidInfoFromCountry("Portugal", "2020-06-06");
        assertThat(portugalInfo.getCountry()).isEqualTo("Portugal");
        assertThat(portugalInfo.getDay()).isEqualTo("2020-06-06");
    }

    @Test
    void whenInvalidRequestMade_ReturnNoResult(){
        CovidResponse fromService = covidService.getCovidInfoFromCountry("Madrid", "2020-02-13");
        assertThat(fromService).isNull();
        fromService = covidService.getCovidInfoFromCountry(null, "2020-02-13");
        assertThat(fromService).isNull();
    }
}
