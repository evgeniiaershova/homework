package patterns.factory;

public class PromoProduct extends Product {

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public void activate() {
        System.out.println("wd.get{/activate-promo-url}");
        System.out.println("fill the PROMO form and submit");
    }

}
