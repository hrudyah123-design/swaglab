package pagepkg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutpage {
		WebDriver driver;

		
	    @FindBy(xpath = "//div[@id='shopping_cart_container']")
	    WebElement carticon;

	    
	    @FindBy(id = "checkout")
	    WebElement checkoutBtn;

	    // Checkout Form Elements
	    @FindBy(id = "first-name")
	    WebElement firstname;

	    @FindBy(id = "last-name")
	    WebElement lastname;

	    @FindBy(id = "postal-code")
	    WebElement zipcode;

	    @FindBy(id = "continue")
	    WebElement continueBtn;

	    @FindBy(id = "finish")
	    WebElement finishBtn;
	    
	    @FindBy(id = "react-burger-menu-btn")
	    WebElement hamburgerMenu;
	    
	    @FindBy(id = "logout_sidebar_link")
	    WebElement logoutLink;

	  
	    public checkoutpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	   
	    public void clickCart() {
	        carticon.click();
	    }
	    public void clickcheckOut()
	    {
		checkoutBtn.click();
	    }
	    public void setDetails(String fname, String lname, String zip)
	    {
	        firstname.sendKeys(fname);
	        lastname.sendKeys(lname);
	        zipcode.sendKeys(zip);
	        continueBtn.click();
	    }

	    
	    public void clickFinish() {
	        finishBtn.click();
	    }
	   

	    public void clickHamburgerMenu() {
	        hamburgerMenu.click();
	    }

	    public void clickLogout() {
	        logoutLink.click();
	    }
	}