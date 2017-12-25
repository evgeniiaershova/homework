package patterns.builder;

import patterns.entities.Plan;

public class PromoProductBuilder {
    private Product product = new Product();

    public PromoProductBuilder setPrice(double price) {
        product.setPrice(price);
        return this;
    }

     public Product build() {
        return product;
    }



}
