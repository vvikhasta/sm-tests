package com.savvymoney.smtests.cucumber.rozetka;

import com.savvymoney.smtests.cucumber.pages.rozetka.RozetkaCartShopPage;
import org.fluentlenium.core.annotation.Page;

public class RozetkaSteps {

    @Page
    private RozetkaCartShopPage rozetkaCartShopPage;

    public void openWebPage(String URL){
        rozetkaCartShopPage.open();
        rozetkaCartShopPage.openWebPage(URL);
//        return rozetkaCartShopPage.openWebPage(URL);
    }

}
