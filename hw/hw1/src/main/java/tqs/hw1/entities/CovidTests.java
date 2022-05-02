package tqs.hw1.entities;

import com.google.gson.annotations.SerializedName;

public class CovidTests {
    @SerializedName("1M_pop")
    private String popBy1M;
    private long total;

    /*
    // Used for gson conversion
     */
    public CovidTests(){}

    public String getPopBy1M() {
        return this.popBy1M;
    }

    public void setPopBy1M(String popBy1M) {
        this.popBy1M = popBy1M;
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
                "Pop_by_1M='" + popBy1M + '\'' +
                ", total=" + total +
                '}';
    }
}
