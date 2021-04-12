package github.com.agatagolonka.amazonpageobj;

import com.github.agatagolonka.amazonpageobj.pages.BaseTest;
import com.github.agatagolonka.amazonpageobj.pages.ProductListPage;
import com.github.agatagolonka.amazonpageobj.pages.ProductPage;
import com.github.agatagolonka.amazonpageobj.pages.ShopCartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddItemToCart {
    private static final String ITEM_URL = "https://www.amazon.com/gp/product/B01K6010FM/ref=ox_sc_act_title_1?smid=AVY78AJDCWNYB&psc=1";
    private static final String ITEM="Subtotal (1 item):";
    public WebDriver driver;


    @BeforeEach
    void startPage() {

        driver = BaseTest.getDriver();
        BaseTest.getUrl(BaseTest.AMAZON_HOMEPAGE);

    }

    @Test
    void testAddingItemToCart() throws Exception {
        ProductPage product=new ProductPage();
        product.openProductPage(ITEM_URL);
        product.addItemToCart();
        ShopCartPage shopCart=new ShopCartPage();
        shopCart.goToCart();
        String str=shopCart.getProductsSubtotal();
        Assertions.assertEquals("Subtotal (1 Item)", str);
    }

    @AfterClass
    void quitBrowser() {

        quitBrowser();
    }
}
