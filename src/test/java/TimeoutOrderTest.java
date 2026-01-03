import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class TimeoutOrderTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        // Инициализируем драйвер браузера
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Ожидание до 20 секунд
    }

    @Test
    public void errorOrderTest() {
        // Открываем сайт
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Нажатие кнопки «Статус заказа»
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Header_Link__1TAG7"))).click();

        // Вводим несуществующий номер заказа
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Введите номер заказа']"))).sendKeys("000");

        // Нажать кнопку Go
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Button_Button__ra12g.Header_Button__28dPO"))).click();

        // Сравниваем ОР и ФР
        WebElement errorImage = driver.findElement(By.cssSelector("img[alt = 'Not found']"));
        assertTrue("Сообщение обошибке не отображается", errorImage.isDisplayed());
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }
}