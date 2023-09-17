package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class MainPageElements {
    public static final int TIMEOUT_IN_SECONDS = 10;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPageElements(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void acceptCookies() {
        WebElement cookiesButton = driver.findElement(By.id("rcc-confirm-button"));
        wait.until(ExpectedConditions.visibilityOf(cookiesButton));
        cookiesButton.click();
    }

    public void scrollToAccordionButton() {
        WebElement accordionButton = driver.findElement(By.id("accordion__heading-0"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", accordionButton);
    }

    public void clickAccordionButton(int index) {
        String buttonId = "accordion__heading-" + index;
        WebElement accordionButton = driver.findElement(By.id(buttonId));
        accordionButton.click();
    }

    public String getAccordionText(int index) {
        String panelId = "accordion__panel-" + index;
        WebElement textElement = driver.findElement(By.id(panelId));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(panelId), textElement.getText()));
        return textElement.getText();
    }

    public void clickStartOrder() {
        WebElement startOrder = driver.findElement(By.className("Button_Button__ra12g"));
        startOrder.click();
    }

    public void waitForOrderPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Order_Header__BZXOb")));
        System.out.println("Страница Для кого самокат открылась");
    }

    public void clickLogo() {
        WebElement logoLink = driver.findElement(By.cssSelector("a.Header_LogoScooter__3lsAR"));
        logoLink.click();
    }

    public void waitForHeaderText(String text) {
        By textLocator = By.xpath(
                "//div[contains(@class, 'Home_Header__iJKdX') and contains(text(), '" + text + "')]"
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
    }

    public void clickOnTheFieldAndEnterValue(String name, boolean clearText, String fieldName) {
// Проверка наличия первого поля с именем, кликаем на поле, вводим имя
        By locator = By.xpath("//input[@placeholder='* " + fieldName + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.click();
        if (clearText) {
            element.clear();
        }

        element.sendKeys(name);
    }

    public void clickOnTheSurnameAndEnterYourSurname(String lastName) {
        // Находим поле с фамилией
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='* Фамилия']"));
        element.click();
        element.sendKeys(lastName);
    }

    public void findAddress(String address) {
        // Находим поле с адресом
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"));
        element.click();
        element.sendKeys(address);
    }

    public void findMetroStation() {
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
    }

    public void findPhoneNumberAndEnter(String number) {
        // Находим поле с телефоном, кликаем на поле, вводим телефон
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"));
        element.click();
        element.sendKeys(number);
    }

    public void nextButton() {
        // Находим кнопку "Далее", нажимаем на неё
        WebElement nextButton = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));
        nextButton.click();
    }

    public void openCalendar() {
        // Проверка наличия первого поля с календарём, открываем календарь и нажимаем на дату
        By locator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
        WebElement date17 = driver.findElement(By.xpath("//div[@aria-label='Choose четверг, 14-е сентября 2023 г.']"));
        date17.click();
    }

    public void rentalPeriod() {
        // Открываем список "Срок аренды" и выбираем срок
        driver.findElement(By.xpath("//div[@class='Dropdown-placeholder']")).click();
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='трое суток']"));
        dropDown.click();
    }

    public void colorSamokat() {
        // Выбираем цвет самоката (здесь ошибка, параметр name задан неправильно)
        driver.findElement(By.xpath("//label[contains(text(), 'чёрный жемчуг')]/input")).click();
    }

    public void commentForTheCourier(String xpathExpression, String comment) {
        // Добавляем комментарий для курьера
        driver.findElement(By.xpath(xpathExpression)).click();
        driver.findElement(By.xpath(xpathExpression)).sendKeys(comment);
    }

    public void orderButton() {
        // Находим кнопку "Заказать", нажимаем на неё
        WebElement orderButton = driver.findElement(By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]//button[text()='Заказать']"));
        orderButton.click();
    }

    public void buttonYes() {
        // Нажимаем на кнопку "Да" в попапе
        WebElement okayButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Order_Modal__YZ-d3']//button[text()='Да']")));
        okayButton.click();
    }

    public WebElement checkSamokatText() {
        By locator = By.xpath("//div[contains(@class, 'Home_Header__iJKdX') and contains(text(), 'Самокат ')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String checkTheWindowOrder() {
        // Проверяем, что появилось всплывающее окно об успешном создании заказа
        boolean isOrderConfirmed = false;
        String response = null;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']")));
            isOrderConfirmed = true;
        } catch (TimeoutException e) {
            response = "Не удалось оформить заказ.";
        }

        if (isOrderConfirmed) {
            response = "Заказ успешно оформлен!";
        }

        return response;
    }

    public String goToYandex() {
        acceptCookies();

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

        return searchInputPlaceholder.getText();
    }

    public List<WebElement> checkStatusOrder() {
        // Находим кнопку "Статус заказа", нажимаем на неё
        WebElement statusButton = driver.findElement(By.className("Header_Link__1TAG7"));
        statusButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Введите номер заказа']")));
        // Вводим номер заказа и переходим на страницу с заказом
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Введите номер заказа']"));
        element.click();
        element.sendKeys("252481");
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Header_Button__28dPO']")).click();
        List<WebElement> orderStatusElements = driver.findElements(By.xpath("//div[contains(@class, 'Track_OrderInfo__2fpDL')]//div[contains(text(), 'Курьер задерживается')]"));

        if (!orderStatusElements.isEmpty()) {
            System.out.println("Перешли на страницу с заказом");
        } else {
            System.out.println("Перешли на страницу без заказа");
        }

        return orderStatusElements;


    }
}
