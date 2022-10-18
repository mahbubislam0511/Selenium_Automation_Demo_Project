package selenium.testcases;

import com.mislbd.testautomation.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.*;

/**
 * Created by Mahbub Islam on 12-Oct-2022.
 */


public class DemoLoginPage extends SeleniumTestWrapper {

    StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
    NavigateToLogInPage navigateToLogInPage = PageFactory.initElements(getDriver(), NavigateToLogInPage.class);
    LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);


    @Before
    public void setup() {
        startPage.open();
    }

    private void doNavigateToLoginPage() {
        navigateToLogInPage.navigateToLogInPage();
    }

    private void doLogin() throws Exception {
        loginPage.loginAutomation();
    }


    @Test
    public void demoLoginPage() {

        try {
            doNavigateToLoginPage();
            TestUtils.sleep(3000);
            doLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}