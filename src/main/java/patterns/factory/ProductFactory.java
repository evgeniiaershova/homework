package patterns.factory;

import patterns.entities.Plan;

public abstract class ProductFactory {

    Product product ;

    public abstract Product createProduct();

    private void goToCreateProductPage() {
        System.out.println("CreateProductPage createProductPage = new CreateProductPage();");
    }

    private void chooseProductPlan(Plan plan) {
        System.out.println("createProductPage.choosePlan(plan)");
    }

    public void generateInUi(Plan plan) {
        product.setPrice(plan);
        goToCreateProductPage();
        chooseProductType(product);
        chooseProductPlan(plan);
    }

    private void chooseProductType(Product product) {
        if (product instanceof StandardProduct) {
            System.out.println("createProductPage.chooseStandard();");
        }
        if (product instanceof PromoProduct) {
            System.out.println("createProductPage.choosePromo();");
        }
        if (product instanceof TrialProduct) {
            System.out.println("createProductPage.chooseTrial();");
        }
    }

    public void activate() {
        product.activate();
    }

    public void checkPayment() {
        product.checkPayment();
    }

}
