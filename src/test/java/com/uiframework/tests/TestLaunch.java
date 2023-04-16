package com.uiframework.tests;

import com.uiframework.base.BaseTest;
import com.uiframework.objects.BillingAddress;
import com.uiframework.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLaunch extends BaseTest {



    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

/*
        BillingAddress billingAddress = new BillingAddress ()
                .setFirstName ( "demo" )
                .setLastName ( "user" )
                .setAddress ( "San Fransisco" )
                .setCity ( "San Fransisco" )
                .setPostalCode ( "94188" )
                .setEmail ( "asktest@gmail.com" );
*/

        BillingAddress billingAddress = new BillingAddress ("demo", "user","San Fransisco","San Fransisco",
                "94188","asktest@gmail.com");

        StorePage storePage = new HomePage ( driver )
                .launchURL ()
                .navigateToStoreMenuLink ()
                .searchProduct ( "Blue" );
        Assert.assertEquals ( storePage.getTitle (),"Search results: “Blue”");

        storePage.clickAddToCart ("Blue Shoes");
        Thread.sleep ( 5000 );
        CartPage cartPage = storePage.clickViewCart ();
        Assert.assertEquals (cartPage.getPrductName (),"Blue Shoes");

        CheckOutPage checkOutPage = cartPage.
                checkout ()
                .setBillingAddress ( billingAddress )
                .placeOder ();

        Thread.sleep ( 5000 );
        Assert.assertEquals ( checkOutPage.getMessage (),"Thank you. Your order has been received." );

    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
       /* BillingAddress billingAddress = new BillingAddress ()
                .setFirstName ( "demo" )
                .setLastName ( "user" )
                .setAddress ( "San Fransisco" )
                .setCity ( "San Fransisco" )
                .setPostalCode ( "94188" )
                .setEmail ( "asktest@gmail.com" );*/

        BillingAddress billingAddress = new BillingAddress ("demo", "user","San Fransisco","San Fransisco",
                "94188","asktest@gmail.com");

        StorePage storePage = new HomePage ( driver )
                .launchURL ()
                .navigateToStoreMenuLink ()
                .searchProduct ( "Blue" );
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

        checkOutPage.
                setBillingAddress ( billingAddress).placeOder ();

        Thread.sleep ( 5000 );
        Assert.assertEquals ( checkOutPage.getMessage (),"Thank you. Your order has been received." );


    }
}
