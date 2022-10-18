package selenium.pageobjects;

import com.mislbd.testautomation.util.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mislbd.testautomation.SeleniumFunctions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mahbub Islam on 12-Oct-2022.
 */

public class NavigateToLogInPage extends SeleniumFunctions{


	public NavigateToLogInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='jfHeader-menuListLink jfHeader-dynamicLink jfHeader-login-action']")
	WebElement clickLogInButton;
	
	public void navigateToLogInPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		waitForPageLoad();
		TestUtils.sleep(3000);
		waitForElement(clickLogInButton);
		clickLogInButton.click();
		switchWindow();
		waitForPageLoad();
	}

}
