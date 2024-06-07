package QaScooterTestPageObject;
import QaScooterPageObject.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class TestDropDownList {
    public WebDriver driver;

    @Test
    public void checkAllowChrome() {
        driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //дали разрешение на куки
        CookiesWindowPageObject objCookiesAllow = new CookiesWindowPageObject(driver);
        objCookiesAllow.allowCookies();

        DropDownListPageObject objTextOnTheList = new DropDownListPageObject(driver);
        objTextOnTheList.clickElementOfListQuestions();
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualTest = objTextOnTheList.getTextOfFirstPointListQuestions();
        System.out.println(expectedText);//на всякий случай проверка в виде текста
        System.out.println(actualTest);
        // проверка полученного значения выпадающего списка с ожидаемым
        assertEquals(expectedText, actualTest);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
