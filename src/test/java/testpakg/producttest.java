package testpakg;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basepkg.baseclass;
import basepkg.reporterclass;
import pagepkg.loginpage;
import pagepkg.productpage;



public class producttest extends baseclass{
        loginpage log;
        productpage pdt;
        
        @Test(priority = 1)
        public void logo() throws InterruptedException, IOException
        {
     	   log=new loginpage(driver);
     	   log.setvalues("standard_user", "secret_sauce");
     	   log.buttontext();
     	   Thread.sleep(3000);
     	   
     	   test=extent.createTest("logo validation test");
     	   pdt=new productpage(driver);
     	   WebElement x=pdt.logoverify();
     	   Thread.sleep(3000);
     	   if(x.isDisplayed())
     	   {
     		   test.pass("logo is displayed in product page");
     	   }
     	   else
     	   {
     		   String path=reporterclass.screenshotMethod(driver, "logo_fail");
     		   test.addScreenCaptureFromPath(path);
     		   test.fail("logo not displayed");
     		   
     	   }
        }
        
       @Test(priority = 2)
       public void additemstocart() throws InterruptedException 
       {
    
           pdt=new productpage(driver);
           Thread.sleep(6000);
     	  pdt.additems();
     	  Thread.sleep(6000);
     	  List<WebElement> dtl=pdt.pdtdetails();
           Thread.sleep(6000);
           System.out.println("Total Number of Products: " +dtl.size());
               for(WebElement product : dtl) {
                    System.out.println(product.getText());
             
               }
               
           Thread.sleep(4000);
           pdt.sortpdt();
           test.pass("Products sorted by Price (low to high)");
           
           Thread.sleep(3000);
           pdt.hamIcon();
           test.pass("Hamburger Menu clicked successfully");
               
           Thread.sleep(3000);
           pdt.CartIcon();
           test.pass("Navigated to Cart page successfully");
           
           
        }
       
       
 }