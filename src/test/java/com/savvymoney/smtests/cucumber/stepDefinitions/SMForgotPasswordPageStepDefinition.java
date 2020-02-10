package com.savvymoney.smtests.cucumber.stepDefinitions;

import com.savvymoney.smtests.cucumber.steps.SMForgotPasswordPageSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMForgotPasswordPageStepDefinition {

    @Steps
    private SMForgotPasswordPageSteps smForgotPasswordPageSteps;

    @And("^User opens forgot password page$")
    public void openForgotPasswordPage() {
        smForgotPasswordPageSteps.openForgotPasswordPage();
    }

    @And("^User types in email '(.*)'$")
    public void userTypesEmail(String mail) {
        smForgotPasswordPageSteps.userTypesEmail(mail);
    }

    @And("^User clicks on submit button$")
    public void userClicksOnSubmitButton() {
        smForgotPasswordPageSteps.userClicksOnSubmitButton();
    }

    @And("^User verifies is email sent and is it '(.*)'$")
    public void userVerifiesEmailandTitleCorrect(String email) {
        Assert.assertTrue(smForgotPasswordPageSteps.userVerifiesTitleIsShown());
        Assert.assertEquals(email, smForgotPasswordPageSteps.userVerifiesEmail());
    }



    }
