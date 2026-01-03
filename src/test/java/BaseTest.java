import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;
import page.OrderPage;

public class BaseTest {
    WebDriver driver = new ChromeDriver();
    MainPage mainPage;
    OrderPage orderPage;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}