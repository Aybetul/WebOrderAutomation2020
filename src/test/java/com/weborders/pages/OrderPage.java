package com.weborders.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;


public class OrderPage extends  AbstractBasePage {

@FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement ProductInput;

@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement QuantityInput;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement PricePerInput;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement DiscountInput;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement TotalInput;

    @FindBy(xpath="//input[@type='submit']")
    private WebElement Calculate;

  public  void selectOptionsByVisibleText(String option){
      Select select=new Select(ProductInput);
      select.selectByVisibleText(option);
  }

public void enterQuantity(String q){
   QuantityInput.sendKeys(q);

}
    public String getQuantityText(){
      return QuantityInput.getAttribute("value");
  }

public String getPerUnitText(){
      return  PricePerInput.getAttribute("value");
}
public String getDiscountText(){
  return  DiscountInput.getAttribute("value");
}

public void clickOnCalculate(){
      Calculate.click();
 // wait.until(ExpectedConditions.elementToBeClickable(Calculate)) ;
}


}
