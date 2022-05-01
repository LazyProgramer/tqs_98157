package tqs.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import tqs.hw1.cache.Cache;
import tqs.hw1.entities.CovidResponse;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CacheTests {

    private Cache covidCache;

    @BeforeEach
    public void setUp(){covidCache = new Cache();}

    @Test
    public void whenValidRequestMade_ReturnCorrectResult(){
        covidCache.addNewItem("Portugal-2020-06-06", "Expected response");
        String cacheResponse = (String) covidCache.getItem("Portugal-2020-06-06");
        assertThat(cacheResponse).isEqualTo("Expected response");
    }

    @Test
    public void whenInvalidRequestMade_ReturnNoResult(){
        CovidResponse cacheResponse = (CovidResponse) covidCache.getItem("Portugal-2020-06-06");
        assertThat(cacheResponse).isEqualTo(null);
    }
}
