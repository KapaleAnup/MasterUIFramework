package com.uiframework.pages;

import com.uiframework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By SEARCHFIELD= By.cssSelector ( "#woocommerce-product-search-field-0");
    private final By SERACH_BUTTON = By.cssSelector ( "button[value='Search']" );
    private final By SEARCH_TITLE = By.cssSelector ( ".woocommerce-products-header__title.page-title" );
    private final By ADDTOCART_BUTTON = By.cssSelector ( "a[aria-label='Add “Blue Shoes” to your cart']" );

    public StorePage ( WebDriver driver ) {
        super (driver );
    }

    public void enterSearchText(String text){
        driver.findElement ( SEARCHFIELD ).sendKeys ( text );
    }

    public void clickSearchButton(){
        driver.findElement ( SERACH_BUTTON ).click ();
    }

    public String getTitle(){
        return driver.findElement ( SEARCH_TITLE ).getText ();
    }

    public void clickAddToCart(){
        driver.findElement ( ADDTOCART_BUTTON ).click ();
    }

}
