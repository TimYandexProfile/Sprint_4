import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class FirefoxAccordionButtons {
    public static void main(String[] args) {
        // Указываем путь к драйверу браузера (Firefox)
        System.setProperty("webdriver.gecko.driver", "D:/Samokat/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 секунд - максимальное время ожидания
        driver.get("https://qa-scooter.praktikum-services.ru");

        // MainPageElements mainPage = new MainPageElements(driver);

        // Ждём появления окна с куками и нажимаем на кнопку "да все привыкли"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rcc-confirm-button")));
        driver.findElement(By.id("rcc-confirm-button")).click();

        // Прокручиваем страницу к нужному элементу
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement accordionButton = driver.findElement(By.id("accordion__heading-0"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", accordionButton);

        // Находим и кликаем на кнопку (блок "Вопросы о важном")
        accordionButton.click();

        // Ожидаем появления кнопки и нажимаем на неё
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-0")));
        driver.findElement(By.id("accordion__heading-0")).click();

        // Перебор кнопок и проверка текста
        String[] expectedTexts = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."

                // Добавьте остальные ожидаемые тексты для остальных кнопок
        };

        for (int i = 0; i < expectedTexts.length; i++) {
            // WebElement accordionButton = driver.findElement(By.id("accordion__heading-" + i));
            accordionButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-" + i)));
            driver.findElement(By.id("accordion__heading-" + i)).click();
            WebElement textElement = driver.findElement(By.id("accordion__panel-" + i));
            String expectedText = expectedTexts[i];

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("accordion__panel-" + i), expectedText));

            String actualText = textElement.getText();

            if (actualText.equals(expectedText)) {
                System.out.println("Текст верный для кнопки " + i + ": " + actualText);
            } else {
                System.out.println("Текст не совпадает для кнопки " + i + ". Ожидаемый: " + expectedText + ". Фактический: " + actualText);
            }

            // Ждем появления текста в элементе
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("accordion__panel-" + i), expectedText));

        }

        // Закрываем браузер
        driver.quit();
    }
}


