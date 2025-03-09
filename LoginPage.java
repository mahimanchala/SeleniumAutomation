package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	ReadProperties read=new ReadProperties();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void userLogin() throws Throwable
	{
		String username=read.fetchdata("username");
		String password=read.fetchdata("password");
		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		userName.sendKeys(username);
		WebElement passWord = driver.findElement(By.xpath("//input[@id='password']"));
		passWord.sendKeys(password);
		WebElement loginBtn= driver.findElement(By.xpath("//input[@id='login-button']"));
		loginBtn.click();
	}

}
