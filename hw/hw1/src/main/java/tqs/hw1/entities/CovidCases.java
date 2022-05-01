package tqs.hw1.entities;

import com.google.gson.annotations.SerializedName;


public class CovidCases {
    @SerializedName("new")
    private String new_cases;
    private long active;
    private long critical;
    private long recovered;
    @SerializedName("1M_pop")
    private String Pop_by_1M;
    private long total;

    public CovidCases(){}

    public CovidCases(String new_cases, long active, long critical, long recovered, String pop_by_1M, long total) {
        this.new_cases = new_cases;
        this.active = active;
        this.critical = critical;
        this.recovered = recovered;
        this.Pop_by_1M = pop_by_1M;
        this.total = total;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
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
        return "CovidCases{" +
                "new_cases='" + new_cases + '\'' +
                ", active=" + active +
                ", critical=" + critical +
                ", recovered=" + recovered +
                ", Pop_by_1M='" + Pop_by_1M + '\'' +
                ", total=" + total +
                '}';
    }
}
