package com.jbk;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CommonOperation.Operation;

import Utility.Util;
import jxl.Sheet;
import jxl.Workbook;

public class LoginTestTest {
	static WebDriver driver=null;
	  String actualResult=null;
	  String expectedResult=null;
	  static Properties prop=null;
	  Workbook wb=null;
	  Sheet sheet;
		
		@BeforeTest
		
		public void setUpEnv() throws Exception{
			//C:\JBK Eclipse Configured 32-bit\JBK Eclipse Configured 32-bit\JBK Eclipse Configured\eclipse\workspace\Selenium19-Jan\src\Config\info.properties
			System.out.println(System.getProperty("user.dir"));
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/Config/info.properties");
			prop=new Properties();
			prop.load(fis);
			fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/TestData/TestData.xls");
			wb=Workbook.getWorkbook(fis);
			sheet=wb.getSheet(0);
			driver=Util.OpenBrowser(prop.getProperty("Browser"),prop.getProperty("URL"));
		}
		@Test(priority=1)
	  public void checkTitle() {
			actualResult=driver.getTitle();
			expectedResult="AdminLTE 2 | Log in";
			Assert.assertEquals(expectedResult, actualResult);
	  }
		
		@Test(priority=2)
		public void invalidEmailError(){
			//WebElement weUserName=driver.findElement(By.id("email"));
			WebElement weUserName=Operation.LocateElement(driver, "id", prop.getProperty("Email"));
			weUserName.clear();
			//weUserName.sendKeys("abc@gmail.com");
			Operation.EnterText(weUserName,sheet.getCell(0, 1).getContents());
			
			//WebElement wePasword=driver.findElement(By.xpath("//input[@id='password']"));//or//(By.xpath("/html/body/div/div[2]/form/div[2]/input"));
			WebElement wePasword=Operation.LocateElement(driver, "xpath", prop.getProperty("Password"));
			wePasword.clear();
			//wePasword.sendKeys("123456");
			Operation.EnterText(wePasword,sheet.getCell(1, 1).getContents());
			
			//WebElement weClick= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']"));//or//(By.xpath(".//*[@id='form']/div[3]/div/button"));
			WebElement weClick=Operation.LocateElement(driver, "xpath", prop.getProperty("Submit"));
			weClick.click();
			//WebElement weEmailError=driver.findElement(By.xpath("//*[@id='email_error']"));
			WebElement weEmailError=Operation.LocateElement(driver, "xpath", prop.getProperty("EmailError"));
			actualResult=weEmailError.getText();
			expectedResult="Please enter email as kiran@gmail.com";
			Assert.assertEquals(expectedResult, actualResult);
		}
		
		@Test(priority=3)
		public void invalidPasswordError(){
			//WebElement weUserName=driver.findElement(By.id("email"));
			WebElement weUserName=Operation.LocateElement(driver, "id", prop.getProperty("Email"));
			weUserName.clear();
			Operation.EnterText(weUserName,sheet.getCell(0, 2).getContents());
			//weUserName.sendKeys("abc@gmail.com");
			
			//WebElement wePasword=driver.findElement(By.xpath("//input[@id='password']"));//or//(By.xpath("/html/body/div/div[2]/form/div[2]/input"));
			WebElement wePasword=Operation.LocateElement(driver, "xpath", prop.getProperty("Password"));
			wePasword.clear();
			//wePasword.sendKeys("12345");
			Operation.EnterText(wePasword,sheet.getCell(1, 2).getContents());
			
			//WebElement weClick= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']"));//or//(By.xpath(".//*[@id='form']/div[3]/div/button"));
			WebElement weClick=Operation.LocateElement(driver, "xpath", prop.getProperty("Submit"));
			weClick.click();
			//WebElement wePasswordError=driver.findElement(By.xpath("//*[@id='password_error']"));
			WebElement wePasswordError=Operation.LocateElement(driver, "xpath", prop.getProperty("PasswordError"));
			
			actualResult=wePasswordError.getText();
			expectedResult="Please enter password 123456";
			Assert.assertEquals(expectedResult, actualResult);
			
		}
		@Test(priority=4)
		public void blankEmaiPasswordError(){
			//WebElement weUserName=driver.findElement(By.id("email"));
			WebElement weUserName=Operation.LocateElement(driver, "id", prop.getProperty("Email"));
			weUserName.clear();
			//weUserName.sendKeys("");
			Operation.EnterText(weUserName,sheet.getCell(0, 3).getContents());
			
			//WebElement wePasword=driver.findElement(By.xpath("//input[@id='password']"));//or//(By.xpath("/html/body/div/div[2]/form/div[2]/input"));
			WebElement wePasword=Operation.LocateElement(driver, "xpath", prop.getProperty("Password"));
			wePasword.clear();
			//wePasword.sendKeys("");
			Operation.EnterText(wePasword,sheet.getCell(1, 3).getContents());
			
			//WebElement weClick= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']"));//or//(By.xpath(".//*[@id='form']/div[3]/div/button"));
			WebElement weClick=Operation.LocateElement(driver, "xpath", prop.getProperty("Submit"));
			weClick.click();
			//WebElement weEmailError=driver.findElement(By.xpath("//*[@id='email_error']"));
			WebElement weEmailError=Operation.LocateElement(driver, "xpath", prop.getProperty("EmailError"));
			
			actualResult=weEmailError.getText();
			expectedResult="Please enter email.";
			Assert.assertEquals(expectedResult, actualResult);
			
			//WebElement wePasswordError=driver.findElement(By.xpath("//*[@id='password_error']"));
			WebElement wePasswordError=Operation.LocateElement(driver, "xpath", prop.getProperty("PasswordError"));
			
			actualResult=wePasswordError.getText();
			expectedResult="Please enter password.";
			Assert.assertEquals(expectedResult, actualResult);
			
		}
		@Test(priority=5)
		public void Dashboard(){
			//WebElement weUserName=driver.findElement(By.id("email"));
			WebElement weUserName=Operation.LocateElement(driver, "id", prop.getProperty("Email"));
			weUserName.clear();
			//weUserName.sendKeys("kiran@gmail.com");
			Operation.EnterText(weUserName,sheet.getCell(0, 4).getContents());
			
			//WebElement wePasword=driver.findElement(By.xpath("//input[@id='password']"));//or//(By.xpath("/html/body/div/div[2]/form/div[2]/input"));
			WebElement wePasword=Operation.LocateElement(driver, "xpath", prop.getProperty("Password"));
			wePasword.clear();
			//wePasword.sendKeys("123456");
			Operation.EnterText(wePasword,sheet.getCell(1, 4).getContents());
			
			//WebElement weClick= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-flat']"));//or//(By.xpath(".//*[@id='form']/div[3]/div/button"));
			WebElement weClick=Operation.LocateElement(driver, "xpath", prop.getProperty("Submit"));
			weClick.click();
			
			actualResult=driver.getTitle();
			expectedResult="AdminLTE 2 | Dashboard";
			Assert.assertEquals(expectedResult, actualResult);
		}
}
