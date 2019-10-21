package tests;

import org.testng.annotations.Test;
import pageObject.MailPage;
import utils.UserData;

import static org.testng.Assert.assertTrue;

public class Registration extends BaseTest {

    @Test(description = "Регистрация")
    public void registration() {

        UserData user = new UserData();
        MailPage mailPage = mainPage.toMailAuth().toRegisterForm().signUp("Петр", "Петров", "petrov", "123456", "89431234567", user);

        assertTrue(mailPage.isMailPage(), "Не удалось зарегистрироваться");

    }
}
