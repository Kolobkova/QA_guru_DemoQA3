import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void browserSettings() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;

    }

    @Test

    void fillFormTest() {

        open("/automation-practice-form");
        //удалить баннеры
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Tania");
        $("#lastName").setValue("Kolobkova");
        $("#userEmail").setValue("Tania@ya.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__year-select").$(byText("1980")).click();
        $(".react-datepicker__month").$(byText("28")).click();
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        $("#currentAddress").setValue("Moscow, ul. Marksa,38-51");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Tania Kolobkova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Tania@ya.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("28 September,1980"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("picture.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Moscow, ul. Marksa,38-51"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

    }


}
