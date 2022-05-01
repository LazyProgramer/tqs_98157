package tqs.hw1.entities;

import java.time.LocalDate;

public class ControllerResponse {
    String country;
    String date;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
