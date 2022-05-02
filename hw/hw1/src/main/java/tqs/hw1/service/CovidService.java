package tqs.hw1.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tqs.hw1.cache.Cache;
import tqs.hw1.entities.CovidResponse;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CovidService {

    private final Cache storage = new Cache();

    Logger logger = LoggerFactory.getLogger(CovidService.class);

    private final WebClient apiClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .defaultHeader("content-type", "application/json")
            .build();

    public List<String> getAllContries(){

        String cache_key = "allCountries";

        if (storage.checkIfHasResponse(cache_key)){
            return (List<String>) storage.getItem(cache_key);
        }
        else {
            String external_response = apiClient.get()
                    .uri("https://covid-193.p.rapidapi.com/countries")
                    .header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "277534bdeemsh0fbcf0bce8fe037p18934ejsnb631c30372c9")
                    .exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class))
                    .block();

            Gson gson = new Gson();
            JsonObject jsonResp = gson.fromJson(external_response, JsonObject.class);
            JsonArray getAllCountries = jsonResp.getAsJsonArray("response");

            Type listType = new TypeToken<List<String>>() {}.getType();
            List<String> allCountries = gson.fromJson(getAllCountries, listType);

            storage.addNewItem(cache_key, allCountries);

            return allCountries;
        }
    }
    public CovidResponse getCovidInfoFromCountry(String country, String day){
        List<String> allCountries = getAllContries();

        String cache_key = country+"-"+day;

        if (storage.checkIfHasResponse(cache_key)){
            return (CovidResponse) storage.getItem(cache_key);
        }
        else if(allCountries.contains(country) && day.matches("\\d{4}-\\d{2}-\\d{2}")){
            String link = "https://covid-193.p.rapidapi.com/history?country="+country+"&day="+day;

            String external_response = apiClient.get()
                    .uri(link)
                    .header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "277534bdeemsh0fbcf0bce8fe037p18934ejsnb631c30372c9")
                    .exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class))
                    .block();

            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.setPrettyPrinting().create();

            JsonObject full_json_response = gson.fromJson(external_response, JsonObject.class);

            JsonArray response = full_json_response.getAsJsonArray("response");

            logger.info("Response from external API:"+String.valueOf(response));
            if(response == null || response.size() == 0){
                logger.warn("Response was empty");
                return null;
            }

            String allInfo = gson.toJson(response.get(response.size()-1).getAsJsonObject());

            allInfo = allInfo.replace("null", "+0");


            CovidResponse covidResponse = gson.fromJson(allInfo, CovidResponse.class);
            logger.info("Service response:"+String.valueOf(covidResponse));

            storage.addNewItem(cache_key, covidResponse);

            return covidResponse;
        }
        else {
            return null;
        }
    }
}
