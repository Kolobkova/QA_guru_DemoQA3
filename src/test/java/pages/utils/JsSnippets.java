package pages.utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippets {

    public static void setRemoveBanners() {

        executeJavaScript("$('#fixedban').remove();");
        executeJavaScript("$('footer').remove()");

    }
}
