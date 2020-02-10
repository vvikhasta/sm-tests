package com.savvymoney.smtests.cucumber.steps;

import com.savvymoney.smtests.cucumber.pages.savvymoney.SMLoginPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMLoginPageSteps {


    @Page
    SMLoginPage smLoginPage;

    public String buttonSignIn;

    @Step
    public void openLoginPage() {
        smLoginPage.open();
    }

    @Step
    public void userEnterCredentials (String userame, String password) {

        smLoginPage.userEnterCredentials(userame, password);
    }
    @Step
    public void userSubmitedData(){
        smLoginPage.clickOn(buttonSignIn);
    }

    @Step
    public String UserSeesAutorizePage() {
       return smLoginPage.getAutorizeText();
    }

}
