package com.savvymoney.smtests.cucumber.stepDefinitions;

import com.savvymoney.smtests.cucumber.steps.SMLoginPageSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SMLoginPageStepDefinitions {

    @Steps
    SMLoginPageSteps smLoginPageSteps;


    @And("^User opens login page$")
    public void openLoginPage() {
        smLoginPageSteps.openLoginPage();
    }

    @And("^User logs in with ([^\"]*) and ([^\"]*)$")
    public void userLogsWith(String userName, String Password ){
        smLoginPageSteps.userEnterCredentials(userName,Password);
    }

    @And("^User submited input data$")
    public void userSubmitedData(){
        smLoginPageSteps.userSubmitedData();
    }


    @And("^User sees I autorize page$")
    public void UserSeesAutorizePage(String error) {
        Assert.assertEquals("expected error message was not shown", error, smLoginPageSteps.UserSeesAutorizePage());
    }

}
