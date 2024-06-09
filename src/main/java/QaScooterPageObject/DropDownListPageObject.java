package QaScooterPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownListPageObject {
    private WebDriver driver;

    //локатор до окна с выпадающим списком вопросов
    private final By scrollToThePoint = By.xpath(".//div[@class= 'accordion']");
    //локатор для определения элементов списка с текстом
    public String clickOfPoint = ".//div[@id= 'accordion__heading-%d']";
    public String textOfPoint = ".//div[@id='accordion__panel-%d']/p";

    public DropDownListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //в методе ожидаем скролла до списка
    public void scrollOfListQuestions() {
        WebElement element = driver.findElement(scrollToThePoint);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(scrollToThePoint));
    }

    //получение текста из первой вкладки для сравнения в тестовом классе
    public String getTextOfListQuestions(int itemIndex) {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(scrollToThePoint));
        driver.findElement(By.xpath(String.format(clickOfPoint, itemIndex))).click();
        return driver.findElement(By.xpath(String.format(textOfPoint, itemIndex))).getText();
    }
}