package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OutputTextBox {

    private SelenideElement
            setOutput = $("#output");

    public void setOutputData(String key, String value) {
        setOutput.$(byText(key)).parent().shouldHave(text(value));
    }
}
