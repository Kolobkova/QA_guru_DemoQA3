
import org.junit.jupiter.api.Test;
import pages.TextBoxCasePage;


public class TextBoxCasePO extends TestBase {

    TextBoxCasePage textBoxCasePage = new TextBoxCasePage();

    @Test
    void  fillFormTest() {
        textBoxCasePage.openTextPage()
                .removeBanner()
                .setUserName("Tanya")
                .setUserEmail("Tanya@ya.ru")
                .setCurrentAddress("Steet1")
                .setPermanentAddress("Street2")
                .setSubmit();

        textBoxCasePage
                .checkResult("Name:", "Tanya")
                .checkResult("Email:", "Tanya@ya.ru")
                .checkResult("Current Address :", "Steet1")
                .checkResult("Permananet Address :", "Street2");

    }

}
