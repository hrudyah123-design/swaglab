package pagepkg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	       WebDriver driver;
	     
	       @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
	       WebElement logo;
	       
	       @FindBy(xpath = "/html/head/title")
	       WebElement title;
	       
	       @FindBy(xpath = "//*[@id=\"user-name\"]")
		   public WebElement username;
		
	      
	       
	       @FindBy(xpath="//*[@id=\"password\"]")
	       public WebElement password;
	       
	       @FindBy(xpath = "//*[@id=\"login-button\"]")
	       public  WebElement login;
	       
	       public loginpage(WebDriver driver)
	       {
	    	   this.driver=driver;
	    	   PageFactory.initElements(driver, this);
	    	   
	       }
	       public WebElement logoverifiaction()
	       {
	    	   return logo;
	       }
	       
	       public WebElement buttontext()
	       {
	    	   return login;
	       }
	       public void setvalues(String user,String pass) throws InterruptedException
	       {
	    	   
	    	   username.sendKeys(user);
	    	   password.sendKeys(pass);
//	    	   Thread.sleep(4000);
	    	   login.click();
	    	   Thread.sleep(3000);
	    	  
	    	  
	      }
	       
	       
	     }
