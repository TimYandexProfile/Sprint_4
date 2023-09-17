import org.example.MainPageElements;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeAdditionalTask1Test {
    private MainPageElements mainPageElements;

    @Before
    public void setUp() {
        // Указываем путь к драйверу браузера (Chrome)
        System.setProperty("webdriver.chrome.driver", "D:/Samokat/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        mainPageElements = new MainPageElements(driver);
        // Открываем веб-страницу
        mainPageElements.getDriver().get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void testMainPage() {
        // Ждём появления окна с куками и нажимаем на кнопку "да, все привыкли"
        mainPageElements.acceptCookies();

        // Находим кнопку "Заказать" и нажимаем на неё
        mainPageElements.clickStartOrder();

        // Ожидание для наблюдения изменений
        mainPageElements.waitForOrderPage();

        // Нажатие на логотип
        mainPageElements.clickLogo();

        // Ожидание появления текста "Самокат на пару дней"
        mainPageElements.waitForHeaderText("Самокат ");

        // Проверка текста
        WebElement element = mainPageElements.checkSamokatText();

        if (element.isDisplayed()) {
            System.out.println("Автотест вернулся на главную страницу по нажатию на логотип \"Самоката\"");
        } else {
            System.out.println("Текст 'Самокат ' не найден на странице или не видим.");
        }

        Assert.assertTrue(element.isDisplayed());
    }



    @After
    public void tearDown() {
        mainPageElements.getDriver().quit();
    }
}
