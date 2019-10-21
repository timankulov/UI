package tests;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageObject.MainPage;
import utils.Drivers;
import utils.URL;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected MainPage mainPage = new MainPage();

    @BeforeSuite
    public void setUp() {
        WebDriver driver = Drivers.getWebDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

        open(URL.getBaseUrl());
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
