import org.example.MainPageElements;
import org.example.util.Constants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ChromeAdditionalTask4Test {

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

        //Принимаем куки
        mainPageElements.acceptCookies();


        // Находим кнопку "Статус заказа", нажимаем на неё
        List<WebElement> webElements = mainPageElements.checkStatusOrder();


        Assert.assertTrue(webElements.isEmpty());
    }

    @After
    public void tearDown() {
        mainPageElements.getDriver().quit();
    }
}

