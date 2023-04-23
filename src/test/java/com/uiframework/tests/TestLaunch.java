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
    public void guestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {

        //parse jason object to java object
       BillingAddress billingAddress = JacksonUtils.deserializeJson ( "BillingAddress.json", BillingAddress.class );
        Product product = new Product ( 1211 );


        StorePage storePage = new HomePage ( driver )
                .launchURL ()
                .navigateToStoreMenuLink ()
                .searchProduct ( "dark" );
        Assert.assertEquals ( storePage.getTitle (),"Search results: “dark”");

        storePage.clickAddToCart (product.getName ());
        CartPage cartPage = storePage.clickViewCart ();
        Assert.assertEquals (cartPage.getPrductName (),product.getName ());

        CheckOutPage checkOutPage = cartPage.
                checkout ()
                .setBillingAddress ( billingAddress )
                .placeOder ();

        Assert.assertEquals ( checkOutPage.getMessage (),"Thank you. Your order has been received." );

    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

        BillingAddress billingAddress = JacksonUtils.deserializeJson ( "BillingAddress.json", BillingAddress.class );
        Product product = new Product ( 1211 );

        StorePage storePage = new HomePage ( driver )
                .launchURL ()
                .navigateToStoreMenuLink ()
                .searchProduct ( "dark" );
        Assert.assertEquals ( storePage.getTitle (),"Search results: “dark”");

        storePage.clickAddToCart (product.getName ());
        CartPage cartPage = storePage.clickViewCart ();

        Assert.assertEquals (cartPage.getPrductName (),product.getName ());
        CheckOutPage checkOutPage = cartPage.checkout ();

        CheckoutLoginPage checkoutLoginPage = checkOutPage.clickOnLoginLink ();
        checkoutLoginPage.CheckoutLoginDetails ( "Test","Test@123" );

        checkOutPage.
                setBillingAddress ( billingAddress).placeOder ();
        Assert.assertEquals ( checkOutPage.getMessage (),"Thank you. Your order has been received." );


    }
}
