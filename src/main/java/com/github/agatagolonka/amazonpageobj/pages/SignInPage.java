package com.github.agatagolonka.amazonpageobj.pages;

import org.openqa.selenium.By;


public class SignInPage extends BaseTest {

    private final By USERNAME = By.cssSelector("#ap_email");
    private final By PASSWORD = By.cssSelector("#ap_password");
    private final By SIGNIN_BUTTON = By.cssSelector("#signInSubmit");
    private final By START_LOGIN = By.id("nav-link-accountList");
    private final By CONTINUE_LOGIN = By.id("continue");
    private final By ACCOUNT_NAME = By.id("nav-link-accountList-nav-line-1");

    public void enterUsername(String userName) {
        waitForElementToBeVisible(USERNAME);
        sendKeys(USERNAME, userName);
    }

    public void enterPassword(String password) {
        waitForElementToBeVisible(PASSWORD);
        sendKeys(PASSWORD, password);
    }
    public String getUserName(){
        waitForElementToBeVisible(ACCOUNT_NAME);
        return getElement(ACCOUNT_NAME).getText();
    }

    public void clickStartLogin() throws Exception {
        click(START_LOGIN);
    }

    public void clickContinue() throws Exception {
        click(CONTINUE_LOGIN);
    }

    public void clickSignInButton() throws Exception {
        click(SIGNIN_BUTTON);
    }
}
