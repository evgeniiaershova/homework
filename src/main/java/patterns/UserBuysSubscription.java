package patterns;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.entities.Period;
import patterns.entities.Plan;
import patterns.factory.PromoProductFactory;
import patterns.factory.StandardProductFactory;
import patterns.factory.TrialProductFactory;
import patterns.factory2.SubscriptionFactory;
import patterns.factory2.subscriptions.Subscription;

public class UserBuysSubscription {

   @Test(dataProvider = "getData")
    public void userSuccessfullyBuysSubscription(SubscriptionFactory subscriptionFactory) {
       subscriptionFactory.createSubscription();
       subscriptionFactory.orderSubscription();

   }

   @DataProvider
    private Object[][] getData() {
       return new Object[][] {
               {new PromoProductFactory()},
               {new TrialProductFactory()},
               {new StandardProductFactory()},

       };
   }
}
