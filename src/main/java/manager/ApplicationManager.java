package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperUser user;
    HelperAddNumber addNumber;

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new HelperUser(wd);
        addNumber = new HelperAddNumber(wd);
    }

    public void tearDown() {

        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperAddNumber getAddNumber() {
        return addNumber;
    }
}
