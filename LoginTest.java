import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
        // This test checks if registered user can log in

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

            // Check if the correct webpage is loaded
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.getTitle();
        System.out.println(driver.getTitle());
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());

            // Enter user e-mail and password
        driver.findElement(By.id("email")).sendKeys("aa@bb.ee");
        driver.findElement(By.id("passwd")).sendKeys("Pass123");
        driver.findElement(By.id("SubmitLogin")).click();

            // Wait for the registered user home page to load
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='My personal information']")));

        System.out.println("Login successful!");
        driver.close();

    }
}
