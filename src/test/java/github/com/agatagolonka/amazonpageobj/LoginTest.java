package github.com.agatagolonka.amazonpageobj;

import com.github.agatagolonka.amazonpageobj.pages.BaseTest;
import com.github.agatagolonka.amazonpageobj.pages.SignInPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


class LoginTest {

    private static final String USER_ACCOUNT = "Hello, Anna";
    public WebDriver driver;


    @BeforeEach
    void startPage() {

        driver = BaseTest.getDriver();
        BaseTest.getUrl(BaseTest.AMAZON_HOMEPAGE);

    }

    @Test
    void testLogin() throws Exception {
        SignInPage login = new SignInPage();
        login.clickStartLogin();
        login.enterUsername(BaseTest.USER_LOGIN);
        login.clickContinue();
        login.enterPassword(BaseTest.USER_PASSWD);
        login.clickSignInButton();
        String str = login.getUserName();
        Assert.assertTrue(str.contains(USER_ACCOUNT));
    }

    @AfterClass
    void quitBrowser() {

        quitBrowser();
    }
}
