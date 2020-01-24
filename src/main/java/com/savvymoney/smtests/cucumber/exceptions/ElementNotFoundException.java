package com.savvymoney.smtests.cucumber.exceptions;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(String s) {
        super(s);
    }
}
