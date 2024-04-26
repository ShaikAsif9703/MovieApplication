package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.SearchPages;
import java.time.Duration;

public class SearchPageSteps {
    WebDriver driver;
    SearchPages searchDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        searchDriver = new SearchPages(driver);
    }
    @Given("Home page")
    public void homePage(){
        searchDriver.clickOnApplication("rahul","rahul@2021");
    }
    @When("I click on search logo")
    public void search(){
        searchDriver.uiMovies();
    }
    @And("I entered the movie name")
    public void enterMovieName(){
        searchDriver.enterName();
    }
    @And("I entered the movie name of spiderman")
    public void enterSecondMovieName(){
        searchDriver.spiderman();
    }
    @Then("movie list will be displayed")
    public void movieDisplay(){
        searchDriver.noOfElements();
    }
    @Then("No movies found should be displayed")
    public void noMoivesFOund(){
        searchDriver.noMovies();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
