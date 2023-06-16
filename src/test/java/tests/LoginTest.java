package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

//    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest(){
        String email = "abc@def.com", password = "$Abcdef12345";
        // open login form
        app.getUser().openLoginRegistrationForm();
        // fill login form
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
//        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
        app.getUser().pause(3000);
//        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
   }

    @Test
    public void loginNegativeTestWrongEmail() {
        String email = "abcdef.com", password = "$Abcdef12345";
        // open login form
        app.getUser().openLoginRegistrationForm();
        // fill login form
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
    }

    @AfterMethod
    public void tearDown() {

    }

}

