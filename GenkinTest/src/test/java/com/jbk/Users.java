package com.jbk;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CommonOperation.Operation;

public class Users {
  @Test(priority=6)
  public void users() {
	  WebElement weUsersClick=Operation.LocateElement(LoginTestTest.driver, "xpath", LoginTestTest.prop.getProperty("Users"));
	  weUsersClick.click();
	  
	 String actualResult=LoginTestTest.driver.getTitle();
	 String expectedResult="AdminLTE 2 | User";
		Assert.assertEquals(expectedResult, actualResult);
  }
}
