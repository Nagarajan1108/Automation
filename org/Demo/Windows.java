package org.Demo;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows 
{
	public static void main(String[] args) throws AWTException, InterruptedException, FileNotFoundException 
	{
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();       //Driver Launch
		
		driver.get(" https://www.flipkart.com/");
		driver.manage().window().maximize();        // Open Website
		
		try {										//Remove Subwindow	
			WebElement close = driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]"));
			close.click();
			System.out.println("Successfully closed");
		}
		catch (Exception e)
		{
			System.out.println("Directly opened");
			
		}
		
		WebElement search = driver.findElement(By.name("q"));		//Search Option WebElement
		search.sendKeys("Redmi");									//Search Redmi in Search Option
		Thread.sleep(3000);
		
		search.sendKeys(Keys.ENTER);								//Press Enter key to find Result
		Thread.sleep(3000);
		
		WebElement text=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]"));
		
		
		String str = text.getText();								//To get selected mobile name
		System.out.println("Your Mobile is : " +str);
		
		FileOutputStream output = new FileOutputStream(".//TestData//mobiles.xls");
		
		
		List<WebElement> overall=driver.findElements(By.xpath("//div[contains(text(),'GB')]"));
		for(WebElement webElement :overall)
		{
			String r = webElement.getText();
			System.out.println(r);
		}
		
		
		
		
		Thread.sleep(3000);
		text.click();												//To click the mobile name to change the window.
		
	    String MainWindow=driver.getWindowHandle();
	    System.out.println("Main Window is "+MainWindow);			//Main Window Result
	    
		Set<String> ChildWindow=driver.getWindowHandles();
		for (String x : ChildWindow)
		{
	    System.out.println("Child Window is "+x);
		
	    if(!MainWindow.equals(x))									//Check Main Window and child Window equal are not if not equal print child window
		{
			driver.switchTo().window(x);							//using SwitchTo Change mainwindow to child window
			WebElement cart=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
			Thread.sleep(1500);
			cart.click();											//Click Add to Cart						
		}	
		}
	}
}
