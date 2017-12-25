package patterns;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.entities.Plan;
import patterns.factory.*;

public class UserBuysProduct {


    @Test(dataProvider = "getData")
    public void buyStandardProduct(ProductFactory productFactory) {
        productFactory.createProduct();

        productFactory.generateInUi(Plan.PRO);
        productFactory.activate();
        productFactory.checkPayment();
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {new StandardProductFactory()},
                {new PromoProductFactory()},
                {new TrialProductFactory()}
        };
    }

// создаем продукт
    // идем на страницу создания продукта
    // если продукт Промо, выбираем продукт Промо
    // если продукт Стандарт, выбираем Стандарт
    // если Триал, то триал

// активируем продукт
    // если продукт Промо, то идем на страницу Промо и там заполняем форму
    // если продукт Стандарт или Триал, идем на форму оплаты и заполняем форму там

// проверяем платеж
    // если продукт Промо, то цена должна быть (getPlan), а сумма платежа 0.00
    // если продукт Стандарт, то цена должна быть (getPlan), и сумма getPlan
    // если Триал, то цена должна быть getPlan, а сумма, getTrialPrice


}
