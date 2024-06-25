import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends BaseTest {

    @Test
    public void testUserRegistrationAndLogin() {
        // Open the browser and navigate to the URL
        driver.navigate().to("https://www.demoblaze.com/");

        // Click on the "Sign up" button to open the registration modal
        WebElement signUpButton = driver.findElement(By.id("signin2"));
        signUpButton.click();

        // Wait for the modal to appear and find username and password fields
        WebElement usernameField = driver.findElement(By.id("sign-username"));
        WebElement passwordField = driver.findElement(By.id("sign-password"));

        // Enter new credentials (use unique values each time for testing)
        String newUsername = "demoTestUsername"; // Change to a unique value
        String newPassword = "demoTestPassword"; // Change to a unique value
        usernameField.sendKeys(newUsername);
        passwordField.sendKeys(newPassword);

        // Click the "Sign up" button within the modal
        WebElement signUpSubmitButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
        signUpSubmitButton.click();

        // Wait for any alerts and handle them (if present)
        driver.switchTo().alert().accept();

        // Log out if already logged in from previous sessions
        try {
            WebElement logoutButton = driver.findElement(By.id("logout2"));
            if (logoutButton.isDisplayed()) {
                logoutButton.click();
            }
        } catch (Exception ignored) {}

        // Now log in with the new user credentials
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        WebElement loginUsernameField = driver.findElement(By.id("loginusername"));
        WebElement loginPasswordField = driver.findElement(By.id("loginpassword"));

        loginUsernameField.sendKeys(newUsername);
        loginPasswordField.sendKeys(newPassword);

        WebElement loginSubmitButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginSubmitButton.click();

        // Assert the user is logged in by checking the presence of the "Log out" button
        WebElement logoutButton = driver.findElement(By.id("logout2"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed, login might have failed");
    }
}