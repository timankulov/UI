package pageObject;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import utils.UserData;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class RegistrationPage {

    private SelenideElement nameField = $(byId("firstname"));
    private SelenideElement lastNameField = $(byId("lastname"));
    private SelenideElement loginField = $(byId("login"));
    private SelenideElement passwordField = $(byId("password"));
    private SelenideElement passwordConfirmField = $(byId("password_confirm"));
    private SelenideElement phoneField = $(byId("phone"));

    private SelenideElement signUpConfirmButton = $(byClassName("form__submit"));
    private SelenideElement purseCreateButton = $(byId("money_eula_accepted"));

    private static final String pageLink = "https://passport.yandex.ru/registration";

    public Boolean isRegistrationPage() {
        return WebDriverRunner.url().startsWith(pageLink);
    }

    public MailPage signUp(String name, String lastName, String login, String password, String phoneNumber, UserData forUser) {

        nameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordConfirmField.sendKeys(password);
        phoneField.sendKeys(phoneNumber);

        purseCreateButton.hover().click();
        signUpConfirmButton.hover().click();

        forUser.setUsername(login);
        forUser.setPassword(password);

        return new MailPage();
    }


}
