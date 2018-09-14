package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentClass {
	
	static WebDriver driver;
	
	void init(){
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();		
	}
	
	void launchUrl(String url){
		driver.get(url);
	}
	

}
