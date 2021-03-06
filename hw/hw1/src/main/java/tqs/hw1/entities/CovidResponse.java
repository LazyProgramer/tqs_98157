package tqs.hw1.entities;

import tqs.hw1.controler.RestApiController;

public class CovidResponse extends RestApiController {

    private String country;
    private long population;
    private CovidCases cases;
    private CovidDeaths deaths;
    private CovidTests tests;
    private String day;

    /*
    // Used for gson conversion
     */
    public CovidResponse(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public CovidCases getCases() {
        return cases;
    }

    public void setCases(CovidCases cases) {
        this.cases = cases;
    }

    public CovidDeaths getDeaths() {
        return deaths;
    }

    public void setDeaths(CovidDeaths deaths) {
        this.deaths = deaths;
    }

    public CovidTests getTests() {
        return tests;
    }

    public void setTests(CovidTests tests) {
        this.tests = tests;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "CovidResponse{" +
                "country='" + country + '\'' +
                ", population=" + population +
                ", cases=" + cases +
                ", deaths=" + deaths +
                ", tests=" + tests +
                ", day='" + day + '\'' +
                '}';
    }
}
