package patterns.factory2.subscriptions;

public class TrialSubscription extends Subscription{

    double trialPrice = 5.00;

    public void setTrialPrice(double trialPrice) {
        this.trialPrice = trialPrice;
}

    @Override
    public boolean isRecurring() {
        return true;
    }

    @Override
    public double getPaymentAmount() {
        return trialPrice;
    }

    @Override
    public void getOrderUrl() {
        System.out.println("http://mydomain.standard-order-url");
    }
}
