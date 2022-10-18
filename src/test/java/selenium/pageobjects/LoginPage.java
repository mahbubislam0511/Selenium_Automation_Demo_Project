package selenium.pageobjects;

import com.mislbd.testautomation.SeleniumFunctions;
import com.mislbd.testautomation.model.LoginModel;
import com.mislbd.testautomation.util.SingleExcelUtils;

import com.mislbd.testautomation.util.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by Mahbub Islam on 12-Oct-2022.
 */

public class LoginPage extends SeleniumFunctions {

    @FindBy(xpath = "//input[@id='inputEmail']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@id='inputPassword']")
    WebElement password;

    @FindBy(xpath = "//button[@id='login']")
    WebElement loginButton;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement reCAPTCHAFrame;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement checkBox;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAutomation() {

    	for(LoginModel myLoginModel:SingleExcelUtils.getLoginModels()) {
            this.emailAddress.sendKeys(myLoginModel.getEmailAddress());
            TestUtils.sleep(2000);
            this.password.sendKeys(myLoginModel.getPassword());

            waitForElement(reCAPTCHAFrame);
            driver.switchTo().frame(reCAPTCHAFrame);
            TestUtils.sleep(3000);
            waitForElement(checkBox);

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(checkBox));

            checkBox.click();
            TestUtils.sleep(9000);
            driver.switchTo().defaultContent();
            TestUtils.sleep(3000);
            loginButton.click();
        }
    }
}

