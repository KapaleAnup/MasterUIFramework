package com.uiframework.tests;

import com.uiframework.base.BaseTest;
import com.uiframework.pages.CartPage;
import com.uiframework.pages.CheckOutPage;
import com.uiframework.pages.HomePage;
import com.uiframework.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLaunch extends BaseTest {



    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        driver.get ( "https://askomdch.com/" );
        HomePage homePage = new HomePage ( driver );
        StorePage storePage = homePage.clickStoreMenulink ();
        storePage.searchProduct ( "Blue" );
        Assert.assertEquals ( storePage.getTitle (),"Search results: “Blue”");

        storePage.clickAddToCart ("Blue Shoes");
        Thread.sleep ( 5000 );
        CartPage cartPage = storePage.clickViewCart ();

        Assert.assertEquals (cartPage.getPrductName (),"Blue Shoes");
        CheckOutPage checkOutPage = cartPage.clickCheckOutButton ();

        checkOutPage
                .enterFirstName ( "demo" )
                .enterLastName ( "user" )
                .enterAddress ( "San francisco" )
                .enterCity ( "San Francisco" )
                .enterPostalCode ( "94188" )
                .enterEmail ( "asktest@gmail.com" )
                .placeOder ();

        Thread.sleep ( 5000 );
        Assert.assertEquals ( checkOutPage.getMessage (),"Thank you. Your order has been received." );





    }
}
