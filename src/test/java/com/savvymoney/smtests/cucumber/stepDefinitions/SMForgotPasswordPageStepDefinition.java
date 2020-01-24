package com.savvymoney.smtests.cucumber.stepDefinitions;

import com.savvymoney.smtests.cucumber.steps.SMForgotPasswordPageSteps;
import cucumber.api.java.en.But;
import net.thucydides.core.annotations.Steps;

public class SMForgotPasswordPageStepDefinition {

    @Steps
    private SMForgotPasswordPageSteps smForgotPasswordPageSteps;

    @But("^User opens login page$")
    public void openForgotPasswordPage() {
        smForgotPasswordPageSteps.openForgotPasswordPage();
    }

}
