import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActions {

	 //WebDriver driver ;
	 //Actions builder ;
	 
	 SeleniumActions(){
		 //this.driver = driver;
		 //this.builder = new Actions(driver);		 
	 }
	
	void doubleClick(WebElement element){
		//builder.doubleClick(element).build().perform();
	}
	
	void mouseOver(WebElement element,WebDriver driver){
		Actions builder = new Actions(driver);	
		builder.moveToElement(element).build().perform();
	}
	

}
