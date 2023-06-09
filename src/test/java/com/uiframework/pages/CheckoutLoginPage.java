package com.uiframework.pages;

import com.uiframework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutLoginPage extends BasePage {

    private final By USERNAME = By.id ( "username");
    private final By PASSWORD = By.id ( "password" );
    private final By LOGIN_BUTTON = By.cssSelector ( "button[value='Login']" );

    public CheckoutLoginPage ( WebDriver driver ) {
        super(driver);
    }

    public CheckoutLoginPage enterUserName(String username){
        wait.until ( ExpectedConditions.visibilityOfElementLocated ( USERNAME ) ).sendKeys ( username );
        return this;
    }
    public CheckoutLoginPage enterPassword(String password){
        wait.until ( ExpectedConditions.visibilityOfElementLocated ( USERNAME ) ).sendKeys ( password );
        return this;
    }

    public CheckOutPage clickOnLoginButton(){
       wait.until ( ExpectedConditions.elementToBeClickable ( LOGIN_BUTTON ) ).click ();
       return new CheckOutPage ( driver );
    }

    public CheckOutPage CheckoutLoginDetails(String username,String password){
        enterUserName ( username );
        enterPassword ( password );
        clickOnLoginButton ();
        return new CheckOutPage ( driver );
    }


}
