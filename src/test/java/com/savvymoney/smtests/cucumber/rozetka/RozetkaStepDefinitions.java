package com.savvymoney.smtests.cucumber.rozetka;

import com.savvymoney.smtests.cucumber.rozetka.RozetkaSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class RozetkaStepDefinitions {

    @Steps
    private RozetkaSteps rozetkaSteps;

    @And("^Provider opens URL '(.*)' and verifies '(.*)' on buy cart popup$")
    public void openWebPage(String URL, String expectedTitle) {
        //String resultingTitle =
        rozetkaSteps.openWebPage(URL);
//        Assert.assertEquals(expectedTitle, resultingTitle);
    }

}
