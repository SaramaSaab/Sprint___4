package QaScooterPageObject;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {

    //метод для браузера Хром
    public WebDriver webDriverFromChrome(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    //метод для браузера Mozilla
    public WebDriver webDriverFromMozilla(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
