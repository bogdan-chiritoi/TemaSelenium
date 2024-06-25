import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SamsungDevicesTest extends BaseTest {

    @Test
    public void testCountSamsungDevices() {
        // Open the browser and navigate to the URL
        driver.navigate().to("https://www.demoblaze.com/");

        // Wait for the page to load and find all products
        List<WebElement> products = driver.findElements(By.className("card-title"));

        // Filter the products to count only Samsung devices
        long samsungCount = products.stream()
                .filter(product -> product.getText().contains("Samsung"))
                .count();

        // Assert the number of Samsung devices (adjust the expected number as necessary)
        System.out.println("Number of Samsung devices: " + samsungCount);
        Assert.assertTrue(samsungCount > 0, "No Samsung devices found on the page");
    }
}