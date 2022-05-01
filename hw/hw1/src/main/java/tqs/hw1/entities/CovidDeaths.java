package tqs.hw1.entities;

import com.google.gson.annotations.SerializedName;

public class CovidDeaths {
    @SerializedName("new")
    private String new_cases;
    @SerializedName("1M_pop")
    private String Pop_by_1M;
    private long total;

    public CovidDeaths(){}

    public CovidDeaths(String new_cases, String pop_by_1M, long total) {
        this.new_cases = new_cases;
        Pop_by_1M = pop_by_1M;
        this.total = total;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public void setPop_by_1M(String pop_by_1M) {
        Pop_by_1M = pop_by_1M;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public String getPop_by_1M() {
        return Pop_by_1M;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "CovidDeaths{" +
                "new_cases='" + new_cases + '\'' +
                ", Pop_by_1M='" + Pop_by_1M + '\'' +
                ", total=" + total +
                '}';
    }
}
