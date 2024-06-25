import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginHappyPath() {
        // Open the browser and navigate to the URL
        driver.navigate().to("https://www.demoblaze.com/");

        // Click on the "Log in" button to open the login modal
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        // Wait for the modal to appear and find username and password fields
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        // Enter valid credentials (adjust these values as needed)
        usernameField.sendKeys("demoTestUsername");
        passwordField.sendKeys("demoTestPassword");

        // Click the "Log in" button within the modal
        WebElement loginSubmitButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginSubmitButton.click();

        // Wait and assert the user is logged in by checking the presence of the "Log out" button
        WebElement logoutButton = driver.findElement(By.id("logout2"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed, login might have failed");
    }
}