package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EbayProdSearchTest {
  @Test
  public void prodSearch()
  {
	  	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ebay.com");

		driver.findElement(By.id("gh-ac")).sendKeys("Sony");
		driver.findElement(By.id("gh-btn")).click();

		Reporter.log("Ebay Product Search Test is Successful...",true);
  }
}
