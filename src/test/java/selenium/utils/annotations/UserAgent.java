package selenium.utils.annotations;


import com.mislbd.testautomation.driver.UserAgents;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface UserAgent {
    UserAgents value();
}
