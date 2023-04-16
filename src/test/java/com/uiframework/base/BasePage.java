package com.uiframework.base;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void launchURL(String endpoint){
        driver.get ( "https://askomdch.com" + endpoint);
    }
}
