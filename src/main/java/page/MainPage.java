package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By goButton = By.xpath("//button[text()=\"Go!\"]");
    private By statusField = By.cssSelector("input[placeholder='Введите номер заказа']");
    private By statusBtn = By.className("Header_Link__1TAG7");
    private String URL = "https://qa-scooter.praktikum-services.ru/";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }

    public void setOrderNumber(String number) {
        driver.findElement(statusField).sendKeys(number);
    }

    public void clickStatusButton() {
        driver.findElement(statusBtn).click();
    }

    public void openPage() {
        driver.get(URL);
    }
}