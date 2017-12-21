package patterns.factory;

public class StandardProductFactory extends ProductFactory {

    @Override
    public Product createProduct() {
        return new StandardProduct();
    }
}
