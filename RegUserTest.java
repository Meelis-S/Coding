import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegUserTest {
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

            // Enter new e-mail for registration  and submit
        driver.findElement(By.id("email_create")).sendKeys("aa@dd.ee");
        driver.findElement(By.id("SubmitCreate")).click();

            // Wait for the user data input page to load
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("alias")));

            // Enter user data and submit
        driver.findElement(By.id("customer_firstname")).sendKeys("TestingFirst");
        driver.findElement(By.id("customer_lastname")).sendKeys("TestingLast");
        driver.findElement(By.id("passwd")).sendKeys("Pass123");
        driver.findElement(By.id("address1")).sendKeys("Street 123");
        driver.findElement(By.id("city")).sendKeys("Tallinn");
        driver.findElement(By.id("postcode")).sendKeys("10101");
        Select drpCountry = new Select (driver.findElement(By.id("id_country")));
        drpCountry.selectByVisibleText("United States");
        Select drpState = new Select (driver.findElement(By.id("id_state")));
        drpState.selectByVisibleText("Texas");
        driver.findElement(By.id("phone_mobile")).sendKeys("+372 567890");
        driver.findElement(By.id("alias")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("alias")).sendKeys(Keys.DELETE);
        driver.findElement(By.id("alias")).sendKeys("Street 333");
        driver.findElement(By.id("submitAccount")).click();

            // Wait for the registered user home page to load
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='My personal information']")));

        System.out.println("Registration successful!");
        driver.close();



    }
}

