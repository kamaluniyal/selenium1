package SeleniumTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


//https://intranet.mgmt.local/D/PTC1/login?redir=/D/PTC1/
public class TestNgTest1 extends ParentClass {

	ParentClass test;
	
  @Test(priority=0)
  public void launchUrl() {
	  this.test.init();
	  this.test.launchUrl("https://intranet.mgmt.local/D/PTC1/TAFTestPage");
	  driver.manage().window().maximize();		
  }
  
  @Test(priority=1)
  public void SelectRadio(){
	  String value="option2";
	  List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='main-panel']/div[2]/div/div[3]/div[2]//input"));
		for(WebElement radio : allElements){
			if(value.equals(radio.getAttribute("value"))){
				radio.click();
				return;
			}
		}
  }
	
  @BeforeClass
  public void beforeMethod() {
	  this.test = new ParentClass();
  }

  @AfterClass
  public void afterMethod() {
	  driver.quit();
  }

}
