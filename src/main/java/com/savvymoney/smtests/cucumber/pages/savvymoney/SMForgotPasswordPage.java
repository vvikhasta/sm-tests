package com.savvymoney.smtests.cucumber.pages.savvymoney;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/forgot-password")
public class SMForgotPasswordPage extends AbstractPage {

    private String buttonSubmit = "//*[@id='submit-btn']";
    private String inputEmail = "//*[@id='email-forgot-psw']";
    private String expectedTitle = "//*[@class='blue-title']";
    private String expectedEmail = "//*[@id='email']";


    @Override
    protected String pageIdentifierXpath() {
        return buttonSubmit;
    }


    public void userTypesEmail(String userEmail) {
        typeInto(getWebElement(inputEmail), userEmail);
    }

    public void userClicksOnSubmitButton() {
        clickOn(buttonSubmit);
    }

    public boolean userVerifiesTitleIsShown() {
        return getWebElement(expectedTitle).isDisplayed();
    }

    public String userVerifiesEmail() {
        return getWebElement(expectedEmail).getText();
    }

}

