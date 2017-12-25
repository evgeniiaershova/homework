package patterns.builder;

import patterns.entities.Plan;

public class Product {
    private double price;
    private boolean recurring;
    private double trialPrice;

    private Plan plan;

    protected void setPrice(double price) {
        this.price = price;
    }

    protected void setTrial(double trialPrice) {
        this.trialPrice = trialPrice;
    }
}
