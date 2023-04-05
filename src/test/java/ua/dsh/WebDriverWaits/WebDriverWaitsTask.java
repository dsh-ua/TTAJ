package ua.dsh.WebDriverWaits;
import java.time.Duration;
import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebDriverWaitsTask {
    private final String BASE_URL = "https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/filtering/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

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
    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        if (driver != null) {
            driver.quit();
        }
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
        closePopup();
    }
    private void closePopup() {
        presentationSleep(); // For Presentation ONLY
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> footerButton = driver.findElements(By.xpath("//footer[contains(@class,'cookie')]//button"));
        if (footerButton.size() > 0) {
            footerButton.get(0).click();
            presentationSleep(); // For Presentation ONLY
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
    }

    @Test
    public void WebDriverWaitsTest() {
        WebElement linkFilterUncontrolMode = driver.findElement(By.xpath("//*[@id=\"uncontrolled-mode\"]/a"));
        linkFilterUncontrolMode.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@data-options,'/filter-row')]//iframe")));
        presentationSleep(2); // Do no use
        WebElement filterFieldCity = driver.findElement(By.xpath("/html/body/*//table/thead/tr[2]/th[3]/*//input"));
        filterFieldCity.click();
        presentationSleep(2); // Do no use
        filterFieldCity.sendKeys("L");
        presentationSleep(2); // Do no use
        WebElement tdLondon = driver.findElement(By.xpath("//td[text()='London']"));
        WebElement tdLasVegas = driver.findElement(By.xpath("//td[text()='Las Vegas']"));
        System.out.println(tdLondon.getText() + " is found");
        System.out.println(tdLasVegas.getText() + " is found");
    }
}
