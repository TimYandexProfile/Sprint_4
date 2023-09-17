import org.example.util.Constants;
import org.example.MainPageElements;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeOrderSamokatTest {

    private MainPageElements mainPageElements;

    @Before
    public void setUp() {
        System.setProperty(Constants.CHROME_DRIVER_PROP, Constants.CHROME_DRIVER_LOCATION);
        WebDriver driver = new ChromeDriver();
        mainPageElements = new MainPageElements(driver);
        // Открываем веб-страницу
        mainPageElements.getDriver().get(Constants.SCOOTER_URL);
    }

    @Test
    public void runTest() {
        //Accept cookies
        mainPageElements.acceptCookies();

        // Находим кнопку "Заказать" и нажимаем на неё
        mainPageElements.clickStartOrder();

        // Ожидание для наблюдения изменений
        mainPageElements.waitForOrderPage();

        // Нажатие на поле с именем и ввод имени
        mainPageElements.clickOnTheFieldAndEnterValue("Евгений", false, "Имя");

        // Нажатие на поле с фамилией и ввод фамилии
        mainPageElements.clickOnTheSurnameAndEnterYourSurname("Лавочкин");

        // Нажатие на поле с адресом и ввод адреса
        mainPageElements.findAddress("ул. Русаковская д. 27");

        // Открываем список станций метро и выбираем станцию
        mainPageElements.findMetroStation();

        // Находим поле с телефоном, кликаем на поле, вводим телефон
        mainPageElements.findPhoneNumberAndEnter("89183015840");

        // Находим кнопку "Далее", нажимаем на неё
        mainPageElements.nextButton();

        // Открываем календарь
        mainPageElements.openCalendar();

        // Открываем "Срок аренды"
        mainPageElements.rentalPeriod();

        // Выбираем цвет самоката
        mainPageElements.colorSamokat();

        // Добавляем комментарий для курьера
        mainPageElements.commentForTheCourier("//input[@placeholder='Комментарий для курьера']", "По возможности лучше всего доставить к 3 часам дня.");

        // Находим кнопку "Заказать", нажать на неё
        mainPageElements.orderButton();

        // Нажимаем кнопку "Да" в попапе
        mainPageElements.buttonYes();

        String response = mainPageElements.checkTheWindowOrder();

        Assert.assertNotNull(response);
        Assert.assertEquals("Не удалось оформить заказ.", response);
    }


    @After
    // Закрываем браузер
    public void tearDown() {
        mainPageElements.getDriver().quit();}

}

