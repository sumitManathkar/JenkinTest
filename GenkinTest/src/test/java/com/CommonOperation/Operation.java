package com.CommonOperation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Operation {
	
	public static void EnterText(WebElement e,String text){
		e.sendKeys(text);
		
	}
	
	public static WebElement LocateElement(WebDriver driver,String locType,String locValue){
		WebElement e=null;
		if(locType.equalsIgnoreCase("id"))
			e= driver.findElement(By.id(locValue));
		if(locType.equalsIgnoreCase("xpath"))
			e= driver.findElement(By.xpath(locValue));
		return e;
	}

}
