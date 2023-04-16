package com.uiframework.pages;

import com.uiframework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By SEARCHFIELD= By.cssSelector ( "#woocommerce-product-search-field-0");
    private final By SERACH_BUTTON = By.cssSelector ( "button[value='Search']" );
    private final By SEARCH_TITLE = By.cssSelector ( ".woocommerce-products-header__title.page-title" );
    private final By VIEWCART_LINK = By.cssSelector ( "a[title='View cart']" );


    public StorePage ( WebDriver driver ) {
        super (driver );
    }

    private StorePage enterSearchText(String text){
        driver.findElement ( SEARCHFIELD ).sendKeys ( text );
        return this;
    }

    public StorePage searchProduct(String text){
        enterSearchText ( text ).clickSearchButton ();
        return this;
    }

    private StorePage clickSearchButton(){
        driver.findElement ( SERACH_BUTTON ).click ();
        return this;
    }

    public String getTitle(){
        return driver.findElement ( SEARCH_TITLE ).getText ();
    }

    private By getAddToCardButtonElement(String productName){
        return By.cssSelector ( "a[aria-label='Add “"+productName+"” to your cart']" );
    }

    public StorePage clickAddToCart(String productName){
        By addtoCartBTN = getAddToCardButtonElement (productName);
        driver.findElement ( addtoCartBTN ).click ();
        return this;
    }

    public CartPage clickViewCart(){
        driver.findElement ( VIEWCART_LINK ).click ();
        return new CartPage(driver);
    }

}
