package utils;

import com.codeborne.selenide.Browsers;
import io.qameta.allure.Step;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Drivers {

    private static WebDriver driver = null;
    private static String browserName = "";

    @Step("Создаем драйвер браузера {pBrowserName}")
    public static WebDriver getWebDriver(String pBrowserName) {

        String driverName = pBrowserName.toLowerCase().equals("firefox")?"gecko":pBrowserName.toLowerCase();
        System.setProperty("webdriver." + driverName + ".driver",
                "lib/".concat(Platform.getCurrent().name().substring(0, 3))
                        .concat("/")
                        .concat(driverName)
                        .concat("driver")
                        .concat(Platform.WIN10.name().substring(0,3).equalsIgnoreCase(Platform.getCurrent().name().substring(0,3))?".exe":""));

        switch (pBrowserName){
            case Browsers.CHROME:
                ChromeOptions opt = new ChromeOptions();
                driver = new ChromeDriver(opt);
                System.out.println("Создаю ChromeDriver.");
                break;
            case Browsers.EDGE:
                driver = new EdgeDriver();
                System.out.println("Создаю EdgeDriver.");
                break;
            case Browsers.FIREFOX:
                driver = new FirefoxDriver();
                System.out.println("Создаю FirefoxDriver");
                break;
            case Browsers.OPERA:
                driver = new OperaDriver();
                System.out.println("Создаю OperaDriver");
                break;
            default:
                driver = new ChromeDriver();
                System.out.println("Создаю ChromeDriver default");
                break;
            }

        browserName = pBrowserName;
        return driver;
    }

    /**
     * Возвращаем текущий драйвер. Если драйвер не был создан, то создаем драйвер chrome
     * @return
     */
    public static WebDriver getWebDriver() {
        return driver != null ? driver : getWebDriver("chrome");
    }

}
