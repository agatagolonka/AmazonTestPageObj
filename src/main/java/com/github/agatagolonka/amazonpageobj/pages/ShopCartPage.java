package com.github.agatagolonka.amazonpageobj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShopCartPage extends BaseTest {

    private final By GO_TO_CART = By.id("nav-cart");
    private final By SUBTOTAL = By.id("sc-subtotal-label-activecart");
    private final By DELETE_BUTTONS = By.cssSelector("input[value='Delete']");
    private final String SHOPPING_CART_EMPTY_MSG = "Your Amazon Cart is empty";
    private final String SHOPPING_CART_PAGE = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
    private final By SHOPPING_CART_HEADER = By.xpath("//h2[text()=\"\n" +
            "Your Amazon Cart is empty\n" +
            "\"]");

    public void goToCart() throws Exception {
        implicitWait(7);
        getUrl(SHOPPING_CART_PAGE);
    }

    public String getProductsSubtotal() {
        return getElement(SUBTOTAL).getText();
    }

    public void deleteAllProducts() {
        List<WebElement> deleteButtons = getElements(DELETE_BUTTONS);
        for (WebElement button : deleteButtons) {
            button.click();
        }
    }

    public boolean checkCartIsEmpty() {
        implicitWait(5);
        String actualMessage = getElementText(SHOPPING_CART_HEADER);
        System.out.println(actualMessage);
        return (actualMessage.equals(SHOPPING_CART_EMPTY_MSG));

    }
}
