package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

//    @Test
//    public void registrationPositiveTest(){
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        // open login form
//        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc_" + i + "@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//        // click on Registration button
//        wd.findElement(By.xpath("//button[2]")).click();
//
//        // Assert
//        Assert.assertTrue(wd.findElements(By.xpath("//a[@href='/add']")).size() > 0);
//    }

    @Test
    public void registrationNegativeTestWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc_" + i + "def.com", password = "$Abcdef12345";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
    }

    @AfterMethod
    public void tearDown(){

    }

}
