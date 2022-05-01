package tqs.hw1.controler;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import tqs.hw1.entities.ControllerResponse;
import tqs.hw1.entities.CovidResponse;

@RequestMapping("")
@Controller
public class MainController {

    private final WebClient apiClient;

    @Autowired
    public MainController(){
        apiClient = WebClient.create("http://localhost:8080");
    }

    @GetMapping("/main")
    public String showMainPage(Model model){

        List<String> allCountries = apiClient.get()
                .uri("api/allCountries")
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(List.class))
                .block();

        model.addAllAttributes(Map.of(
                "allCountries", allCountries,
                "controllerResponse", new ControllerResponse()
        ));
        return "main";
    }

    @PostMapping("/main")
    public String search(@ModelAttribute ControllerResponse controllerResponse){
        if(controllerResponse.getCountry() == null || controllerResponse.getDate()==null){
            return "redirect:/main";
        }

        return "redirect:/response&country="+controllerResponse.getCountry()+"&day="+controllerResponse.getDate();
    }

    @GetMapping("/response&country={country}&day={day}")
    public String getResponseFromExternalAPI(@PathVariable String country, @PathVariable String day, Model model){

        CovidResponse covid_info = apiClient.get()
                .uri("api/data/"+country+"/"+day)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(CovidResponse.class))
                .block();

        if(covid_info == null){
            List<String> allCountries = apiClient.get()
                    .uri("api/allCountries")
                    .exchangeToMono(clientResponse -> clientResponse.bodyToMono(List.class))
                    .block();

            model.addAllAttributes(Map.of(
                    "allCountries", allCountries,
                    "controllerResponse", new ControllerResponse()
            ));
            
            return "main";
        }
        else {

            model.addAllAttributes(Map.of(
                    "covid_info", covid_info
            ));

            return "response";
        }
    }
}
