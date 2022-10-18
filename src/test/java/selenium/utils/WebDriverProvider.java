package selenium.utils;

import com.mislbd.testautomation.driver.UserAgents;
import com.mislbd.testautomation.driver.WebDriverBuilder;
import com.mislbd.testautomation.driver.WebDriverConfig;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider extends TestWatcher {
    private final WebDriverBuilder webDriverBuilder;
    private WebDriver driver;

    public WebDriverProvider(WebDriverConfig webDriverConfig) {
        this.webDriverBuilder = new WebDriverBuilder(webDriverConfig);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = webDriverBuilder.toWebDriver();
        }
        return driver;
    }

    public void useUserAgent(UserAgents userAgent) {
        webDriverBuilder.userAgent(userAgent);
    }

    public void disableCookies(boolean cookies) {
        webDriverBuilder.disableCookies(cookies);
    }

    public boolean existsDriver() {
        return driver != null;
    }

    @Override
    protected void starting(final Description description) {
        String methodName = description.getClassName() + "." + description.getMethodName();
        this.webDriverBuilder.setName(methodName);
    }

    @Override
    protected void finished(final Description description) {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
