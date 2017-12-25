package patterns.factory;

import patterns.entities.Plan;

public abstract class Product {
    private double price = 0;

    public void setPrice(Plan plan) {
        switch (plan) {
            case PRO:
                this.price = 60.00;
                break;
            case GURU:
                this.price = 120.00;
                break;
            case BUSINESS:
                this.price = 180.00;
                break;
            default:
                this.price = 0.00;
                break;
        }
    }

    public double getPrice() {
        return price;
    }

    public abstract double getPaymentAmount();

    public abstract void activate();

    public void checkPayment() {
        System.out.println("assertThat(payment == " + getPaymentAmount() + ")");
    }
}
