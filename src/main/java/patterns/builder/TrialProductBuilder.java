package patterns.builder;

import patterns.entities.Plan;

public class TrialProductBuilder extends Product{
    private Product product = new Product();

    public TrialProductBuilder setTrialPrice(double price) {
        setTrialPrice(price);
        return this;
    }

    public Product build() {
        return product;
    }
}
