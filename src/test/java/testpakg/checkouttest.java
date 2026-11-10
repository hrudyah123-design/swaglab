package testpakg;

import org.testng.annotations.Test;

import pagepkg.checkoutpage;
import pagepkg.loginpage;
import pagepkg.productpage;
import basepkg.baseclass;


public class checkouttest extends baseclass{
		@Test
	    public void verifyCheckoutProcess() throws InterruptedException {
	        loginpage log = new loginpage(driver);
	        productpage pdt = new productpage(driver);
	        checkoutpage ckout = new checkoutpage(driver);
	        
	        test = extent.createTest("Checkout Process Test");
	        
	       
	        log.setvalues("standard_user", "secret_sauce");
	        log.buttontext();
	        Thread.sleep(2000);
	        
	       
	        pdt.additems();
	        Thread.sleep(5000);
	        

	        ckout.clickCart();
	        Thread.sleep(3000);
	        
	       
	        ckout.clickcheckOut();
	        Thread.sleep(3000);
	        
	       
	        ckout.setDetails("hrudya", "kallara", "695608");
	        Thread.sleep(3000);
	        
	       
	        ckout.clickFinish();
	        Thread.sleep(3000);
	   
	        ckout.clickHamburgerMenu();
	        Thread.sleep(3000);
	        
	       
	        ckout.clickLogout();
	        Thread.sleep(3000);
	        
	        test.pass("Checkout process completed successfully");
	    }
	
    
	
}	    