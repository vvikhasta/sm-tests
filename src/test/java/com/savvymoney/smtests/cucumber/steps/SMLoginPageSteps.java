package com.savvymoney.smtests.cucumber.steps;

import com.savvymoney.smtests.cucumber.pages.savvymoney.SMLoginPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMLoginPageSteps {

    @Page
    SMLoginPage smLoginPage;

    @Step
    public void openLoginPage() {
        smLoginPage.open();
    }

    @Step
    public void login(String userName, String password) {
        smLoginPage.login(userName, password);
    }

    @Step
    public String getErrorMessage() {
       return smLoginPage.getErrorMessage();
    }

}
