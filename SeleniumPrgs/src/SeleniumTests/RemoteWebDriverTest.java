package SeleniumTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class RemoteWebDriverTest{
  
	WebDriver driver ;
	
	@Test
  public void login() throws IOException {
		driver.get("http://google.com");
		takescreenshot();
  }
    
  
	@BeforeClass
  public void beforeClass() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.129.9.237:4444/wd/hub/"),capability);
		this.driver=driver;
  }
  
  
	@AfterClass
  public void afterClass() {
		driver.quit();
		
  }
	
	void takescreenshot() throws IOException{
		WebDriver remotedriver = new Augmenter().augment(this.driver);		
		File screenshot = ((TakesScreenshot)remotedriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:/screenshot/remoteScreenshot2.png"));
				
		// Even normal screenshot works without augmenter		
		// File screenshot = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);		
		// FileUtils.copyFile(screenshot, new File("D:/screenshot/remoteScreenshot.png"));
	}

}





















