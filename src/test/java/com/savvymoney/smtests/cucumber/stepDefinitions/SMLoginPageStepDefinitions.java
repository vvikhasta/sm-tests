package com.savvymoney.smtests.cucumber.stepDefinitions;

import com.savvymoney.smtests.cucumber.steps.SMLoginPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMLoginPageStepDefinitions {

    @Steps
    SMLoginPageSteps smLoginPageSteps;

    @And("^User opens login page$")
    public void openLoginPage() {
       smLoginPageSteps.openLoginPage();
    }

    @And("^User logs in with username '(.*)' and password '(.*)'$")
    public void login(String user, String pass) {
        smLoginPageSteps.login(user, pass);
    }

    @And("^User verifies error message '(.*)' is displayed$")
    public void verifyErrorMessage(String error) {
        Assert.assertEquals("expected error message was not shown", error, smLoginPageSteps.getErrorMessage());
    }

}
