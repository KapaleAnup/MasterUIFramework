package com.uiframework.pages;

import com.uiframework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By STOREMUNULINK = By.cssSelector ( "#menu-item-1227 > a" );

    public HomePage ( WebDriver driver ) {
        super ( driver );
    }

    public StorePage clickStoreMenulink(){
        driver.findElement ( STOREMUNULINK ).click ();
        return new StorePage(driver);
    }
}
