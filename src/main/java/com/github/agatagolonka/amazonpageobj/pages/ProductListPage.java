package com.github.agatagolonka.amazonpageobj.pages;

import org.openqa.selenium.By;

public class ProductListPage extends BaseTest {

    private final By SEARCH_FIELD = By.id("twotabsearchtextbox");
    private final By SEARCH_BUTTON = By.id("nav-search-submit-button");
    private final By RESULT_ITEM = By.id("search");


    public void searchSomething(String product) throws Exception {
        waitForElementToBeVisible(SEARCH_FIELD);
        sendKeys(SEARCH_FIELD, product);
        click(SEARCH_BUTTON);
    }

    public String getProductName() {
        return getElement(RESULT_ITEM).getText();
    }

}
