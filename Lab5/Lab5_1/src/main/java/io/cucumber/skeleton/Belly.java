package io.cucumber.skeleton;

public class Belly {
    Integer bellyFull = 0;
    public void eat(int cukes) {
        this.bellyFull = this.bellyFull + cukes;
    }

    public void setBellyFull(Integer bellyFull) {
        this.bellyFull = bellyFull;
    }
    public Integer getBellyFull() {
        return bellyFull;
    }
}
