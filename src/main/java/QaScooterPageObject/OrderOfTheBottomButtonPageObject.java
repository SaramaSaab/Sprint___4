package QaScooterPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderOfTheBottomButtonPageObject {
    private WebDriver driver;

    public OrderOfTheBottomButtonPageObject(WebDriver driver){
        this.driver = driver;
    }

    //локатор для кнопки заказа внизу страницы
    private final By bottomButton = By.className("Button_Middle__1CSJM");

    //ждем появления кнопки внизу
    public void waitBottomButton() {
        WebElement element = driver.findElement(By.className("Button_Middle__1CSJM"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(bottomButton));
    }

    //кликаем на кнопку внизу
    public void clickBottomButton(){
        driver.findElement(bottomButton).click();
    }
}
