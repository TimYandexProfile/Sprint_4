import org.example.MainPageElements;
import org.example.util.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeAdditionalTask3Test {

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
    public void checkErrorsFields () {

        //Принимаем куки
        mainPageElements.acceptCookies();

        // Находим кнопку "Заказать" и нажимаем на неё
        mainPageElements.clickStartOrder();

        // Ожидание для наблюдения изменений
        mainPageElements.waitForOrderPage();

        // Проверка наличия первого поля с именем, кликаем на поле, вводим имя
        mainPageElements.clickOnTheFieldAndEnterValue("Nick", false, "Имя");

        // Находим поле с фамилией
        mainPageElements.clickOnTheSurnameAndEnterYourSurname("Wilson");


        // Находим поле с адресом
        mainPageElements.findAddress("540 Washington Blvd");

        // Находим поле со станцией метро
        mainPageElements.findMetroStation();

        // Выбираем ту же станцию метро (вроде как ошибочный вариант нельзя подставить)
        mainPageElements.findMetroStation();

        // Находим поле с телефоном, кликаем на поле, вводим телефон
        mainPageElements.findPhoneNumberAndEnter("1-718-656-4012");

        // Находим кнопку "Далее", нажимаем на неё
        mainPageElements.nextButton();


        System.out.println("Все формы, кроме выпадающего списка выдали ошибки. Я не знаю как сымитировать ошибку в выпадающем списке) " +
                "Теперь вводим правильные значения, чтобы перейти к другой странице");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
            e.printStackTrace();
        }


        // Нажатие на поле с именем и ввод имени
        mainPageElements.clickOnTheFieldAndEnterValue("Евгений", true, "Имя");

        // Нажатие на поле с фамилией и ввод фамилии
        mainPageElements.clickOnTheFieldAndEnterValue("Лавочкин", true, "Фамилия");

        // Нажатие на поле с адресом и ввод адреса
        mainPageElements.clickOnTheFieldAndEnterValue("ул. Русаковская д. 27", true, "Адрес: куда привезти заказ");

        // Открываем список станций метро и выбираем станцию
        mainPageElements.findMetroStation();

        // Находим поле с телефоном, кликаем на поле, вводим телефон
        mainPageElements.clickOnTheFieldAndEnterValue("89183015840", true, "Телефон: на него позвонит курьер");


        // Находим кнопку "Далее", нажимаем на неё
        mainPageElements.nextButton();

        // Открываем календарь
        mainPageElements.openCalendar();

        // Открываем "Срок аренды"
        mainPageElements.rentalPeriod();

        // Выбираем цвет самоката
        mainPageElements.colorSamokat();

        // Добавляем комментарий для курьера
        mainPageElements.commentForTheCourier("//input[@placeholder='Комментарий для курьера']", "fwefewf-9234-234;''2312=`234234234");

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

