package QaScooterPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderOfTheTopButtonPageObject {
    private final WebDriver driver;

    public OrderOfTheTopButtonPageObject(WebDriver driver){
        this.driver = driver;
    }

    //локатор для кнопки заказа нверху
    private final By theButtonUp = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    //локатор для формы заказа
    private final By orderForm = By.xpath(".//div[@class = 'App_App__15LM-']");

    //метод клика на кнопку заказа
    public void clickButtonUp() {
        driver.findElement(theButtonUp).click();
    }

    //ждем появления окна заказа
    public void waitForLoadHeader() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderForm));
    }
}
