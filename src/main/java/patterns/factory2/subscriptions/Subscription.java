package patterns.factory2.subscriptions;

import patterns.entities.Period;
import patterns.entities.Plan;

public abstract class Subscription {
    protected Plan plan;
    protected Period period;

    public void setPlan(Plan plan){
        this.plan = plan;
    }
    public Plan getPlan(){
        return plan;
    }

    public void setPeriod(Period period){
        this.period = period;
    }
    public Period getPeriod() {
        return period;
    }

    public double getPrice() {
        switch (plan) {
            case PRO:
                return 60.00;
            case GURU:
                return 120.00;
            case BUSINESS:
                return 180;
            default:
                return 0.00;
        }
    }

    public abstract boolean isRecurring();

    public abstract double getPaymentAmount();

    public abstract void getOrderUrl();


}
