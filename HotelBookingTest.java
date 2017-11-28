package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

	WebDriver driver = null;
	@FindBy(linkText = "Hotels")
	WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;


	@Test
	public void shouldBeAbleToSearchForHotels() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		driver.get("https://www.cleartrip.com/");
		try {Thread.sleep(3000);} catch (InterruptedException e) {	e.printStackTrace();}
		hotelLink.click();
		try {Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
		localityTextBox.sendKeys("Indiranagar, Bangalore");

		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();
		try {Thread.sleep(4000);} catch (InterruptedException e) {	e.printStackTrace();}
		driver.quit();

	}

}
