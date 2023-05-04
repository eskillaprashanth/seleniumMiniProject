package com.reusable.methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static com.contants.Constants.USER_NAME;
import static com.contants.Constants.PASSWORD;
import static com.contants.Constants.STATE;
import static com.contants.Constants.LANE1;
import static com.contants.Constants.LANE2;
import static com.contants.Constants.CITY;
public class Objects {
	WebDriver driver;
	public Objects(WebDriver driver) {
		this.driver=driver;
	}//constructor
	By varyfying_logo=By.xpath("//a[@href='/']");
	By signIn_button=By.xpath("//a[@href='/login']");
	By userName_textBox=By.xpath("//input[@id='userNameOrEmail']");
	By password_textBox=By.xpath("//input[@id='password']");
	By submit_button=By.xpath("//button[@type='submit']");
	By selecting_java_book=By.xpath("(//img[@class='card-img-top'])[3]");
	By selecting_TimeMechine_book=By.xpath("(//img[@class='card-img-top'])[2]");
	By clicking_addToCart=By.xpath("//button[contains(@class,'btn-block btn btn-primary')]");
	By clicking_addMoreBooks=By.xpath("//a[@class='active']");
	By clicking_rating_space=By.xpath("//select[@id='rating']");
	By clicking_review_space=By.xpath("//textarea[@id='reviewMessage']");
	By submitting_review=By.xpath("//button[@type='submit']");
	By clicking_cart=By.xpath("//a[@href='/cart']");
	By proceed_to_checkout=By.xpath("//button[@class='btn-block btn btn-primary']");
	By lane1=By.xpath("//input[@id='addressLine1']");
	By lane2=By.xpath("//input[@id='addressLine2']");
	By city=By.xpath("//input[@id='city']");
	By state=By.xpath("//input[@id='state']");
	By postalcode=By.xpath("//input[@id='postalCode']");
	By phone_number=By.xpath("//input[@id='phone']");
	By Address_submittbutton=By.xpath("//button[@class='btn btn-primary']");
	By country_dropDown=By.xpath("//select[@class='form-control']");
	By text_assertion=By.tagName("h4");


	public void varyinglogoAndUrl() throws InterruptedException {
		boolean logo=driver.findElement(varyfying_logo).isDisplayed();
		Assert.assertTrue(logo);
		String ActualUrl=driver.getCurrentUrl();
		String ExpectedUrl="http://139.59.27.246:3000/login";
		Assert.assertEquals(ActualUrl, ExpectedUrl);
		Thread.sleep(5000);
		

	}

	public void loginTestMethod() throws InterruptedException {
		driver.findElement(signIn_button).click();
		driver.findElement(userName_textBox).sendKeys(USER_NAME);
		driver.findElement(password_textBox).sendKeys(PASSWORD);
		driver.findElement(submit_button).click();
		
	}
	public void selectingJavaBookAndAddingToTheCart() throws InterruptedException {
		driver.findElement(selecting_java_book).click();
		Thread.sleep(5000);
		driver.findElement(clicking_addToCart).click();
		  String text = driver.findElement(text_assertion).getText();
	        String requiredText = "Programming with Java";
	        Assert.assertEquals
	(text, requiredText, "Actual and Expected Texts are different");
	    

	}
	public void writingTheCommentMethod() throws InterruptedException {
		driver.findElement(selecting_TimeMechine_book).click();
		Thread.sleep(5000);
		driver.findElement(clicking_rating_space).click();
		WebElement ddown=driver.findElement(clicking_rating_space);
		Select select=new Select(ddown);
		select.selectByVisibleText("3 - Good");
		Thread.sleep(5000);
		driver.findElement(clicking_review_space).sendKeys("very good book to gain knowledge");
		driver.findElement(submitting_review).click();



	}
	public void checkingCartItemsAddingAddressMethod() throws InterruptedException {
		driver.findElement(clicking_cart).click();
		driver.findElement(proceed_to_checkout).click();
		driver.findElement(lane1).sendKeys(LANE1);
		driver.findElement(lane2).sendKeys(LANE2);
		driver.findElement(city).sendKeys(CITY);
		driver.findElement(state).sendKeys(STATE);
		driver.findElement(country_dropDown).click();
		WebElement ddwn=driver.findElement(country_dropDown);
		Select select=new Select(ddwn);
		select.selectByVisibleText("India");
		driver.findElement(postalcode).sendKeys("464554");
		driver.findElement(phone_number).sendKeys("66676473637");
		driver.findElement(Address_submittbutton).click();

	}

}
