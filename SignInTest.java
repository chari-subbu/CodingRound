package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

	

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		waitFor(2000);

		driver.findElement(By.linkText("Your trips")).click();
		waitFor(2000);
		driver.findElement(By.id("SignIn")).click();
		waitFor(2000);
		driver.switchTo().frame("modal_window");
		waitFor(1000);
		driver.findElement(By.id("signInButton")).click();
		waitFor(2000);
		String errors1 = driver.findElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		driver.quit();
	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	

}
