package com.savvymoney.smtests.cucumber.steps;

import com.savvymoney.smtests.cucumber.pages.savvymoney.SMForgotPasswordPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;

public class SMForgotPasswordPageSteps {

    @Page
    SMForgotPasswordPage smForgotPasswordPage;

    @Step
    public void openForgotPasswordPage() {
        smForgotPasswordPage.open();
    }


    @Step
    public void userTypesEmail(String userEmail) {
        smForgotPasswordPage.userTypesEmail(userEmail);
    }

    @Step
    public void userClicksOnSubmitButton() {
        smForgotPasswordPage.userClicksOnSubmitButton();
    }

    @Step
    public String userVerifiesEmail() {
        return smForgotPasswordPage.userVerifiesEmail();
    }

    public boolean userVerifiesTitleIsShown() {
        return smForgotPasswordPage.userVerifiesTitleIsShown();
    }


}
