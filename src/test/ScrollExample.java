package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.setProperty("webdriver.chrome.driver", "chromedriver_linux64/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement scrollTo = driver.findElement(By.xpath("//h2[text()='HTML Exercise']"));
		JavascriptExecutor obj=(JavascriptExecutor)driver;
		obj.executeScript("arguments[0].scrollIntoView():",scrollTo);
		
		//scrollUp
		
		//obj.executeScript("window.scrollTo():",scroll
		

	}

}
