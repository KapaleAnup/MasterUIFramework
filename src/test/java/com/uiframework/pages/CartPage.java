package com.uiframework.pages;

import com.uiframework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By PRODUCT_NAME = By.cssSelector ( "td[class='product-name'] a");
    private final By CHECKOUT_BUTTON = By.cssSelector ( ".checkout-button" );

    public CartPage ( WebDriver driver ) {
        super ( driver );
    }

    public String getPrductName(){
        return wait.
                until ( ExpectedConditions.visibilityOfElementLocated ( PRODUCT_NAME ) ).getText ();

    }

    public CheckOutPage checkout(){
        wait.until ( ExpectedConditions.elementToBeClickable ( CHECKOUT_BUTTON ) ).click ();
        return new CheckOutPage(driver);
    }
}
