//package manager;
//
//import model.AddNumber;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class HelperAddNumber extends HelperBase{
//
//    public HelperAddNumber(WebDriver wd) {
//        super(wd);
//    }
//
//    public void openAddNumberForm(){
//      //  pause(5000);
//        click(By.xpath("//a[normalize-space()='ADD']"));
//    }
//
//    public boolean isAddNumberFormPresent(){
//     return    new WebDriverWait(wd,10)
//                .until(ExpectedConditions
//                        .textToBePresentInElement(
//                                wd.findElement(By.cssSelector("div[class='add_form__2rsm2'] button b")),"Save"
//                        ));
//    }
//
//    public void fillAddNumberForm(AddNumber addNumber){
//        if(isAddNumberFormPresent()==false) return;
//        type(By.cssSelector("input[placeholder='Name']"),addNumber.getName());
//        type(By.cssSelector("input[placeholder='Last Name']"),addNumber.getLastName());
//        type(By.cssSelector("input[placeholder='Phone']"),addNumber.getPhone());
//        type(By.cssSelector("input[placeholder='email']"),addNumber.getEmail());
//        type(By.cssSelector("input[placeholder='Address']"),addNumber.getAddress());
//        type(By.cssSelector("input[placeholder='Address']"),addNumber.getDescription());
//    }
//
////    public void select(By locator, String option){
////        new Select(wd.findElement(locator)).selectByValue(option);
////    }
//}
