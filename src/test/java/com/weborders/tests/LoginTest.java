package com.weborders.tests;

import com.weborders.pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends  AbstractBaseTest {
    LoginPage loginPage;

    @Test
    public void login(){
        extentTest= extentReports.createTest("Verify page logo");

     loginPage=new LoginPage();
        loginPage.login();
        assertEquals(loginPage.getPageLogoText(),"Web Orders");

        extentTest.pass("Logo verified");
    }


}
