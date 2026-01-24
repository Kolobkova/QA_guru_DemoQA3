
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfullFillFormTest() {

        registrationPage.openPage()
                .setFirstName("Tania")
                .setLastName("Kolobkova")
                .setEmail("Tania@ya.ru")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setDateOfBirth("28", "September", "1980")
                .setSubject("Maths")
                .setHobby("Sports")
                .setPicture("picture.jpg")
                .setAddress("Moscow")
                .setStateDropdown()
                .setStateCityWrapper("NCR")
                .setCityDropdown()
                .setStateCityWrapper("Delhi")
                .setSubmit();


        registrationPage.checkResult("Student Name", "Tania Kolobkova")
                .checkResult("Student Email", "Tania@ya.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "28 September,1980")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "NCR Delhi");
    }


    @Test
    void requiredFillFormTest() {

        registrationPage.openPage()
                .setFirstName("Tania")
                .setLastName("Kolobkova")
                .setEmail("Tania@ya.ru")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setHobby("Sports")
                .setSubmit();


        registrationPage.checkResult("Student Name", "Tania Kolobkova")
                .checkResult("Student Email", "Tania@ya.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Hobbies", "Sports");
    }

    @Test
    void negativeTest() {

        registrationPage.openPage()


                .setLastName("Kolobkova")
                .setEmail("Tania@ya.ru")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setHobby("Sports")
                .setSubmit()
                .getModalDialog();


    }
}
