package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

//    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositiveTest(){
        //int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc@def.com", password = "$Abcdef12345";
        // open login form
        app.getUser().openLoginRegistrationForm();
       // fill login form
        app.getUser().fillLoginRegistrationForm(email, password);
        // click on Registration button
        app.getUser().submitRegistration();
        // AsserAssert.assertTrue(wd.findElements(By.xpath("//a[@href='/add']")).size() > 0);
   }

    @Test
    public void registrationNegativeTestWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc_" + i + "def.com", password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isErrorMessageFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @AfterMethod
    public void tearDown(){

    }

}
