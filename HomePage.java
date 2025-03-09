package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	ReadProperties read=new ReadProperties();
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addProduct(String product) {
		WebElement addProd = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[@class='inventory_item']//button[contains(@class, 'btn_inventory')]"));
		addProd.click();
	}
	
	public void getProductDetails(String product)
	{
		WebElement prodDetails = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[@class='inventory_item']//div[@class= 'inventory_item_desc']"));
		String productDetails = prodDetails.getText();
		System.out.println("Product Details:"+productDetails);
	}
	
	public void getPrice(String product)
	{
		WebElement prodDetails = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']"));
		String productDetails = prodDetails.getText();
		System.out.println("Product Details:"+productDetails);
	}
	
	public void clickCartBtn()
	{
		WebElement cartBtn = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a"));
		cartBtn.click();
	}
	
	public void removeProduct(String product)
	{
		WebElement removeProd = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[@class='cart_item_label']//button[contains(text(), 'Remove')]"));
		removeProd.click();
	}
	
	public void clickCheckout()
	{
		WebElement checkOutBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
		checkOutBtn.click();
	}
	
	public void enterFirtname(String firstname)
	{
		WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
		firstName.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname)
	{
		WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));
		lastName.sendKeys(lastname);
	}
	
	public void enterZipcode(String zipcode)
	{
		WebElement zipCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
		zipCode.sendKeys(zipcode);
	}
	
	public void clickCont()
	{
		WebElement contBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		contBtn.click();
	}
	
	public void clickFinish()
	{
		WebElement finishBtn = driver.findElement(By.xpath("//button[@id='finish']"));
		finishBtn.click();
	}
	
	public void addDeleteProd() throws Throwable
	{
		String product1 = read.fetchdata("product1");
		String product2 = read.fetchdata("product2");
		String product3 = read.fetchdata("product3");
		String product4 = read.fetchdata("product4");
		addProduct(product1);
		addProduct(product2);
		addProduct(product3);
		getProductDetails(product4);
		getPrice(product2);
		clickCartBtn();
		Thread.sleep(2000);
		removeProduct(product2);
		Thread.sleep(2000);
		clickCheckout();
	}

	public void checkoutProcess() throws Throwable
	{
		String first_Name = read.fetchdata("firstname");
		String last_Name = read.fetchdata("lastname");
		String zip_code = read.fetchdata("zipcode");
		enterFirtname(first_Name);
		enterLastname(last_Name);
		enterZipcode(zip_code);
		clickCont();
		clickFinish();
		
	}
	
	

}
