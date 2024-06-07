package QaScooterPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputRentWindowPageObject {
    private WebDriver driver;

    public InputRentWindowPageObject(WebDriver driver){
        this.driver = driver;
    }

    //путь до окна аренды
    private final By rentWindow = By.xpath(".//div/div[@class = 'Order_Content__bmtHS']");
    //клик на поле даты
    private By date = By.xpath(".//div/div[@class = 'react-datepicker__input-container']/input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //клик на выбор к-л даты
    private By choiceDate = By.xpath(".//div[@class = 'react-datepicker__day react-datepicker__day--018']");
    //путь до окна с выбором срока аренды
    private By listRentPeriod = By.xpath(".//div/span[@class = 'Dropdown-arrow']");
    //путь до выбора срока аренды - элемент с текстом трое суток
    private By choiceRentPeriod = By.xpath(".//div/div[text() = 'трое суток']");
    //путь до окна с выбором цвета
    private By colorOfScooter = By.xpath(".//div/div[@class = 'Order_Checkboxes__3lWSI']");
    //путь до чекбокса с черным цветом
    private By checkboxColorScooter = By.xpath(".//div/div/label/input[@class = 'Checkbox_Input__14A2w']");
    //путь до кнопки заказать
    private By buttonOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    //метод для проверки что окно ренты открыто
    public void waitForRentWindow() {
        new WebDriverWait(driver, 3)
                .until(driver -> (driver.findElement(rentWindow).getText() != null));
    }

    //клик на поле даты
    public void clickDateRentWindow(){
        driver.findElement(date).click();
    }

    //клик на выбор даты
    public void clickChoiceDateRentWindow(){
        driver.findElement(choiceDate).click();
    }

    //клик на окно с выбором срока аренды
    public void clickListRentPeriodWindow(){
        driver.findElement(listRentPeriod).click();
    }

    //выбор варианта аренды в окне аренды
    public void clickChoiceRentPeriodWindow(){
        driver.findElement(choiceRentPeriod).click();
    }

    //путь до окна с выбором цвета
    public void clickColorOfScooterRentWindow(){
        driver.findElement(colorOfScooter).click();
    }

    //выбор цвета
    public void clickCheckboxColorScooterRentWindow(){
        driver.findElement(checkboxColorScooter).click();
    }

    //клик по кнопке заказать
    public void clickButtonOrderRentWindow(){
        driver.findElement(buttonOrder).click();
    }

    public void rentWindow(){
        waitForRentWindow();
        clickDateRentWindow();
        clickChoiceDateRentWindow();
        clickListRentPeriodWindow();
        clickChoiceRentPeriodWindow();
        clickColorOfScooterRentWindow();
        clickCheckboxColorScooterRentWindow();
        clickButtonOrderRentWindow();
    }
}
