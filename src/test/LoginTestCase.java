package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// step 1 : Launch Chrome Browser and Open the Simplilearn Website

		System.setProperty("webdriver.chrome.driver", "chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");

		// step 2 : Maximize the Browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// step 3 : Click on The Login Link On The Top Right Corner

		System.out.println("The Title of the Page Is " + driver.getTitle());

		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		String location = loginLink.getAttribute("href");
		System.out.println("The Link Will Take You To " + location);
		loginLink.click();

		// step 4 : Enter The User name

		WebElement userName = driver.findElement(By.name("user_login"));
		userName.sendKeys("Abc@xyz.com");

		// step 5 : Enter The Password

		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("Abc@123456");

		// step 6 Click on The Remember me checkbox

		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		RememberMe.click();

		// step 7 : Click On The Login Button

		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();

		// step 8 : Validate The Login Was UnSuccessful

		WebElement error = driver.findElement(By.className("error_msg"));
		String errormsg = error.getText();
		// System.out.println("The ErrorMsg is "+ errormsg);
		String expErrorMsg = "The email or password you have entered is invalid.";
		if (error.isDisplayed() && errormsg.equals(expErrorMsg)) {
			System.out.println("Tc is passed");

		} else {
			System.out.println("Tc is Failed");
		}
		
		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total No Of Links Are"+AllLinks.size());
		
		for(WebElement link :AllLinks) {
			System.out.println(link.getAttribute("href"));
		}
		
		
		// step 9 : Close The Browser
		
		driver.close();

	}

}
