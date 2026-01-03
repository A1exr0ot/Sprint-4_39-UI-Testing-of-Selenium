import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTest{

    @Test
    public void errorOrderTest() {

        mainPage.openPage();
        mainPage.clickStatusButton();
        mainPage.setOrderNumber("458976");
        mainPage.clickGoButton();

        assertTrue("Сообщение обошибке не отображается", orderPage.getImg().isDisplayed());
    }
}