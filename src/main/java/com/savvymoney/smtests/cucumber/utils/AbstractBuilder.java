package com.savvymoney.smtests.cucumber.utils;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public abstract class AbstractBuilder<T extends AbstractBuilder, A> {

    protected Long timeOut = 0L;
    protected AbstractPage abstractPage;
    protected Boolean needMoveToElement = false;
    protected String xpath = null;
    protected Integer iteration = 1;
    protected WebElement webElement = null;

    protected AbstractBuilder(AbstractPage abstractPage) {
        this.abstractPage = abstractPage;
        timeOut = abstractPage.getWaitForTimeout().toMillis();
    }

    protected WebElement getWebElement() {
        return abstractPage.getWebElement(xpath);
    }

    public A build() {

        if (iteration == 0) {
            return actionIfCantPerform();
        } else {
            iteration--;
        }

        try {

            if (webElement == null) {
                webElement = getWebElement();
                webElement = abstractPage.element(webElement);
            }

            if (needMoveToElement) {
                ((JavascriptExecutor) abstractPage.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            }

            return action(webElement);
        } catch (StaleElementReferenceException | ElementNotVisibleException e) {
            //try one more time because something changed
        } catch (Exception e) {
            String msg = e.getMessage();
            if (msg == null) {
                msg = "";
            }
            msg = msg.replaceAll("\\s", "").toLowerCase();
            if (msg.contains("can'tperformactiononelement") || msg.contains("otherelementwouldreceivetheclick")) {
                //try one more time because could be shade div visible which cover the element
            } else {
                //e.printStackTrace();
            }
        }

        //if we are here than exception was occured
        webElement = null;
        return build();
    }

    public T move(Boolean needMoveToElement) {
        this.needMoveToElement = needMoveToElement;
        return (T) this;
    }

    protected abstract A action(WebElement webElement);

    public T xpath(String xpath) {
        this.xpath = xpath;
        return (T) this;
    }

    protected A actionIfCantPerform() {
        throw new RuntimeException("Can't perform action on element [" + (xpath != null ? xpath : webElement) + "]");
    }
}
