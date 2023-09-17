import org.example.MainPageElements;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxAccordionButtonsTest {

        private MainPageElements mainPageElements;

        @Before
        public void setUp() {
            // Указываем путь к драйверу браузера (Mozilla Firefox)
            System.setProperty("webdriver.gecko.driver", "D:/Samokat/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            mainPageElements = new MainPageElements(driver);
        }

        @Test
        public void runTest() {
            // Открываем веб-страницу
            mainPageElements.getDriver().get("https://qa-scooter.praktikum-services.ru");

            //Принимаем куки
            mainPageElements.acceptCookies();

            // Прокручиваем экран до блока с кнопками
            mainPageElements.scrollToAccordionButton();

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
            };


            // Проверка текста в каждой кнопке
            for (int i = 0; i < expectedTexts.length; i++) {
                mainPageElements.clickAccordionButton(i);
                String expectedText = expectedTexts[i];
                String actualText = mainPageElements.getAccordionText(i);

                if (actualText.equals(expectedText)) {
                    System.out.println("Текст верный для кнопки " + (i + 1) + ": " + actualText);
                } else {
                    System.out.println("Текст не совпадает для кнопки " + (i + 1) + ". Ожидаемый: " + expectedText + ". Фактический: " + actualText);
                }
                Assert.assertEquals(expectedText, actualText);
            }
        }

        // Закрываем браузер
            @After
            public void tearDown() {
                mainPageElements.getDriver().quit();}
    }



