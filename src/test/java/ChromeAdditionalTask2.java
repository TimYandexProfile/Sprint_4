import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.Set;


public class ChromeAdditionalTask2 {
    public static void main(String[] args) {
        // Указываем путь к драйверу браузера (Chrome)
        System.setProperty("webdriver.chrome.driver", "D:/Samokat/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Открываем веб-страницу
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Ждём появления окна с куками и нажимаем на кнопку "да все привыкли"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rcc-confirm-button")));
        driver.findElement(By.id("rcc-confirm-button")).click();

        // Получаем идентификатор текущего окна
        String mainWindowHandle = driver.getWindowHandle();

// Находим и нажимаем на кнопку
        WebElement button = driver.findElement(By.xpath("//a[@class='Header_LogoYandex__3TSOI']"));
        button.click();

// Дожидаемся появления нового окна
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.numberOfWindowsToBe(2));

// Получаем идентификаторы всех окон
        Set<String> windowHandles = driver.getWindowHandles();

// Находим новый идентификатор окна
        String newWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }

// Переключаемся на новое окно
        driver.switchTo().window(newWindowHandle);

// Выполняем дополнительные действия на новой странице
// Например, можно проверить URL страницы
        By placeholderLocator = By.xpath("//div[@class='dzen-search-arrow-common__placeholder' and text()='Поиск Яндекса']");
        WebElement searchInputPlaceholder = driver.findElement(placeholderLocator);

        if (searchInputPlaceholder.isDisplayed()) {
            System.out.println("Открыто новое окно с Yandex.");
        } else {
            System.out.println("Открыто новое окно, но не с Yandex.");
        }

        driver.quit();

    }
}


