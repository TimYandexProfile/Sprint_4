import org.example.MainPageElements;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeAdditionalTask2Test {
    private MainPageElements mainPageElements;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/Samokat/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        mainPageElements = new MainPageElements(driver);
        mainPageElements.getDriver().get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void testRedirectToYandex_ok() {
        String textInPlaceholder = mainPageElements.goToYandex();

        Assert.assertEquals("Поиск Яндекса", textInPlaceholder);
    }

    @After
    public void tearDown() {
        mainPageElements.getDriver().quit();
    }
}


