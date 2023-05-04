package com.bookstore.task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class signUpTest {
	
@Test
	public void RegisteringToBookstoreApp() {
		
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QQA0334\\Downloads\\chromedriver_win32.exe");
		driver.get("http://139.59.27.246:3000/");
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.xpath("//a[@href='/register?redirect=/']")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("prashanthesk");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("prashanth");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prashantheskilla7777@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("prashanth");
		driver.findElement(By.xpath("//body/div/main//div[5]/input")).sendKeys("prashanth");
		driver.findElement(By.xpath("//button[@type='submit']")).sendKeys("prashanth");

	}

}
