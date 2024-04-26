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
import Pages.HeadPages;
import java.time.Duration;
import java.util.List;
public class HeadPageSteps {
    WebDriver driver;
    HeadPages headDriver;
    WebDriverWait wait;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        headDriver = new HeadPages(driver);
    }
    @Given("I am on Home")
    public void homePage(){
        headDriver.clickOnApplication("rahul","rahul@2021");
    }
    @Then("check logo")
    public void logo(){
        headDriver.homeWebsiteLogo();
    }
    @Then("check nav elements")
    public void nav(){
        headDriver.navElements();
    }
    @Then("Navigated to home movies using home nav link")
    public void homeMovies(){
        headDriver.homeElement();
    }
    @Then("Navigated to popular movies using popular nav link")
    public void popularNav(){
        headDriver.popularElement();
    }
    @Then("checking account")
    public void account(){
        headDriver.accountElement();
    }
    @Then("Navigating to search page")
    public void navigateToSearchPage(){
        headDriver.searchElement();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
