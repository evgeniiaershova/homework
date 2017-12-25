package patterns.builder;

public class Client {

    public static void main(String[] args) {
        Product promoProduct = new PromoProductBuilder()
                .setPrice(50)
                .build();

        Product trialProduct = new TrialProductBuilder()
                .setTrialPrice(100)
                .build();
    }
}
