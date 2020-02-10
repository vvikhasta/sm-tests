package com.savvymoney.smtests.cucumber.pages.savvymoney;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("/partner-login")
public class SMLoginPage extends AbstractPage {

    private String inputLogin = "//*[@id='email']";
    private String inputPassword = "//*[@id='password']";

    @Override
    protected String pageIdentifierXpath() {
        return inputLogin;
    }



    public void userEnterCredentials(String username, String Password) {
        typeInto(getWebElement(inputLogin), username);
        typeInto(getWebElement(inputPassword), Password);
          }

    public String getAutorizeText() {
        waitFor("//*[@class='vv-blue-title']");
        return getTextFrom("//*[@class='vv-blue-title']");
    }

}
