package pageObject;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import utils.UserData;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    private SelenideElement loginField = $(byId("passp-field-login"));
    private SelenideElement passwordField = $(byId("passp-field-passwd"));
    private SelenideElement signInButton = $(byClassName("passp-sign-in-button"));
    private SelenideElement signUpButton = $(byClassName("passp-exp-register-button"));

    private static final String pageLink = "https://passport.yandex.ru/auth";

    public Boolean isAuthorizationPage() {
        return WebDriverRunner.url().startsWith(pageLink);
    }

    public MailPage signIn(UserData user) {

        loginField.sendKeys(user.getUsername());
        signInButton.hover().click();

        passwordField.sendKeys(user.getPassword());
        signInButton.hover().click();
        return new MailPage();
    }

    public RegistrationPage toRegisterForm() {
        signUpButton.hover().click();
        return new RegistrationPage();
    }


}
