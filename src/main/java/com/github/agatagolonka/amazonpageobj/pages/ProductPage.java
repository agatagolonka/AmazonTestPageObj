package com.github.agatagolonka.amazonpageobj.pages;

import org.openqa.selenium.By;

public class ProductPage extends BaseTest {

    private final By ADD_TO_CART = By.xpath("//input[@id='add-to-cart-button']");

    public void openProductPage(String url) {
        getUrl(url);
    }

    public void addItemToCart() throws Exception {
        waitForElementToBeVisible(ADD_TO_CART);
        click(ADD_TO_CART);
        implicitWait(7);
    }

}
