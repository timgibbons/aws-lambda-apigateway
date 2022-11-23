package net.niaax.aws.lambdaapigateway.custom;

public class SimpleNameJSON {

    private String name;

    public SimpleNameJSON() {
    }

    public SimpleNameJSON(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
