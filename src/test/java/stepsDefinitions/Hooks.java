package stepsDefinitions;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Utils;

public class Hooks {
	
	public static AppiumDriver<WebElement> driver;
	
	@Before
	public void acessarAplicativo() throws Exception{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.android.vending");
		desiredCapabilities.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");

		driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@After
	public void fecharDriver(Scenario cenario) {
		Utils.gerarScreenshot(cenario);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.quit();
	}
	
	public static AppiumDriver<WebElement> getDriver() {
		return driver;
	}

}
