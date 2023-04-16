package com.uiframework.pages;

import com.uiframework.base.BasePage;
import com.uiframework.objects.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    private final By BILLING_FIRSTNAME = By.id ( "billing_first_name");
    private final By BILLING_LASTNAME = By.id ( "billing_last_name");
    private final By BILLING_ADDRESS = By.id ( "billing_address_1");
    private final By CITY= By.id ( "billing_city" );
    private final By POSTALCODE= By.id ( "billing_postcode" );
    private final By EMAIL= By.id ( "billing_email" );
    private final By PLACEORDER = By.id ( "place_order" );
    private final By SUCCESSMESSAGE = By.cssSelector ( ".woocommerce-notice" );

    private final By CHECKOUT_LOGIN= By.cssSelector ( ".showlogin" );


    public CheckOutPage ( WebDriver driver ) {
        super ( driver );
    }

//    public void checkoutBillingDetails(String firstName,String lastName, String address,String city,String postalcode,String email){
//        enterFirstName ( firstName );
//        enterLastName ( lastName );
//        enterAddress ( address );
//        enterCity ( city );
//        enterPostalCode ( postalcode );
//        enterEmail ( email );
//    }

    public CheckOutPage setBillingAddress( BillingAddress billingAddress ){
      return  enterFirstName (billingAddress.getFirstName ()  )
                .enterLastName ( billingAddress.getLastName ( ) )
                .enterAddress ( billingAddress.getAddress ( ) )
                .enterCity ( billingAddress.getCity ( ) )
                .enterPostalCode ( billingAddress.getPostalCode ( ) )
                .enterEmail ( billingAddress.getEmail ( ) );
    }

    public CheckOutPage enterFirstName(String firstName){
        driver.findElement ( BILLING_FIRSTNAME ).sendKeys ( firstName );
        return this;
    }
    public CheckOutPage enterLastName(String LastName){
        driver.findElement ( BILLING_LASTNAME ).sendKeys ( LastName );
        return this;
    }

    public CheckOutPage enterAddress(String address){
        driver.findElement ( BILLING_ADDRESS ).sendKeys ( address );
        return this;
    }

    public CheckOutPage enterCity(String city){
        driver.findElement ( CITY ).sendKeys ( city );
        return this;
    }

    public CheckOutPage enterPostalCode(String code){
        driver.findElement ( POSTALCODE ).sendKeys ( code );
        return this;
    }

    public CheckOutPage enterEmail(String email){
        driver.findElement ( EMAIL ).sendKeys ( email );
        return this;
    }

    public CheckOutPage placeOder(){
        driver.findElement ( PLACEORDER ).click ();
        return this;
    }

    public String getMessage(){
        return driver.findElement ( SUCCESSMESSAGE ).getText ();
    }

    public CheckoutLoginPage clickOnLoginLink(){
        driver.findElement ( CHECKOUT_LOGIN ).click ();
        return new CheckoutLoginPage(driver);
    }
}
