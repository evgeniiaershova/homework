package patterns.factory;

public class TrialProductFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new TrialProduct();
    }
}
