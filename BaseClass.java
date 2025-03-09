package pageClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class BaseClass {
 
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected HomePage homePage;
	ReadProperties read=new ReadProperties();
	
	 @Parameters("browser")
	  @BeforeMethod(alwaysRun =true)
	  public void beforeClass(String browser) throws Throwable 
	  {
		 
		  if(browser.equals("chrome"))
		  {
			  driver=new ChromeDriver();
		  }
		  else if(browser.equals("firefox"))
		  {
			  driver=new FirefoxDriver();
		  }
		  else
		  {
			  driver=new ChromeDriver();
		  }
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
		  String url=read.fetchdata("url");
		  driver.get(url);
		  loginPage= new LoginPage(driver);
		  homePage=new HomePage(driver);
		  
	  }
	 
	 @AfterMethod(alwaysRun = true)
	  public void afterClass()
	  {
		  driver.quit();
	  }
}
