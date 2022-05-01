package tqs.hw1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class CovidTests {
    @SerializedName("1M_pop")
    private String Pop_by_1M;
    private long total;

    public CovidTests(){}

    public CovidTests(String pop_by_1M, long total) {
        Pop_by_1M = pop_by_1M;
        this.total = total;
    }

    public String getPop_by_1M() {
        return Pop_by_1M;
    }

    public void setPop_by_1M(String pop_by_1M) {
        Pop_by_1M = pop_by_1M;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CovidTests{" +
                "Pop_by_1M='" + Pop_by_1M + '\'' +
                ", total=" + total +
                '}';
    }
}
