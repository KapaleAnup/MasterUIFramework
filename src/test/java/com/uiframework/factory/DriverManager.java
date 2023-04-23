package com.uiframework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    /*
    This method is created to initialize the drivers.
     */
    public WebDriver intializeDriver(){

        WebDriver driver = new ChromeDriver (  );
        driver.manage ().window ().maximize ();
       // driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 15 ) );
        return driver;
    }
}
