package com.test.scenarios;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.reusable.methods.Objects;
public class TestCasesForBookStoreWebPage {
	WebDriver driver;
	 public String baseURI;
	 public String chroPath;
	Objects obj;
	@BeforeMethod
	public void setUp() throws InterruptedException{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\QQA0334\\eclipse-workspace\\SeleniumTask\\config.properties"));
			Properties properties = new Properties();
			try {
				properties.load(reader);
				baseURI=properties.getProperty("base_url");
				chroPath=properties.getProperty("Chro_path");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " +"C:\\Users\\QQA0334\\eclipse-workspace\\SeleniumTask\\config.properties");
		}		
	
     
		driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",chroPath);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseURI);
		obj=new Objects(driver);
		obj.loginTestMethod();

	}

	@Test(priority=1)
	public void varyfyingLogoAndUrlTest() throws InterruptedException {
		obj=new Objects(driver);
		obj.varyinglogoAndUrl();
		driver.close();
	}

	@Test(priority=2)
	public void selectingJavaBookAndAddingToTheCartTest() throws InterruptedException {
		obj=new Objects(driver);
		obj.selectingJavaBookAndAddingToTheCart();
		Thread.sleep(5000);
		driver.close();

	}
	@Test(priority=3)
	public void selectingTimeMechineBookAndGivingRatingAndReviewTest() throws InterruptedException {
		obj=new Objects(driver);
		obj.writingTheCommentMethod();
		Thread.sleep(5000);
		driver.close();
	}
	@Test(priority=4)
	public void checkingCartItemAndAddingAddressToCheckOutTest() throws InterruptedException {
		obj=new Objects(driver);
		obj.checkingCartItemsAddingAddressMethod();
		Thread.sleep(5000);
		driver.close();
	}
}

