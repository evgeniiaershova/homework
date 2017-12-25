package patterns.factory2;

import patterns.factory2.subscriptions.StandardSubscription;
import patterns.factory2.subscriptions.Subscription;

public class StandardSubFactory extends SubscriptionFactory {
    @Override
    public void createSubscription() {
        subscription = new StandardSubscription();
    }
}
