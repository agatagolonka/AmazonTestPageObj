package github.com.agatagolonka.amazonpageobj;

import com.github.agatagolonka.amazonpageobj.pages.BaseTest;
import com.github.agatagolonka.amazonpageobj.pages.ProductListPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


class SearchTest {
    private static final String SEARCHING_ITEM = "Witcher 3";
    public WebDriver driver;


    @BeforeEach
    void startPage() {

        driver = BaseTest.getDriver();
        BaseTest.getUrl(BaseTest.AMAZON_HOMEPAGE);

    }

    @Test
    void testSearch() throws Exception {
        ProductListPage products = new ProductListPage();
        products.searchSomething(SEARCHING_ITEM);
        String str = products.getProductName();
        Assert.assertTrue(str.contains(SEARCHING_ITEM));
    }

    @AfterClass
    void quitBrowser() {

        quitBrowser();
    }
}
