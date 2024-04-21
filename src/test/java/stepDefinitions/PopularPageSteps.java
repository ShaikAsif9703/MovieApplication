package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Pages.PopularPages;
import java.time.Duration;
import java.util.List;
public class PopularPageSteps {
    WebDriver driver;
    PopularPages popularDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        popularDriver = new PopularPages(driver);
    }
    @Given("I am in home page")
    public void moviesDisplayed(){
        popularDriver.clickOnApplication("rahul","rahul@2021");
    }
    @Then("movies are displayed or not")
    public void movies(){
        popularDriver.popularButton();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
