package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;


public class ViewAllOrdersPage extends AbstractBasePage {



   @FindBy (id="ctl00_MainContent_btnDelete")
   private WebElement deleteSelectedBnt;

   @FindBy(xpath = "//td[2]")
   private List<WebElement> nameLst;

   @FindBy(xpath="//tbody//tr//td[12]")
   private List< WebElement > expirationDate;

    @FindBy(xpath="//tbody//tr//td[10]")
    private List< WebElement >cardType;

    @FindBy(xpath="//input[@type='checkbox']")
    private List<WebElement>  checkBoxList;



    public List<WebElement> getCheckBoxList(){
        return checkBoxList;
    }


    public List<String> getCardTypeList(){
        return BrowserUtilities.TextFromWebElement(cardType);
    }

   public List<String> getExpirationDatesList(){
     return BrowserUtilities.TextFromWebElement(expirationDate);
   }

   public List<String > getNameListText(){
       return    BrowserUtilities.TextFromWebElement(nameLst);
   }


   public void clickDeleteSelectedBnt(){
     wait.until(ExpectedConditions.elementToBeClickable(deleteSelectedBnt)).click();

   }
public String clickOnRandomCheckBoxAtTheTableAndReturnName(){
    Random random = new Random();
    int num = random.nextInt(9);
    num = num < 2 ? 2 : num;
    String checkBoxAtTheTable = "ctl00_MainContent_orderGrid_ctl0"+num+"_OrderSelector";
   // driver.findElement(By.id(checkBoxAtTheTable)).click();
wait.until(ExpectedConditions.elementToBeClickable(By.id(checkBoxAtTheTable))).click();
    String nameBy="(//input[@id='"+checkBoxAtTheTable+"']/../following-sibling::td)[1]";
    return driver.findElement(By.xpath(nameBy)).getText();
}

}
