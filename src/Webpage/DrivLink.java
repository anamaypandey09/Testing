package Webpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DrivLink {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// This line is to open a new instance of chrome driver
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		
//Opening the Webpage and logging in
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("sunil");
		driver.findElement(By.name("password")).sendKeys("sunil");
		driver.findElement(By.name("submit")).click();
		
//Getting links
		Thread.sleep(4000);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++) {
			String values=links.get(i).getText();
			System.out.println(values);
			
			
		}
		

		}

	

}
