package testpakg;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import basepkg.baseclass;
import basepkg.reporterclass;
import pagepkg.loginpage;
import utilities.excelutil;


public class logintest extends baseclass{
         loginpage log;
          
          
          @DataProvider(name="loginData")
          public Object[][]getData() throws IOException
          {
        	  String path="C:\\Users\\i\\Downloads\\saucedata.xlsx";
        	  return excelutil.getTestData(path,"saucedata");
          }

          @Test(dataProvider = "loginData")
          public void loginTest(String user,String password) throws IOException, InterruptedException 
          {
        	  driver.get("https://www.saucedemo.com/");
        	  
        	  test=extent.createTest("Login Test -" + user);
        	  
        	  log=new loginpage(driver);
        	  
        	  log.setvalues(user, password);
        	 
        	  
        	  System.out.println("Executed for: " + user);
        	  
        	  String currentUrl= driver.getCurrentUrl();
//        	  Thread.sleep(3000);
        	  
        	  if(currentUrl.equals("https://www.saucedemo.com/inventory.html"))
        		  
        	  {
        		  Thread.sleep(3000);
        		  test.pass("Login successful for: " + user);
        	  }
        	  
        	  else {
        	           Thread.sleep(2000);
        		  String screenshotName= "LoginFailed_" + user;
        		  
                  reporterclass.screenshotMethod(driver, screenshotName);
        		  
        		  test.addScreenCaptureFromPath("screenshot\\" + screenshotName + ".png");
        		  
        		  test.fail("Login failed for:" +user);
        		  
        		  Assert.fail("Login failed for:" +user);
        		  
        		  
        	  }
          }
         
          
          @Test
          public void logoverification() throws IOException
          {
        	  driver.get("https://www.saucedemo.com/");

        	  test=extent.createTest("Logo Validation Test");
        	  
        	  log=new loginpage(driver);
        	  
        	  WebElement x=log.logoverifiaction();
        	  
        	  if(x.isDisplayed())
        	  {
        		  test.pass("Logo displayed");
        	  }
        	  else
        	  {
        		  String screenshotName = "logo_validation";
        		  
        		  reporterclass.screenshotMethod(driver, screenshotName);
        		  
        		  test.addScreenCaptureFromPath("screenshot\\"+ screenshotName+ ".png");
        		  
        		  test.fail("Logo not displayed");
        		  
        		  Assert.fail("Logo not displayed");
        	  }
        	  
        	  		
        	  
          }
          
          @Test
          public void buttontextvalidation() throws IOException
          {
        	  driver.get("https://www.saucedemo.com/");
        	  
              test=extent.createTest("Button Text Validation Test");
        	  
        	  log=new loginpage(driver);
        	  
        	  String text=log.buttontext().getDomAttribute("value");
        	  
        	  if(text.equals("Login"))
        	  {
        		  test.pass("Button text is Login");
        	  }
        	  
        	  else
        	  {
        		  String screenshotName = "button_text_validation";
        		  
                  reporterclass.screenshotMethod(driver, screenshotName);
        		  
        		  test.addScreenCaptureFromPath("screenshot\\"+ screenshotName+ ".png");
        		  
        		  test.fail("Button Text is not Login");
        		  
        		  Assert.fail("Button Text is not Login");
        		  
        	  }
        	  
        	  
          }
          
          @Test
          public void placeholdervalidation() throws IOException
          {
        	  driver.get("https://www.saucedemo.com/");
        	  
              test=extent.createTest("Placeholder validation Test ");
        	  
        	  log=new loginpage(driver);
        	  
        	  String username=log.username.getDomAttribute("placeholder");
        	  
        	  String password=log.password.getDomAttribute("placeholder");
        	  
        	  
			  if(username.equals("Username") && password.equals("Password"))
        	  {
        		  test.pass("placeholder validation passed");
        	  }
        	  else
        	  {
                  String screenshotName = "placeholder_validation";
        		  
                  reporterclass.screenshotMethod(driver, screenshotName);
        		  
        		  test.addScreenCaptureFromPath("screenshot\\"+ screenshotName+ ".png");
        		  
        		  test.fail("Placeholder validation failed");
        		  
        		  Assert.fail("placeholder validation failed");
        	  }
        	  
        	  
          }
          
          @Test
          public void Titlefetch() throws IOException
          {
              driver.get("https://www.saucedemo.com/");
        	  
              test=extent.createTest("Title Validation Test ");
        	  
        	  
        	  
        	  String act=driver.getTitle();
        	  
        	  String exp="Swag Labs";
        	  
        	  if(exp.equals(act))
        	  {
        		  test.pass("Title Validation passed");
        	  }
        	  else
        	  {
                  String screenshotName = "title_validation";
        		  
                  reporterclass.screenshotMethod(driver, screenshotName);
        		  
        		  test.addScreenCaptureFromPath("screenshot\\"+ screenshotName+ ".png");
        		  
        		  test.fail("Title Validation failed");
        		  
        		  Assert.fail("Title Validation failed");
        	  }
        	  
        	  
          }
          
          
}