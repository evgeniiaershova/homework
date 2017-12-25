package patterns.factory2.subscriptions;

import patterns.entities.Period;
import patterns.entities.Plan;

public class StandardSubscription extends Subscription{

    boolean recurring = true;

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    @Override
    public boolean isRecurring() {
        return recurring;
    }

    @Override
    public double getPaymentAmount() {
        return getPrice();
    }

    @Override
    public void getOrderUrl() {
        System.out.println("http://mydomain.standard-order-url");
    }
}
