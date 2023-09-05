import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class ChromeAdditionalTask1 {
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

        // Находим кнопку "Заказать", нажимаем на неё
        WebElement startOrder = driver.findElement(By.className("Button_Button__ra12g"));
        startOrder.click();

        // Ожидание для наблюдения изменений
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".Order_Header__BZXOb")));
        System.out.println("Страница Для кого самокат открылась");

        // Нажатие на логотип
        WebElement logoLink = driver.findElement(By.cssSelector("a.Header_LogoScooter__3lsAR"));
        logoLink.click();

        // Ожидание появления текста "Самокат на пару дней"
        // WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'Home_Header__iJKdX') and text()='Самокат на пару дней']")));

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        By locator = By.xpath("//div[contains(@class, 'Home_Header__iJKdX') and contains(text(), 'Самокат ')]");
        WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(locator));

        if (element1.isDisplayed()) {
            System.out.println("Автотест вернулся на главную страницу по нажатию на логотип \"Самоката\"");
        } else {
            System.out.println("Текст 'Самокат ' не найден на странице или не видим.");
        }


        driver.quit();
    }
}

