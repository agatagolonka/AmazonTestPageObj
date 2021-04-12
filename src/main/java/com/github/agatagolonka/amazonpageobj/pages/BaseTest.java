package com.github.agatagolonka.amazonpageobj.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String CHROME_DRIVER_PATH = "D:\\chromedriver.exe";
    public static final String AMAZON_HOMEPAGE = "https:\\amazon.com";
    public static final String USER_LOGIN = "annanowaktestuser@gmail.com";
    public static final String USER_PASSWD = "annanowaktestuser";
    private static WebDriver driver;
    private static int timeout = 10;
    public WebDriverWait wait;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void getUrl(String url) {
        driver.get(url);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebElement findWebElement(By by) {
        WebElement element = null;
        try {
            element = driver.findElement(by);

        } catch (NoSuchElementException e) {
            System.out.println(("Unable to find the element  prior to the time specified"));
        }
        return element;
    }

    // Implicit Wait
    public static void implicitWait(int secs) {
        driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
    }

    // Initialize the browser
    public void initWebDriver() {
        driver = new ChromeDriver();
        implicitWait(10);
        maximizeWindow();
    }

    public void click(By by) {
        waitForElementToBeVisible(by);
        findWebElement(by).click();
    }

    public void waitForElementToBeVisible(By selector) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("The element was not visible: %s", selector));
        }
    }

    public void sendKeys(By selector, String value) {
        WebElement element = getElement(selector);
        element.clear();
        element.sendKeys(value);

    }

    public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(String.format("Element %s does not exist", selector));
        }
        return null;
    }

    public List<WebElement> getElements(By Selector) {
        waitForElementToBeVisible(Selector);
        return driver.findElements(Selector);
    }


    public String getElementText(By selector) {
        waitForElementToBeVisible(selector);
        return StringUtils.trim(driver.findElement(selector).getText());

    }

    public void maximizeWindow() {
        driver.manage().window().maximize();

    }
}