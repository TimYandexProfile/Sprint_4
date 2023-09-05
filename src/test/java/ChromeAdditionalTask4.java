import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

public class ChromeAdditionalTask4 {
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


        // Находим кнопку "Статус заказа", нажимаем на неё
        WebElement statusButton = driver.findElement(By.className("Header_Link__1TAG7"));
        statusButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Введите номер заказа']")));

        // try {
        //    Thread.sleep(5000);
        // } catch (InterruptedException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
        //    e.printStackTrace();
        // }

        // 252488 - номер, по которому можно посмотреть заказ

        // Вводим номер заказа и переходим на страницу с заказом
        driver.findElement(By.xpath("//input[@placeholder='Введите номер заказа']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Введите номер заказа']")).sendKeys("252481");
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']")).click();

        // Добавил ожидание потому что переход на новую страницу не всегда успевает отрисовываться
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
            e.printStackTrace();
        }

        List<WebElement> orderStatusElements = driver.findElements(By.xpath("//div[contains(@class, 'Track_OrderInfo__2fpDL')]//div[contains(text(), 'Курьер задерживается')]"));

        if (!orderStatusElements.isEmpty()) {
            System.out.println("Перешли на страницу с заказом");
        } else {
            System.out.println("Перешли на страницу без заказа");
        }

        driver.quit();
    }
}

