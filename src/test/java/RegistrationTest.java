import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(isLogged()){
            logout();
        }
    }

    @Test
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        // open login form
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        // fill login form
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("abc_"+i + "@def.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("$Abcdef12345");
        // click on Login button
        wd.findElement(By.xpath("//button[2]")).click();
        // Thread.sleep(5000);
        // Assert
        Assert.assertTrue(wd.findElements(By.xpath("//a[@href='/add']")).size() > 0);


    }

    @Test
    public void registrationNegativeWrongEmailTest(){
        String email = "abcdef.com", password = "$Abcdef12345";
        // open login form
        openLoginRegistrationForm();
        // fill login form
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        // Assert
    }


    @Test
    public void registrationNegativeWrongPasswordTest(){
        String email = "abc@def.com", password = "$Abcdef13457";
        // open login form
        openLoginRegistrationForm();
        // fill login form
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        // Assert
    }

    @AfterMethod
    public void tearDown(){

    }

}
