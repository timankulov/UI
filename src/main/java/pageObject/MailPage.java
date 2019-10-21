package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MailPage {

    private static final String pageLink = "https://mail.yandex.ru";

    public Boolean isMailPage() {
        return WebDriverRunner.url().startsWith(pageLink);
    }

    public AuthorizationPage logout() {
        $(byClassName("mail-User-Name")).hover().click();
        ElementsCollection elements = $(byClassName("b-user-dropdown-content")).$$(byClassName("b-mail-dropdown__item__content"));
        elements.get(elements.size() - 2).hover().click();
        return new AuthorizationPage();
    }
}
