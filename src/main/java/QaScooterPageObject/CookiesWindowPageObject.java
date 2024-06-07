package QaScooterPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookiesWindowPageObject {
    private WebDriver driver;

    public CookiesWindowPageObject(WebDriver driver){
        this.driver = driver;
    }

    //локатор для окна с куками
    private final By cookiesWindow = By.className("App_CookieConsent__1yUIN");
    //локатор для кнопка согласия с куками
    private final By cookiesButton = By.className("App_CookieButton__3cvqF");

    public void waitForCookiesWindow() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(cookiesWindow));
    }

    public void clickAllowCookiesButton(){
        driver.findElement(cookiesButton).click();
    }

    public void allowCookies(){
        waitForCookiesWindow();
        clickAllowCookiesButton();
    }
}
