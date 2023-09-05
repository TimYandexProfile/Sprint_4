import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

public class FirefoxOrderSamokat {
    public static void main(String[] args) {
        // Указываем путь к драйверу браузера (Firefox)
        System.setProperty("webdriver.gecko.driver", "D:/Samokat/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
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


        // Проверка наличия первого поля с именем, кликаем на поле, вводим имя
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Имя']")));
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Евгений");

        // Находим поле с фамилией
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Лавочкин");

        // Находим поле с адресом
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys("ул. Русаковская д. 27");

        // Находим поле со станцией метро
        driver.findElement(By.xpath("//input[@placeholder='* Станция метро']")).click();

        // Ожидаем появления списка опций
        By dropdownOptionsLocator = By.cssSelector(".select-search__option");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownOptionsLocator));

        // Находим и кликаем на нужную опцию
        List<WebElement> dropdownOptions = driver.findElements(dropdownOptionsLocator);
        for (WebElement option : dropdownOptions) {
            if (option.getText().equals("Красносельская")) {
                option.click();
                break;
            }
        }

        // Находим поле с телефоном, кликаем на поле, вводим телефон
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys("89183015840");

        // Ожидание для того, чтобы увидеть заполненные поля
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
            e.printStackTrace();
        }

        // Находим кнопку "Далее", нажимаем на неё
        WebElement nextButton = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));
        nextButton.click();


        // Проверка наличия первого поля с календарём, открываем календарь и нажимаем на дату
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Когда привезти самокат']")));
        driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']")).click();
        WebElement date17 = driver.findElement(By.xpath("//div[@aria-label='Choose четверг, 17-е августа 2023 г.']"));
        date17.click();

        // Открываем список "Срок аренды" и выбираем срок
        driver.findElement(By.xpath("//div[@class='Dropdown-placeholder']")).click();
        WebElement dropDown= driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='трое суток']"));
        dropDown.click();

        // Выбираем цвет самоката (здесь ошибка, параметр name задан неправильно)
        driver.findElement(By.xpath("//label[contains(text(), 'чёрный жемчуг')]/input")).click();

        // Добавляем комментарий для курьера
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).sendKeys("По возможности лучше всего доставить к 3 часам дня.");

        // Находим кнопку "Заказать", нажимаем на неё
        WebElement orderButton = driver.findElement(By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]//button[text()='Заказать']"));
        orderButton.click();

        // Нажимаем на кнопку "Да" в попапе
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement okayButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']")));
        okayButton.click();

        // Проверяем, что появилось всплывающее окно об успешном создании заказа
        boolean isOrderConfirmed = false;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']")));
            isOrderConfirmed = true;
        } catch (Exception e) {
            System.out.println("Не удалось оформить заказ.");
        }

        if (isOrderConfirmed) {
            System.out.println("Заказ успешно оформлен!");
        }

        // Ожидание для того, чтобы увидеть успешно оформленный заказ
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
            e.printStackTrace();
        }



        // Закрываем браузер
        driver.quit();

    }
}
