package com.savvymoney.smtests.cucumber.pages.rozetka;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@DefaultUrl("https://www.pravda.com.ua/columns/")
public class RozetkaCartShopPage extends AbstractPage {

    private String buttonBuy = "//*[contains(@class,'buy-button bu')]";

    @Override
    protected String pageIdentifierXpath() {
        return buttonBuy;
    }

    public String openWebPage(String URL) {
//        getDriver().navigate().to(URL);
//        waitFor("//*[contains(@class,'buy-button bu')]");
//        clickOn(buttonBuy);
//        waitFor("//a[@href='https://my.rozetka.com.ua/checkout']/preceding-sibling::p//following-sibling::a");
        waitABit(5000);
        return getTextFrom("//a[@href='https://my.rozetka.com.ua/checkout']/preceding-sibling::p//following-sibling::a");
    }

}
