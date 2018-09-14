package SeleniumTests;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class IntraNetLogin extends ParentClass {
	ParentClass test;
	
	@DataProvider
	public Object[][] data(){
		return new Object[][]{{"kamal.uniyal","Wednesday@123"}};
	}

	@BeforeClass
	void initiliaze(){
		this.test = new ParentClass();
	}
	
  @Test
  @Parameters({"ID","Password"})
  public void ParameterTest(String ID,String Password) throws InterruptedException {
	  this.test.init();
	  this.test.launchUrl("https://intranet.mgmt.local/D/PTC1/login?redir=/D/PTC1/");
	  driver.findElement(By.name("userid")).clear();
	  Thread.sleep(500);
	  driver.findElement(By.name("userid")).sendKeys(ID);
	  Thread.sleep(500);	  
	  driver.findElement(By.name("password")).clear();
	  Thread.sleep(500);
	  driver.findElement(By.name("password")).sendKeys(Password);
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	 
  }
  
  @Test(dataProvider="data")
  public void DataProviderTest1(String ID,String Password) throws InterruptedException{
	  this.test.init();
	  this.test.launchUrl("https://intranet.mgmt.local/D/PTC1/login?redir=/D/PTC1/");
	  driver.findElement(By.name("userid")).clear();
	  Thread.sleep(500);
	  driver.findElement(By.name("userid")).sendKeys(ID);
	  Thread.sleep(500);	  
	  driver.findElement(By.name("password")).clear();
	  Thread.sleep(500);
	  driver.findElement(By.name("password")).sendKeys(Password);
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
  }
  
  
  @Test
  public void GmailLogin(){
  
  }
  
  @AfterClass
  void teardown(){
	  driver.quit();
  }
     
 
}
