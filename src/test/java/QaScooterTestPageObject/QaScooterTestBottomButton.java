package QaScooterTestPageObject;
import QaScooterPageObject.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class QaScooterTestBottomButton {
    public WebDriver driver;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String numberForCall;

    public QaScooterTestBottomButton(String firstName, String secondName, String address, String numberForCall){
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.numberForCall = numberForCall;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] setText() {
        return new Object[][] {
                {"Алла", "Иванова", "Москва, улица Белач, дом 1", "89809998877"},
                {"ПОТАП", "ПОТАПОВИЧ", "Уссурийск-на-Амуре, улица Бе, дом 1", "79098760001"},
        };
    }

    @Test
    public void checkAllowChrome () {
        driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //дали разрешение на куки
        CookiesWindowPageObject objCookiesAllow = new CookiesWindowPageObject(driver);
        objCookiesAllow.allowCookies();

        //кликнули по кнопке заказа внизу
        OrderOfTheBottomButtonPageObject objBottomButton = new OrderOfTheBottomButtonPageObject(driver);
        objBottomButton.waitBottomButton();
        objBottomButton.clickBottomButton();

        //ввели в форму заказа данные
        OrderFormTextPageObject formTextWindow = new OrderFormTextPageObject(driver);

        formTextWindow.inputTextIntoOrderUserDataWindow(firstName, secondName, address, numberForCall);

        //заполнили детали заказа - время/цвет/дата
        InputRentWindowPageObject objRentWindow = new InputRentWindowPageObject(driver);
        objRentWindow.rentWindow();

        //клик на кнопку подтверждения окна подтверждения информации - здесь баг, кнопка
        //некликабельна
        OrderConfirmationWindowPageObject objConfirmationWindow = new OrderConfirmationWindowPageObject(driver);
        objConfirmationWindow.setConfirmWindowOrder();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
