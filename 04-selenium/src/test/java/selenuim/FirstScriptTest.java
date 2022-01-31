package selenuim;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FirstScriptTest {
    public WebDriver driver;

    @Test
    public void eightComponents() {
        System.setProperty("webdriver.chrome.driver","D:\\CourseJavaQA\\chromedriver_win32\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://google.com");

        Assertions.assertEquals("Google", driver.getTitle());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        Assertions.assertEquals("Selenium", searchBox.getAttribute("value"));

        driver.quit();
    }
}
