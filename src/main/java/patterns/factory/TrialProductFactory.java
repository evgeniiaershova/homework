package patterns.factory;

public class TrialProductFactory extends ProductFactory {
    @Override
    protected Product createProduct() {
        return new TrialProduct();
    }
}
