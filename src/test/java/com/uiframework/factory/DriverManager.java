package com.uiframework.factory;

import com.uiframework.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    /*
    This method is created to initialize the drivers.
     Handled multi browser
     */
    public WebDriver intializeDriver(String browser){
        WebDriver driver;
        String localbrowser = System.getProperty ( "browser" ,"CHROME");

        switch (DriverType.valueOf (  browser)){
            case CHROME:
                WebDriverManager.chromedriver ().setup ();
               driver = new ChromeDriver (  );
               break;
            case FIREFOX:
                WebDriverManager.firefoxdriver ().setup ();
               driver = new FirefoxDriver (  );
               break;
            default:
                throw new IllegalStateException ( "Invalid browser name: "+browser );
        }

        driver.manage ().window ().maximize ();
        return driver;
    }
}
