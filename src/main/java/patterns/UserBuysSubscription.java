package patterns;

import org.testng.annotations.Test;
import patterns.factory2.SubscriptionFactory;

public class UserBuysSubscription {

   @Test(dataProvider = "getData")
    public void userSuccessfullyBuysSubscription(SubscriptionFactory subscriptionFactory) {
       subscriptionFactory.createSubscription();
       subscriptionFactory.orderSubscription();

   }


}
