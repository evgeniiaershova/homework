package patterns.factory;

public class TrialProduct extends Product {

    double trialPrice = 20;

    public void setTrialPrice(double trialPrice) {
        this.trialPrice = trialPrice;
    }

    @Override
    public double getPaymentAmount() {
        return trialPrice;
    }


    @Override
    public void activate() {
        System.out.println("wd.get(/payment-page-url)");
        System.out.println("fill payment form and submit");
    }

}
