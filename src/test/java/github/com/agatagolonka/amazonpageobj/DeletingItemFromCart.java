package github.com.agatagolonka.amazonpageobj;

import com.github.agatagolonka.amazonpageobj.pages.BaseTest;
import com.github.agatagolonka.amazonpageobj.pages.ProductPage;
import com.github.agatagolonka.amazonpageobj.pages.ShopCartPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DeletingItemFromCart {

    private static final String ITEM_URL = "https://www.amazon.com/gp/product/B01K6010FM/ref=ox_sc_act_title_1?smid=AVY78AJDCWNYB&psc=1";
    private static final String ITEM = "Witcher 3";
    public WebDriver driver;


    @BeforeEach
    void prepareCart() throws Exception {

        driver = BaseTest.getDriver();
        ProductPage product = new ProductPage();
        product.openProductPage(ITEM_URL);
        product.addItemToCart();


    }

    @Test
    void testAddingItemToCart() throws Exception {
        ShopCartPage shopCart = new ShopCartPage();
        shopCart.goToCart();
        shopCart.deleteAllProducts();
        Assert.assertEquals(shopCart.checkCartIsEmpty(), true);
    }

    @AfterClass
    void quitBrowser() {

        quitBrowser();
    }
}
