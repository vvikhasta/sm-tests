package com.savvymoney.smtests.cucumber.steps;

import com.savvymoney.smtests.cucumber.pages.savvymoney.SMForgotPasswordPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMForgotPasswordPageSteps {

    @Page
    SMForgotPasswordPage smForgotPasswordPage;

    public void openForgotPasswordPage() {
        smForgotPasswordPage.open();
    }

}
