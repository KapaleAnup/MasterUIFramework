package com.uiframework.tests;

import com.uiframework.base.BaseTest;
import com.uiframework.objects.BillingAddress;
import com.uiframework.objects.Product;
import com.uiframework.pages.*;
import com.uiframework.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestLaunch extends BaseTest {



    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

/*
        BillingAddress billingAddress = new BillingAddress ()
                .setFirstName ( "demo" )
                .setLastName ( "user" )
                .setAddress ( "San Fransisco" )
                .setCity ( "San Fransisco" )
                .setPostalCode ( "94188" )
                .setEmail ( "asktest@gmail.com" );
*/

        /*BillingAddress billingAddress = new BillingAddress ("demo", "user","San Fransisco","San Fransisco",
                "94188","asktest@gmail.com");*/

        //parse jason object to java object
       BillingAddress billingAddress = JacksonUtils.deserializeJson ( "BillingAddress.json", BillingAddress.class );
        Product product = new Product ( 1211 );


        StorePage storePage = new HomePage ( driver )
                .launchURL ()
                .navigateToStoreMenuLink ()
                .searchProduct ( "dark" );
        Assert.assertEquals ( storePage.getTitle (),"Search results: “dark”");

        storePage.clickAddToCart (product.getName ());
        Thread.sleep ( 5000 );
        CartPage cartPage = storePage.clickViewCart ();
        Assert.assertEquals (cartPage.getPrductName (),product.getName ());

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
