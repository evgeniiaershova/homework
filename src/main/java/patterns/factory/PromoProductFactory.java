package patterns.factory;

public class PromoProductFactory extends ProductFactory{

    @Override
    public Product createProduct() {
        return new PromoProduct() {
        };
    }
}
