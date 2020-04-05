package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

// Meant to be extended
public abstract class AbstractBasePage {
  protected WebDriver driver=Driver.getDriver();
  protected WebDriverWait wait= new WebDriverWait(driver,20);

    //this contractor for annotations
  public AbstractBasePage(){
      PageFactory.initElements(driver,this);
  }




}
