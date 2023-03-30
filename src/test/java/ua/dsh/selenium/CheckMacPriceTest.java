package ua.dsh.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
public class CheckMacPriceTest {
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;
    private final String BASE_URL = "https://demo.opencart.com/";

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().window().maximize();
    }

    @Test
    public void checkMac() {

        driver.get(BASE_URL);
        presentationSleep();
        WebElement euroCurrency = driver.findElement(By.cssSelector("#form-currency > div > a > span"));
        euroCurrency.click();
        presentationSleep();
        WebElement curMenu = driver.findElement(By.cssSelector("#form-currency > div > ul > li:nth-child(1) > a"));
        curMenu.click();
        presentationSleep();
        WebElement desktopsMenu = driver.findElement(By.cssSelector("#menu li:nth-child(1)"));
        presentationSleep();
        desktopsMenu.click();
        presentationSleep();
        WebElement macMenu = driver.findElement(By.cssSelector("#menu li:nth-child(1) ul li:nth-child(2)"));
        macMenu.click();
        presentationSleep();
        WebElement iMacProduct = driver.findElement(By.cssSelector("#product-list > div > form > div > div.content > div.description > h4 > a"));
        String productName = iMacProduct.getText();
        presentationSleep();
        WebElement productPrice = driver.findElement(By.cssSelector("#product-list > div > form > div > div.content > div.description > div > span.price-new"));
        String price = productPrice.getText().replace("€", "");
        presentationSleep();
        Assert.assertEquals(productName, "iMac");
        Assert.assertEquals(price, "111.55");
        presentationSleep();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
