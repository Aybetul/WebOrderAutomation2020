package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import com.weborders.utilities.BrowserUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends AbstractBaseTest {




    /**
     * * Go to WebOrders website and login
     * * Select Order page
     * * Under product information :
     * *Select Screensaver as a product
     * *Type 5 for Quantity
     * *Verify price per unit is 20
     * *Verify no discount
     */
    @Test
    public void  VerificationOfProductQuantity(){
        extentTest = extentReports.createTest("Verify discount and per price");
      LoginPage loginpage=new LoginPage();
      loginpage.login();
      loginpage.navigateTo("Order");
        OrderPage orderpage=new OrderPage();
        orderpage.selectOptionsByVisibleText("ScreenSaver");
        orderpage.enterQuantity("5");
        orderpage.clickOnCalculate();
        String discount=orderpage.getDiscountText();
         String perUnitPrice= orderpage.getPerUnitText();
        BrowserUtilities.wait(2);
        Assert.assertEquals(perUnitPrice,"20");
        Assert.assertEquals(orderpage.getDiscountText(),"0");
        extentTest.pass("verified");
    }


}
