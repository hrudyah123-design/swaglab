package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class productpage {
        WebDriver driver;
        
        @FindBy(xpath ="//div[@class='app_logo']")
        WebElement logo;
        
        @FindBy(xpath = "//a[@class='shopping_cart_link']")
        WebElement cartIcon;
        
        @FindBy(xpath = "//*[text()='Add to cart']")
        List<WebElement>cartButton;
        
        @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div")
        List<WebElement>productdetails;
        
        @FindBy(xpath = "//*[@id='react-burger-menu-btn\']")
        WebElement hamburgerIcon;
        
        @FindBy(xpath = "//select[@class='product_sort_container']")
        WebElement sortDropdown;
        
        public productpage(WebDriver driver)
        {
       	 this.driver=driver;
       	 PageFactory.initElements(driver, this);
        }
        
        
        public WebElement logoverify()
        {
      	   return logo;
        }
         
        public void additems() throws InterruptedException
        {
       	 
       	 for(WebElement items:cartButton)
       	 {   
       		 System.out.println(items);
//       		 Thread.sleep(5000);
       		 items.click();
//       		 Thread.sleep(5000);
       		 
       	 }
        }
        
        public List<WebElement> pdtdetails()
        {
       	 return productdetails;
        }
        
        public void hamIcon()
        {
       	 hamburgerIcon.click();
        }
        
        
        public  void sortpdt()
        {
       	 sortDropdown.click();
       	 Select sel=new Select(sortDropdown);
       	 sel.selectByValue("hilo");
        }
        public void CartIcon()
        {
       	 cartIcon.click();
        }
        
}