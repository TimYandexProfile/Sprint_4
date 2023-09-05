import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

public class ChromeAdditionalTask3 {
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


        // Проверка наличия первого поля с именем, кликаем на поле, вводим имя
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Имя']")));
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Nick");

        // Находим поле с фамилией
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Wilson");

        // Находим поле с адресом
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys("540 Washington Blvd");

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
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys("1-718-656-4012");

        // Находим кнопку "Далее", нажимаем на неё
        WebElement nextButton = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));
        nextButton.click();

        // Ожидание для того, чтобы увидеть заполненные поля
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
            e.printStackTrace();
        }

        System.out.println("Все формы, кроме выпадающего списка выдали ошибки. Я не знаю как сымитировать ошибку в выпадающем списке) " +
                "Теперь вводим правильные значения, чтобы перейти к другой странице");

        // Проверка наличия первого поля с именем, кликаем на поле, вводим имя
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='* Имя']")));
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).click();
        WebElement inputElement = driver.findElement(By.xpath("//input[@placeholder='* Имя']"));
        inputElement.click(); // Кликаем на элемент для активации
        inputElement.clear(); // Очищаем текст из элемента
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys("Евгений");

        // Находим поле с фамилией
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).click();
        WebElement inputElement1 = driver.findElement(By.xpath("//input[@placeholder='* Фамилия']"));
        inputElement1.click(); // Кликаем на элемент для активации
        inputElement1.clear(); // Очищаем текст из элемента
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys("Лавочкин");

        // Находим поле с адресом
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).click();
        WebElement inputElement2 = driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"));
        inputElement2.click(); // Кликаем на элемент для активации
        inputElement2.clear(); // Очищаем текст из элемента
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys("ул. Русаковская д. 27");

        // Находим поле со станцией метро
        driver.findElement(By.xpath("//input[@placeholder='* Станция метро']")).click();

        // Ожидаем появления списка опций
        By dropdownOptionsLocator1 = By.cssSelector(".select-search__option");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownOptionsLocator1));

        // Находим и кликаем на нужную опцию
        List<WebElement> dropdownOptions1 = driver.findElements(dropdownOptionsLocator1);
        for (WebElement option : dropdownOptions1) {
            if (option.getText().equals("Красносельская")) {
                option.click();
                break;
            }
        }

        // Находим поле с телефоном, кликаем на поле, вводим телефон
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).click();
        WebElement inputElement3 = driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"));
        inputElement3.click(); // Кликаем на элемент для активации
        inputElement3.clear(); // Очищаем текст из элемента
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys("89183015840");


        // Находим кнопку "Далее", нажимаем на неё
        WebElement nextButton1 = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));
        nextButton1.click();


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

        // Добавляем комментарий для курьера - принимает любой текст
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Комментарий для курьера']")).sendKeys("fwefewf-9234-234;''2312=`234234234");


        // Ожидание для того, чтобы увидеть заполненные поля
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Обработка исключения, например, вывод сообщения об ошибке
            e.printStackTrace();
        }

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
            System.out.println("Не удалось оформить заказ. Потому что проверка с ChromeDriver.");
        }

        if (isOrderConfirmed) {
            System.out.println("Заказ успешно оформлен!");
        }


        // Закрываем браузер
        driver.quit();

    }
}
