package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.ViewAllOrdersPage;
import org.openqa.selenium.WebElement;
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
 * login web orders
 * go to view all orders
 * if the card expired
 * delete that person from system except who has master card
 * verify it is deleted
 *
 *Note:take ex. date as  01/09(excluded)
 */
@Test
public void verifyExpiredCardDeletedFromFromTable(){
    extentTest=extentReports.createTest("Verify expired card deleted");
    LoginPage loginPage= new LoginPage();
    loginPage.login();
    loginPage.navigateTo("View all orders");
    ViewAllOrdersPage p= new ViewAllOrdersPage();

    List<String > beforeDataLst= p.getNameListText();
    List<String > expirationDateLst= p.getExpirationDatesList();
    List<String> cardTypeLst=p.getCardTypeList();
    System.out.println(cardTypeLst);
    List<WebElement >checkBox= p.getCheckBoxList();
    int count =0;
int masterCount=0;
    for(int i=0 ;i<expirationDateLst.size();i++){
        if(!expirationDateLst.get(i).endsWith("9") || !expirationDateLst.get(i).endsWith("10")
                || !expirationDateLst.get(i).endsWith("11 ") || expirationDateLst.get(i).endsWith("12")){
            if(cardTypeLst.get(i).trim().equals("MasterCard")){
masterCount++;

            }else{
                checkBox.get(i).click();
                p.clickDeleteSelectedBnt();
                count++;

            }
        }

    }
   List<String> afterDataList=p.getNameListText();
    System.out.println(count +"   data deleted");
    Assert.assertNotEquals(beforeDataLst.size(),afterDataList.size(),"list sizes are equal" );

}


}
