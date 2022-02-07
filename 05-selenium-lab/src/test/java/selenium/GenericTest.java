package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
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
        driver.get("http://localhost:8081/");
        String title = driver.getTitle();
        String location = driver.getCurrentUrl();
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        String location = (String)jse.executeScript("return window.location.href;");

        // Verify
        assertThat(location).isEqualTo("http://localhost:8081/articles");
        assertThat(title).isEqualTo("Articles List");
    }

    @ParameterizedTest
    @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
    @DisplayName("When home page is loaded, then h3 header should be 'ArticlesList'")
    void whenHomePageLoaded_thenH3IsArticlesList(Class<? extends WebDriver> webDriverClass) {
        // Driver management and WebDriver instantiation
        driver = WebDriverManager.getInstance(webDriverClass).create();

        // Exercise
        driver.get("http://localhost:8081/");
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
        driver.get("http://localhost:8081/");
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        // Store 'Gmail' anchor web element
        List<WebElement> linksAddArticle = driver.findElements(By.linkText("Add Article"));
        WebElement linkAddArticle; //= driver.findElement(By.linkText("Add Article"));
        if(linksAddArticle.size() == 0) { // open responsive navigation if 'Add Article' link not visible
            WebElement btnNavbarToggler = driver.findElement(By.cssSelector("button.navbar-toggler"));
            btnNavbarToggler.click();
            linkAddArticle = new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.elementToBeClickable(By.linkText("Add Article")));
//            linkAddArticle = driver.findElement(By.linkText("Add Article"));
        }else {
            linkAddArticle = linksAddArticle.get(0);
        }
        linkAddArticle.click();
//        Actions actionProvider = new Actions(driver);
        // Performs mouse move action onto the element
//            actionProvider.click(linkAddArticle).build().perform();

        // Verify navigation to Add Article page
        WebElement h3 = (WebElement) new WebDriverWait(driver, Duration.ofMillis(1000))
                .until(driver -> driver.findElement(By.cssSelector(".container h3")));
        assertThat(h3.getText()).isEqualTo("Add New Article");

        // Add new article using form
        WebElement inputTitle = driver.findElement(By.name("title"));
        WebElement inputContent = driver.findElement(By.name("content"));
        WebElement btnSubmit = driver.findElement(By.name("submit"));

        inputTitle.sendKeys("Selenium");
        inputContent.sendKeys("Selenium is easy ...");
        btnSubmit.click();

        // Verify navigation to Articles List page
        WebElement container = driver.findElement(By.xpath("//div[@class='container']"));
        h3 = container.findElement(By.tagName("h3"));
        assertThat(h3.getText()).isEqualTo("Articles List");

        // Verify blog post added to Articles List page
        WebElement tdLastRowTitle = driver.findElement(By.xpath("//table//tr[last()]/td[2]"));
        WebElement tdLastRowContent = driver.findElement(By.cssSelector("table tr:last-of-type>td:nth-of-type(3)"));
        log.info("Selected title: {}", tdLastRowTitle.getText());
        log.info("Selected content: {}",tdLastRowContent.getText());
        assertThat(tdLastRowTitle.getText()).isEqualTo("Selenium");
        assertThat(tdLastRowContent.getText()).isEqualTo("Selenium is easy ...");
    }


}
