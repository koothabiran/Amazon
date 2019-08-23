package bi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest {
	
	 public static WebDriver driver;
	 static String URL ="https://www.flipkart.com/";
	
  @Test(priority=1)
  
	    public void launchBroswer() throws InterruptedException
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Koothabiran\\eclipse-workspace\\Amazon\\geckodriver.exe");
			//driver = new ChromeDriver();
		 driver = new FirefoxDriver(); 
			driver.manage().window().maximize(); 
			Thread.sleep(5000);
			driver.get(URL);
			Thread.sleep(5000);
		
	 
  }
  
  @Test(priority=2)
  public void login() throws InterruptedException
	{
	  //Enter username
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("8668030889");
	  Thread.sleep(4000);
	  
	  //Enter Password
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("thulasi");
	  Thread.sleep(2000);

	  //click on login
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
	  Thread.sleep(2000);
  
}
  
  @Test(priority=3)
  public void search() throws InterruptedException
	{
	  try {
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/span[1]")).click();
	  Thread.sleep(2000);
  
	  //click on mi
	  driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a")).click();
	  Thread.sleep(2000);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();

	  }
	 
	 
	  
	  
	  
	  //search for kids cycle
	  driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")).sendKeys("kids cycle");
	  Thread.sleep(2000);
	  
	  //click on search button
	  driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
	  Thread.sleep(3000);
	  
	  
	  JavascriptExecutor jse = (JavascriptExecutor) driver;
	  jse.executeScript("window.scrollBy(1156, 694)", "");
  
}
  @Test(priority=4)
  public void logout() throws InterruptedException
	{
	// mouseHover	  
	  WebElement dropdown= driver.findElement(By.xpath("//*[@id=\'container\']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div"));
	  Actions act = new Actions(driver);
	  act.moveToElement(dropdown).perform();
	  Thread.sleep(5000);

	  
	  // finding the invisible elemenet. logout button
	  driver.findElement(By.partialLinkText("Logout")).click();
  
  }
  }