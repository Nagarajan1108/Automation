package org.Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Frames 
{
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		int i = frame.size();
		System.out.println(i);
		
		
			
		
		driver.switchTo().frame("a077aa5e");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement image = driver.findElement(By.xpath("(//img[contains(@src,'Jmeter')])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", image);
		
		Thread.sleep(2000);
		
		image.click();
		
		

		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		WebElement text = driver.findElement(By.xpath("//h3[text()=' Project Summary']"));
		String str=text.getText();
		System.out.println(str);
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		WebElement text1 = driver.findElement(By.xpath("//font[text()='THIS IS A DEMO PAGE FOR TESTING'] "));
		String str1=text1.getText();
		System.out.println(str1);
	 
		
		
		//frame inside frame
		
		/*driver.switchTo().frame(1);
		driver.switchTo().frame(2);
		driver.switchTo().frame(3);
		WebElement image1 = driver.findElement(By.xpath("(//img[contains(@src,'Jmeter')])[1]"));
		image1.getText();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();  // --- main page 
*/		
	}
}
