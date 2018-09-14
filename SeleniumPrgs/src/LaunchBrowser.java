import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		LaunchBrowser obj = new LaunchBrowser();	
		obj.launchBrowser();
	}
	
	void launchBrowser() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://intranet.mgmt.local/D/PTC1/TAFTestPage");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.close();	
		//driver.navigate().refresh();
	}
	
}

