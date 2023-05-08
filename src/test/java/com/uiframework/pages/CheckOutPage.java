package com.uiframework.pages;

import com.uiframework.base.BasePage;
import com.uiframework.objects.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.List;

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

    private final By OVELAY = By.cssSelector ( ".blockUI blockOverlay" );

    private final By SELECTCOUNTRY = By.id ( "billing_country" );
    private final By SELECTSTATE  = By.id ( "billing_state" );

    private final By COUNTRY_DROPDOWN = By.id ( "select2-billing_country-container" );
    private final By STATE_DROPDOWN = By.id ( "select2-billing_state-container" );

    public CheckOutPage ( WebDriver driver ) {
        super ( driver );
    }

    public CheckOutPage setBillingAddress( BillingAddress billingAddress ){
      return  enterFirstName (billingAddress.getFirstName ()  )
                .enterLastName ( billingAddress.getLastName ( ) )
                .selectCountry ( billingAddress.getCountry () )
                .enterAddress ( billingAddress.getAddress ( ) )
                .enterCity ( billingAddress.getCity ( ) )
                .selectState ( billingAddress.getState ( ) )
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

    public CheckOutPage selectCountry(String countryName){
     /*   Select select = new Select ( driver.findElement ( SELECTCOUNTRY) );
        select.selectByVisibleText ( countryName);*/


        wait.until ( ExpectedConditions.elementToBeClickable ( COUNTRY_DROPDOWN ) ).click ();
        WebElement element = wait.
                until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//li[text()= '"+countryName+"']" ) ) );
        ((JavascriptExecutor)driver).executeScript ( "arguments[0].scrollIntoView(true);",element );
        element.click ();
        return this;
    }

    public CheckOutPage selectState(String countryState){
  /*      Select select = new Select ( driver.findElement ( SELECTSTATE) );
        select.selectByVisibleText ( countryState );*/

        wait.until ( ExpectedConditions.elementToBeClickable ( STATE_DROPDOWN ) ).click ();
        WebElement element = wait.
                until ( ExpectedConditions.elementToBeClickable ( By.xpath ( "//li[text()= '"+countryState+"']" ) ) );
        ((JavascriptExecutor)driver).executeScript ( "arguments[0].scrollIntoView(true);",element );
        element.click ();
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
        wait.until ( ExpectedConditions.elementToBeClickable ( PLACEORDER ) ).click ();
        return this;
    }

    public String getMessage(){
        return wait.until ( ExpectedConditions.visibilityOfElementLocated ( SUCCESSMESSAGE ) ).getText ();
    }

    public CheckoutLoginPage clickOnLoginLink(){
        waitForOverlay ( OVELAY );
        wait.until ( ExpectedConditions.elementToBeClickable ( CHECKOUT_LOGIN ) ).click ();
        return new CheckoutLoginPage(driver);
    }
}
