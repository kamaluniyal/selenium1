package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='nav-link-yourAccount']/span[1]")
	WebElement helloSignInLink;
	
	@FindBy(xpath="//*[@id='nav-flyout-ya-signin']/a/span")
	WebElement signInButton;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="signInSubmit")
	WebElement submit;
	
	
	private void enterEmail(String emailId){
		this.email.sendKeys(emailId);
	}
	
	private void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void signIn(String email,String password) throws InterruptedException{
		Actions builder = new Actions(driver);
		builder.moveToElement(helloSignInLink).build().perform();
		Thread.sleep(2000);
		signInButton.click();
		Thread.sleep(10000);
		enterEmail(email);
		continueButton.click();
		Thread.sleep(10000);
		enterPassword(password);
		submit.submit();				
	}
		
	LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}

}
