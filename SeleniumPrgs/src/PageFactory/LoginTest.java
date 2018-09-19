package PageFactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LoginTest{
  WebDriver driver ;
  LoginPage page;
  String url;
  PropertyReader propertyReader;
  
	@Test
	public void login() throws InterruptedException {
		page.signIn("kamal.uniyal88@gmail.com","January12#");
	}
  
		@BeforeClass
		public void beforeClass() throws IOException {		
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
		
		propertyReader = new PropertyReader("D:/SeleniumProjects/SeleniumPrgs/src/PageFactory/congif.properties");
		url = propertyReader.getProperty("url");
		this.driver.get(url);
		page = new LoginPage(this.driver);
	}

	@AfterClass
		public void afterClass() {
		this.driver.quit();
	}

}
