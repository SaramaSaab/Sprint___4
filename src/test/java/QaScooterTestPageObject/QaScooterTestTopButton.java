package QaScooterTestPageObject;
import QaScooterPageObject.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class QaScooterTestTopButton {
    public WebDriver driver;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String numberForCall;

    public QaScooterTestTopButton(String firstName, String secondName, String address, String numberForCall){
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.numberForCall = numberForCall;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] setText() {
        return new Object[][] {
                {"МаРиНа", "Ых", "Санкт-Петербург, улица Пропановская, дом 134", "79879991111"},
                {"илья", "смирнов", "село Зеленое, улица Береговая, дом 10", "89994445511"},
        };
    }

    @Test
    public void checkAllowChrome(){
        driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //дали разрешение на куки
        CookiesWindowPageObject objCookiesAllow = new CookiesWindowPageObject(driver);
        objCookiesAllow.allowCookies();

        //кликнули по кнопке заказа наверху
        OrderOfTheTopButtonPageObject objTopButton = new OrderOfTheTopButtonPageObject(driver);
        objTopButton.clickButtonUp();
        objTopButton.waitForLoadHeader();

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
