package pages;

import com.codeborne.selenide.SelenideElement;
import pages.utils.JsSnippets;
import pages.components.OutputTextBox;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxCasePage {

    private SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit");

    OutputTextBox outputTextBox = new OutputTextBox();
    JsSnippets jsSnippets = new JsSnippets();

    public TextBoxCasePage openTextPage() {
        open("/text-box");
        return this;
    }

    public TextBoxCasePage removeBanner() {

        jsSnippets.setRemoveBanners();
        return this;
    }

    public TextBoxCasePage setUserName(String value) {

        userNameInput.setValue(value);
        return this;
    }

    public TextBoxCasePage setUserEmail(String value) {

        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxCasePage setCurrentAddress(String value) {

        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxCasePage setPermanentAddress(String value) {

        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxCasePage setSubmit() {
        submit.click();
        return this;
    }

    public TextBoxCasePage checkResult(String key, String value) {
        outputTextBox.setOutputData(key, value);

        return this;
    }

}
