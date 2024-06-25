import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    /** The driver. */
    protected WebDriver driver;

    /**     * Setup.     */
    @BeforeTest
    protected void setup() {
// System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("disable-infobars");

        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebDriverContext.setDriver(driver);
    }

    /**     * Wrap up.     */
    @AfterTest
    public void wrapUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}