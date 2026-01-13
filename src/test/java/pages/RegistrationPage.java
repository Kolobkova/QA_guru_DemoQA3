package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResponsive;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityDropdown = $("#city"),
            submit = $("#submit"),
            modalDialog = $(".modal-dialog");


    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponsive tableResponsive = new TableResponsive();

    public RegistrationPage openPage() {
        //Открытие браузера
        open("/automation-practice-form");
        return this;
    }



    public RegistrationPage removeBanners() {
       executeJavaScript("$('#fixedban').remove();");
       executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }


    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateDropdown() {
        stateDropdown.click();

        return this;
    }

    public RegistrationPage setStateCityWrapper(String value) {
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCityDropdown() {
        cityDropdown.click();

        return this;
    }


    public RegistrationPage setSubmit() {
        submit.click();
        return this;
    }


    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.setTableResponsiveData(key, value);

        return this;
    }

    public RegistrationPage getModalDialog() {
        modalDialog.shouldNotBe(visible);

        return this;
    }


}

