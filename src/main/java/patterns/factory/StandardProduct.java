package patterns.factory;

public class StandardProduct extends Product {

    @Override
    public void activate() {
        System.out.println("wd.get(/payment-page-url)");
        System.out.println("fill payment form and submit");
    }

    @Override
    public double getPaymentAmount() {
       return getPrice();
    }

   }
