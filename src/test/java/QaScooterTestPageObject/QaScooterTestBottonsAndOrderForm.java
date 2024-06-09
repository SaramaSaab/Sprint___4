package QaScooterTestPageObject;
import QaScooterPageObject.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class QaScooterTestBottonsAndOrderForm {

    public WebDriver driver;
   //переменная для локаторов кнопок заказа наверху и внизу
    private final By buttonOrder;
    //переменная для имени в форме заказа
    private final String firstName;
    //переменная для фамилии в форме заказа
    private final String secondName;
    //переменная для адреса в форме заказа
    private final String address;
    //переменная для номера телефона в форме заказа
    private final String numberForCall;

    public QaScooterTestBottonsAndOrderForm(By buttonOrder, String firstName, String secondName, String address, String numberForCall){
        this.buttonOrder = buttonOrder;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.numberForCall = numberForCall;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] setText() {
        //переменная для локатора кнопки заказа наверху
        Object buttonUp = By.xpath(".//button[@class = 'Button_Button__ra12g']");
        //переменная для кнопки заказа внизу
        Object buttonDown = By.className("Button_Middle__1CSJM");
        return new Object[][] {
                {buttonUp, "МаРиНа", "Ых", "Санкт-Петербург, улица Пропановская, дом 134", "79879991111"},
                {buttonUp, "илья", "смирнов", "село Зеленое, улица Береговая, дом 10", "89994445511"},
                {buttonDown, "Алла", "Иванова", "Москва, улица Белач, дом 1", "89809998877"},
                {buttonDown, "ПОТАП", "ПОТАПОВИЧ", "Уссурийск-на-Амуре, улица Бе, дом 1", "79098760001"},
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

        //клик на кнопку заказа и после ввод в форму заказа данные
        OrderFormTextPageObject formTextWindow = new OrderFormTextPageObject(driver);
        formTextWindow.inputTextIntoOrderUserDataWindow(buttonOrder, firstName, secondName, address, numberForCall);

        //заполнили детали заказа - время/цвет/дата
        InputRentWindowPageObject objRentWindow = new InputRentWindowPageObject(driver);
        objRentWindow.rentWindow();

        //клик на кнопку подтверждения в окне подтверждения информации - здесь баг, кнопка
        //некликабельна
        OrderConfirmationWindowPageObject objConfirmationWindow = new OrderConfirmationWindowPageObject(driver);
        objConfirmationWindow.setConfirmWindowOrder();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
