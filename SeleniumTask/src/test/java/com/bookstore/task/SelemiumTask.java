package com.bookstore.task;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class SelemiumTask {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\QQA0334\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://139.59.27.246:3000/");
	}
	@Test(priority=0)
	public void varifyingTheTittle() throws InterruptedException {
		String ActualUrl=driver.getCurrentUrl();
		String ExpectedUrl="http://139.59.27.246:3000/";
		Assert.assertEquals(ActualUrl, ExpectedUrl);
		Thread.sleep(5000);
	}

	@Test(priority=1)
	public void varifyTheBookStoreLogoDisplayingOrNot() throws InterruptedException {
		boolean logo=driver.findElement(By.xpath("//a[@href='/']")).isDisplayed();
		Assert.assertTrue(logo);
		Thread.sleep(5000);
	}
		@Test(priority=2)
		public void loginToTheBookStoreApp()throws InterruptedException  {
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.xpath("//input[@id='userNameOrEmail']")).sendKeys("prashantheskilla777@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("prashanth");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		}
		
		
	@Test(priority=3)
	public void addingBookToCart() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/a/img")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn-block btn btn-primary')]")).click();
		Thread.sleep(5000);
		
	}
}
