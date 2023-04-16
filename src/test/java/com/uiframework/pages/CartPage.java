package com.uiframework.pages;

import com.uiframework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By PRODUCT_NAME = By.cssSelector ( "td[class='product-name'] a");
    private final By CHECKOUT_BUTTON = By.cssSelector ( ".checkout-button" );

    public CartPage ( WebDriver driver ) {
        super ( driver );
    }

    public String getPrductName(){
       return driver.findElement ( PRODUCT_NAME ).getText ();
    }

    public CheckOutPage checkout(){
        driver.findElement ( CHECKOUT_BUTTON ).click ();
        return new CheckOutPage(driver);
    }
}
