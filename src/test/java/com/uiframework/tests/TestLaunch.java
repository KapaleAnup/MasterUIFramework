package com.uiframework.tests;

import com.uiframework.base.BaseTest;
import com.uiframework.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLaunch extends BaseTest {



    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        driver.get ( "https://askomdch.com/" );
        HomePage homePage = new HomePage ( driver );
        StorePage storePage = homePage.navigateToStoreMenuLink();
        storePage.searchProduct ( "Blue" );
        Assert.assertEquals ( storePage.getTitle (),"Search results: “Blue”");

        storePage.clickAddToCart ("Blue Shoes");
        Thread.sleep ( 5000 );
        CartPage cartPage = storePage.clickViewCart ();

        Assert.assertEquals (cartPage.getPrductName (),"Blue Shoes");
        CheckOutPage checkOutPage = cartPage.checkout ();

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

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

        driver.get ( "https://askomdch.com/" );
        HomePage homePage = new HomePage ( driver );
        StorePage storePage = homePage.navigateToStoreMenuLink();
        storePage.searchProduct ( "Blue" );
        Assert.assertEquals ( storePage.getTitle (),"Search results: “Blue”");

        storePage.clickAddToCart ("Blue Shoes");
        Thread.sleep ( 5000 );
        CartPage cartPage = storePage.clickViewCart ();

        Assert.assertEquals (cartPage.getPrductName (),"Blue Shoes");
        CheckOutPage checkOutPage = cartPage.checkout ();

        CheckoutLoginPage checkoutLoginPage = checkOutPage.clickOnLoginLink ();
        Thread.sleep ( 5000 );

//        checkoutLoginPage.
//                enterUserName ( "Test" ).
//                enterPassword ( "Test@123" )
//                .clickOnLoginButton ();

        checkoutLoginPage.CheckoutLoginDetails ( "Test","Test@123" );


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
