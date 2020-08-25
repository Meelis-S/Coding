package newpackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class MessageTest {
    // This test checks the sending of a message to customer service

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://automationpractice.com/index.php?controller=contact";
        String expectedTitle = "Contact us - My Store";
        String actualTitle = "";

        // launch browser and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        // compare actual title of the page with the expected one and print result

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
            System.out.println(actualTitle);
        }

        // Send a message to customer support
        Select drpDestin = new Select(driver.findElement(By.id("id_contact")));
        drpDestin.selectByVisibleText("Customer service");
        driver.findElement(By.id("email")).sendKeys("aa@dd.ee");
        driver.findElement(By.id("message")).sendKeys("Test");
        driver.findElement(By.id("submitMessage")).click();

        // Wait for the confirmation message to be presented and print it to the console
        WebElement alertMessage = driver.findElement(By.xpath("//*[@id='center_column']/p"));
        Thread.sleep(5000);
        String textVar;
        textVar = alertMessage.getText();
        System.out.println(textVar);

    }
}
