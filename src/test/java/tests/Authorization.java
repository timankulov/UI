package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import pageObject.MailPage;
import utils.UserData;

import static org.testng.Assert.assertTrue;

public class Authorization extends BaseTest {

    @Test(description = "Авторизация")
    public void authorization() {

        UserData user = new UserData();
        MailPage mailPage = mainPage.toMailAuth().toRegisterForm().signUp("Петр", "Петров", "petrov", "123456", "89431234567", user);

        mailPage.logout();

        Selenide.clearBrowserCookies();
        Selenide.refresh();

        assertTrue(mainPage.toMailAuth().signIn(user).isMailPage(), "Не авторизовались");
    }
}
