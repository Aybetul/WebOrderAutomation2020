package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.ViewAllOrdersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ViewAllOrdersTest  extends AbstractBaseTest{
//WebDriver driver= Driver.getDriver();


    /**
     * login Web orders
     * Go to View All orders
     * select random name
     * print the name
     * delete selected name
     * verify selected name deleted
     *
     */


    @Test
    public void verifyTableChangeAfterDelete() {
        extentTest = extentReports.createTest("Verify selected name deleted");
LoginPage loginPage=new LoginPage();
loginPage.login();
loginPage.navigateTo("View all orders");
        ViewAllOrdersPage p=new ViewAllOrdersPage();
List<String> listBefore=      p.getNameListText();
        System.out.println("Before  "+listBefore);
String name=p.clickOnRandomCheckBoxAtTheTableAndReturnName();
        System.out.println(name);
p.clickDeleteSelectedBnt();
List<String> listAfter= p.getNameListText();
        System.out.println("After "+listAfter);
        Assert.assertTrue(!listAfter.contains(name));
extentTest.pass("Verified selected name deleted");
    }

/**
 * find most frequent card type and print
 *check if ex. date before 09 delete the person info
 *
 */



}
