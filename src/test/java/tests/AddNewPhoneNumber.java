//package tests;
//
//import models.AddNumber;
//import models.User;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class AddNewPhoneNumber extends TestBase{
//
//    // isLogged
//    // open form
//    // fill form
//    // Submit phoneNumber
//
//    @BeforeMethod
//    public void precondition(){
//        if(app.getUser().isLogged()==false){
//            app.getUser()
//                    .login(new User()
//                            .withEmail("abc@def.com")
//                            .withPassword("$Abcdef12345"));
//        }
//    }
//    @Test
//    public void addNewPhoneNumberPositive(){
//       // int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        AddNumber addNumber = AddNumber.builder()
//                .name("John")
//                .lastName("Doel")
//                .phone("972502352258")
//                .email("affairs88@gmail.com")
//                .address("Safed")
//                .description("Beautiful")
//                .build();
//        app.getAddNumber().openAddNumberForm();
//        app.getAddNumber().fillAddNumberForm(addNumber);
//       // app.getAddNumber().
//    }
//}
