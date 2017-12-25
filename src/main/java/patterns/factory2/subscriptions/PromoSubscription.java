package patterns.factory2.subscriptions;

import patterns.entities.Period;
import patterns.entities.Plan;

public class PromoSubscription extends Subscription{


    @Override
    public boolean isRecurring() {
        return false;
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public void getOrderUrl() {
        System.out.println("http://mydomain.promo-order-url");
    }
}
