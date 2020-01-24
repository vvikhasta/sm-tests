package com.savvymoney.smtests.cucumber.pages.savvymoney;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/forgot-password")
public class SMForgotPasswordPage extends AbstractPage {

    private String buttonSubmit = "//*[@id='submit-btn']";

    @Override
    protected String pageIdentifierXpath() {
        return buttonSubmit;
    }


}
