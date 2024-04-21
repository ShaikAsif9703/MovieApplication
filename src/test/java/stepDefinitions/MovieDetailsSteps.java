package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import Pages.MovieDetailsPages;
import org.testng.Assert;
public class MovieDetailsSteps {
    WebDriver driver;
    MovieDetailsPages movieDriver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        movieDriver = new MovieDetailsPages(driver);
    }
    @Given("I am directing to Home Page")
    public void directingToHomePage(){
        movieDriver.clickOnApplication("rahul","rahul@2021");
    }
    @Then("checking movies in home button")
    public void checkingMoviesInHomeButton(){
        movieDriver.homeMovies();
    }
    @Then("checking movies in popular button")
    public void checkingMoviesInPopularButton(){
        movieDriver.popularMovies();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
