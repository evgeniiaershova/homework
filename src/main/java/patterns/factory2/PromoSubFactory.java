package patterns.factory2;

import patterns.factory2.subscriptions.PromoSubscription;
import patterns.factory2.subscriptions.Subscription;

public class PromoSubFactory extends SubscriptionFactory {

    @Override
    public void createSubscription() {
        subscription = new PromoSubscription();
    }


}
