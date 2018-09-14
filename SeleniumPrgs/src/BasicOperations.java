import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicOperations {

	static WebDriver driver ;
	void enterText(WebElement element,String text){
		element.sendKeys(text);
	}
	String getElementText(WebElement element){
		return element.getText();
	}
	String getAttributeValue(WebElement element,String attribute){
		return element.getAttribute(attribute);
	}
	boolean isDispalyed(WebElement element){
		return element.isDisplayed();
	}
	
	boolean isEnabled(WebElement element){
		return element.isEnabled();
	}
	boolean isSelected(WebElement element){
		return element.isSelected();
	}
	void clickonElement(WebElement element){
		if(isEnabled(element)){
			element.click();
		}
		else
		{
			System.out.println("Element not enabled to be clicked");
		}
	}
	void clearElement(WebElement element){
		element.clear();
	}
	void selectRadioGrpByValue(String value){
	 	List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='main-panel']/div[2]/div/div[3]/div[2]//input"));
		for(WebElement radio : allElements){
			if(value.equals(radio.getAttribute("value"))){
				radio.click();
				return;
			}
		}
 }
	
	void hoverOver() throws InterruptedException{
		SeleniumActions action = new SeleniumActions();
		WebElement element = driver.findElement(By.id("hoverMe")); 
		Thread.sleep(5000);
		action.mouseOver(element,driver);
		Thread.sleep(5000);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		BasicOperations basicOps = new BasicOperations();		
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("https://intranet.mgmt.local/D/PTC1/TAFTestPage");
		/*		
		basicOps.selectRadioGrpByValue("option2");
		Thread.sleep(5000);
		basicOps.selectRadioGrpByValue("option1");
		Thread.sleep(5000);
		basicOps.selectRadioGrpByValue("option3");
		*/
		
		DropDownOperations dropDownList = new DropDownOperations(driver.findElement(By.id("select")));
		
		System.out.println("NumberOfElements"+dropDownList.getNumberOfElement());		
		List<String> values = dropDownList.getAllOptions();		
		for(String value:values){
			System.out.println(value);
		}		
		dropDownList.selectItem("selectByValue", "Mutual Funds");
		Screenshot takescreenshot = new Screenshot();
		takescreenshot.saveScreenshot(driver,"D:\\screenshot\\screen2.png");
		takescreenshot.saveScreenshot(driver,"D:\\screenshot\\screen3.png",driver.findElement(By.id("select")));
		Thread.sleep(5000);
		
		basicOps.hoverOver();
						
		System.out.println("Test finished..Exit");
		driver.quit();

	}

}
