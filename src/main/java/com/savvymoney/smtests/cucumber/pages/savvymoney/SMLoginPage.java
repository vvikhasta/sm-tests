package com.savvymoney.smtests.cucumber.pages.savvymoney;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("/login")
public class SMLoginPage extends AbstractPage {

    private String inputLogin = "//*[@id='email-sign-in']";
    private String inputPassword = "//*[@id='password-sign-in']";
    private String buttonSignIn = "//*[@id='login-btn']";

    @Override
    protected String pageIdentifierXpath() {
        return inputLogin;
    }


    public void login(String userName, String password) {
        typeInto(getWebElement(inputLogin), userName);
        typeInto(getWebElement(inputPassword), password);
        clickOn(buttonSignIn);
    }

    public String getErrorMessage() {
        waitFor("//*[@id='errorTitle-sign-in']");
        return getTextFrom("//*[@id='errorTitle-sign-in']");
    }

}
