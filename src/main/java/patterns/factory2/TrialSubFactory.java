package patterns.factory2;

import patterns.factory2.subscriptions.Subscription;
import patterns.factory2.subscriptions.TrialSubscription;

public class TrialSubFactory extends SubscriptionFactory {
    @Override
    public void createSubscription() {
     subscription = new TrialSubscription();
    }

}
