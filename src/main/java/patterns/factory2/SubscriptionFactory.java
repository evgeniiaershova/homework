package patterns.factory2;

import patterns.entities.Period;
import patterns.entities.Plan;
import patterns.factory2.subscriptions.Subscription;

public abstract class SubscriptionFactory {

    protected Subscription subscription;

    public abstract void createSubscription();

    public void orderSubscription() {
        subscription.setPeriod(Period.ONE_WEEK);
        subscription.setPlan(Plan.GURU);
        subscription.getOrderUrl();

    }

    public void checkSubscription(){
    }
}
