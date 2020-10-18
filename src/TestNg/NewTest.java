package TestNg;

import org.testng.annotations.Test;




import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



public class NewTest {
	WebDriver driver;
	
@Test
	public void f() throws InterruptedException {
	Boolean flag=false;
	String[] links=null;
	
	List<WebElement> values=driver.findElements(By.tagName("a"));
	System.out.println(values.size());
	links=new String[values.size()];
	
	//Storing all links in String array
	for(int i=0;i<values.size();i++) {
		links[i]=values.get(i).getText();
		}
	
	//Iterating through all the links
		for(int i=0;i<values.size();i++) {
		driver.findElement(By.linkText(links[i])).click();
		Thread.sleep(2000);
		try {
			//Xpath of "Under Construction"
		flag=driver.findElement(By.xpath("//html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font[1]/b/font[2]/b/font")).isDisplayed();
		}
		catch(NoSuchElementException e) {
			flag=false;
		}
		try {
			Assert.assertFalse(flag);
		}
		catch(AssertionError ee){
			System.out.println("Test error :-");
		}
		if(flag==true) {
			
			System.out.println(links[i]+" :- Under Construction");
		}
		else {
			
			System.out.println(links[i]+" :- Working");
		}
		}
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\AP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
		Thread.sleep(2000);
		
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  System.out.println("All Test done");
  }

}
