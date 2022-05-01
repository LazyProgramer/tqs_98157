package tqs.hw1.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tqs.hw1.entities.CovidResponse;
import tqs.hw1.service.CovidService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private CovidService covidService;

    @CrossOrigin
    @GetMapping("/allCountries")
    public List<String> getAllCountries(){

        List<String> allCountries = covidService.getAllContries();

        return allCountries;
    }

    @CrossOrigin
    @GetMapping("/data/{country}/{day}")
    public CovidResponse getCountrysCovidInfo(
            @PathVariable(required = true, name = "country") String country,
            @PathVariable(required = true, name = "day") String day){

        CovidResponse covidResponse = covidService.getCovidInfoFromCountry(country, day);

        return covidResponse;
    }
}
