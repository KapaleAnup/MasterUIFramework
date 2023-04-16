package com.uiframework.tests;

import com.uiframework.base.BaseTest;
import com.uiframework.pages.HomePage;
import com.uiframework.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLaunch extends BaseTest {



    @Test
    public void guestCheckoutUsingDirectBankTransfer(){

        driver.get ( "https://askomdch.com/" );
        HomePage homePage = new HomePage ( driver );
        StorePage storePage = homePage.clickStoreMenulink ();
        storePage.enterSearchText ( "Blue" );
        storePage.clickSearchButton ();
        Assert.assertEquals ( storePage.getTitle (),"Search results: “Blue”");
        ;
        storePage.clickAddToCart ();


    }
}
