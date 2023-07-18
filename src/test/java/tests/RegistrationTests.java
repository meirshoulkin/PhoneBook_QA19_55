package tests;

import manager.ProviderData;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

//    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test(groups = {"sanityGroup", "regressionGroup"}, invocationCount = 3)
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc_" + i + "@def.com", password = "$Abcdef12345";
        // open login form
        app.getUser().openLoginRegistrationForm();
       // fill login form
        app.getUser().fillLoginRegistrationForm(email, password);
        // click on Registration button
        app.getUser().submitRegistration();
        // AsserAssert.assertTrue(wd.findElements(By.xpath("//a[@href='/add']")).size() > 0);
   }

    @Test(groups = {"sanityGroup", "regressionGroup"}, dataProvider = "userModelListDTO", dataProviderClass = ProviderData.class)
    public void registrationPositiveTestCSV(User user){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        // open login form
        app.getUser().openLoginRegistrationForm();
        // fill login form
        app.getUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        // click on Registration button
        app.getUser().submitRegistration();
        logger.info("Registration test starts witn data: " + user.getEmail() + " & " + user.getPassword());
       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
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

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

    }

}
