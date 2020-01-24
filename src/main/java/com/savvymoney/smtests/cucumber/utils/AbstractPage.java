package com.savvymoney.smtests.cucumber.utils;

import com.savvymoney.smtests.cucumber.exceptions.ElementNotFoundException;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage extends PageObject {

    private AbstractPage abstractPage;

    protected abstract String pageIdentifierXpath();

    public void clickOn(final String xpath) {
        clickOnWhenReady(xpath, false);
    }

    public String getTextFrom(String xpath) {
        return (String) new AbstractBuilder<AbstractBuilder, String>(abstractPage) {
            @Override
            protected String action(WebElement webElement) {
                return webElement.getText();
            }
        }.xpath(xpath).build();

    }
//
//    private TypeIntoBuilder(AbstractPage abstractPage) {
//        super(abstractPage);
//        iteration(iteration + 1);
//    }
//
//    protected void typeInto(final String xpath, final String data) {
//        new TypeIntoBuilder(abstractPage).value(data).xpath(xpath).build();
//    }

    protected AbstractPage() {
        abstractPage = this;
        WebDriver currentDriver = Serenity.getWebdriverManager().getCurrentDriver();
        this.setDriver(currentDriver);
    }

    protected void clickOnWhenReady(final String xpath, final Boolean move) {
        new AbstractBuilder<AbstractBuilder, Void>(abstractPage) {

            @Override
            public Void action(WebElement webElement) {
                webElement.click();
                return null;
            }
        }.xpath(xpath).move(move)./*iteration(10).*/build();
    }

    public WebElement getWebElement(String xpath) {
        return getWebElement(xpath, abstractPage.getWaitForTimeout().toMillis());
    }

    public WebElement getWebElement(String xpath, long timeOut) {
        waitForDocumentReady();

        //optimistic case.
        long exp = 0, imp = 0;
        try {
            exp = abstractPage.getWaitForTimeout().toMillis();
            //imp = abstractPage.getImplicitWaitTimeout().in(TimeUnit.MILLISECONDS);

            abstractPage.setWaitForTimeout(0);
            //abstractPage.setWaitForElementTimeout(0);

            WebElement element = abstractPage.getDriver().findElement(By.xpath(xpath));

            if (element != null) {
                return element;
            }
        } catch (Exception e) {

        } finally {
            abstractPage.setWaitForTimeout(exp);
            //abstractPage.setWaitForElementTimeout(imp);

        }

        if (timeOut > 0) {
            //pesimistic case.
            long start = System.currentTimeMillis();
            long delta = 0;

            do {
                try {

                    WebElement element = abstractPage.getDriver().findElement(By.xpath(xpath));

                    if (element == null) {
                        continue;
                    } else {
                        return element;
                    }

                } catch (Exception e) {

                } finally {
                    delta = System.currentTimeMillis() - start;
                }

            } while (delta <= timeOut);

            System.out.println("TIMEOUT: getWebElement time: " + delta + " element: " + xpath);
        }

        throw new ElementNotFoundException("Can't find element for specified xpath: [" + xpath + "]");
    }

    protected Boolean waitForDocumentReady() {

        long start = System.currentTimeMillis();
        long delta = 0;
        long timeOut = 8000;


        do {
            //check browser loading state
            Boolean isLoading = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return window.documentLoading");

            //page loading finished. we are ready to go
            if (Boolean.FALSE.equals(isLoading)) {
                return true;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }

            delta = System.currentTimeMillis() - start;
        } while (delta <= timeOut);

        System.out.println("TIMEOUT: waitForDocumentReady time: " + delta + " element: " + pageIdentifierXpath());
        return false;
    }

}
