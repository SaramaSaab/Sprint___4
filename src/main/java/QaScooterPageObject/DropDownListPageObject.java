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
    private final By elementOfListQuestions = By.id("accordion__heading-0");
    //локатор для определения первого элемента в списке с нижеуказанным текстом
    private final By textOfHeaderFirstPoint = By.xpath(".//div[text() = 'Сколько это стоит? И как оплатить?']");
    //локатор для поиска текста после клика на первый элемент с вопросом
    public final By textIntoList = By.xpath(".//div[@data-accordion-component = 'AccordionItemPanel']/p[text() = 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    public DropDownListPageObject(WebDriver driver){
        this.driver = driver;
    }

    //в методе ожидаем, что пока не прокрутится до выпадающего списка, не кликать
    //клик
    public void clickElementOfListQuestions(){
        WebElement element = driver.findElement(elementOfListQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(elementOfListQuestions));
        driver.findElement(textOfHeaderFirstPoint).click();
    }

    //получение текста из первой вкладки для сравнения в тестовом классе
    public String getTextOfFirstPointListQuestions(){
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(textIntoList));
        return driver.findElement(textIntoList).getText();
    }
}