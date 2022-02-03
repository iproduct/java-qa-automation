package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericTest {

    WebDriver driver;

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(classes = { ChromeDriver.class, FirefoxDriver.class })
    void test(Class<? extends WebDriver> webDriverClass) {
        // Driver management and WebDriver instantiation
        driver = WebDriverManager.getInstance(webDriverClass).create();

        // Exercise
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("Selenium WebDriver");
    }

    @ParameterizedTest
    @ValueSource(classes = { ChromeDriver.class, FirefoxDriver.class })
    void whenHomePageLoaded_thenTitleArticlesListAndLocationArticles(Class<? extends WebDriver> webDriverClass) {
        // Driver management and WebDriver instantiation
        driver = WebDriverManager.getInstance(webDriverClass).create();

        // Exercise
        driver.get("http://localhost:8080/");
        String title = driver.getTitle();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String location = (String)jse.executeScript("return window.location.href;");

        // Verify
        assertThat(location).isEqualTo("http://localhost:8080/articles");
        assertThat(title).isEqualTo("Articles List");
    }

    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
    @DisplayName("When home page is loaded, then h3 header should be 'ArticlesList'")
    void whenHomePageLoaded_thenH3IsArticlesList(Class<? extends WebDriver> webDriverClass) {
        // Driver management and WebDriver instantiation
        driver = WebDriverManager.getInstance(webDriverClass).create();

        // Exercise
        driver.get("http://localhost:8080/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement h3 = driver.findElement(By.xpath("//div[@class='container']/h3"));
//        WebElement h3 = driver.findElement(By.cssSelector(".container h3"));
//        WebElement divContainer = driver.findElement(By.className("container"));
//        WebElement h3 = divContainer.findElement(By.tagName("h3"));

        // Verify
        assertThat(h3.getText()).isEqualTo("Articles List");
    }

    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
    @DisplayName("When home page is loaded, then click 'Add Article' link, submit new article, and verify all articles")
    void whenHomePageLoaded_thenClickOnAddArticleLinkAndAddNewArticle(Class<? extends WebDriver> webDriverClass) {
        // Driver management and WebDriver instantiation
        driver = WebDriverManager.getInstance(webDriverClass).create();

        // Exercise
        // Navigate to Url
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        // Store 'Gmail' anchor web element
        WebElement linkAddArticle = driver.findElement(By.linkText("Add Article"));
        linkAddArticle.click();
//        Actions actionProvider = new Actions(driver);
        // Performs mouse move action onto the element
//            actionProvider.click(linkAddArticle).build().perform();

        // Verify navigation to Add Article page
        WebElement h3 = driver.findElement(By.cssSelector(".container h3"));
        assertThat(h3.getText()).isEqualTo("Add New Article");


    }


}
