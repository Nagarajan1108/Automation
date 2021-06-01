package org.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DriverLaunch 
{
	public static void main(String[] args) throws Throwable 
	{
	System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.amazon.com/");
	
	WebElement signin = driver.findElement(By.xpath("//a[@class='a-button-text'][1]"));
	
	//signin.click();  //WebElement Click Operation
	//driver.manage().window().maximize();
	
	Actions a = new Actions(driver);
	a.click(signin).build().perform();	//Actions using click operation
	
	
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	
	
	}
}
