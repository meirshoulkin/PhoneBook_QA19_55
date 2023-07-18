package tests;

import manager.NgListener;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgListener.class)
public class LoginTest extends TestBase{

//    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

//    @Test
//    public void loginPositiveTest(){
//        String email = "abc@def.com", password = "$Abcdef12345";
//        // open login form
//        app.getUser().openLoginRegistrationForm();
//        // fill login form
//        app.getUser().fillLoginRegistrationForm(email, password);
//        app.getUser().submitLogin();
//    //    Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
//        app.getUser().pause(3000);
//  //      Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
//   }
   @Test(groups = {"smokeGroup","sanityGroup", "regressionGroup"})
    public void loginPositiveTestUser(){
        String email = "abc@def.com", password = "$Abcdef12345";
        User user = new User()
                .withEmail(email)
                .withPassword(password)
                ;
        //User user = new User().withEmail("abc@def.com").withPassword("$Abcdef12345");
        // open login form
        app.getUser().openLoginRegistrationForm();
        // fill login form
       // app.getUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLogged());
     //  Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
   }
    @Test(groups = {"smokeGroup", "sanityGroup", "regressionGroup"})
    public void loginPositiveTestUserProp(){
       // String email = "abcdef.com", password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        app.getUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

    }

}

