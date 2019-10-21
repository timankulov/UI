package pageObject;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class MainPage {

    private static final String pageLink = "https://yandex.ru";

    public Boolean isMainPage() {
        return WebDriverRunner.url().startsWith(pageLink);
    }
    private SelenideElement toMailAuth = $(byClassName("desk-notif-card__card")).$(byText("Войти в почту")).parent();

    public AuthorizationPage toMailAuth() {
        toMailAuth.hover().click();
        return new AuthorizationPage();
    }
}
